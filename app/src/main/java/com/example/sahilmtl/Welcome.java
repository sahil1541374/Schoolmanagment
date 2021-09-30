package com.example.sahilmtl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Welcome extends AppCompatActivity {
    ViewFlipper flipper;
    private LinearLayout Logout;
    private LinearLayout Reg;
    private LinearLayout Book;
    private LinearLayout Certificate;
    private LinearLayout Dmc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        int imgarray[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5, R.drawable.slide6,R.drawable.slide7};
        flipper = (ViewFlipper) findViewById(R.id.flipper);

        for (int i=0;i<imgarray.length;i++)
            showimage(imgarray[i]);

    }


    public void showimage(int img)
    {

        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);
        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this,android.R.anim.slide_in_left);
        flipper.setOutAnimation(this,android.R.anim.slide_out_right);


        Logout=findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Welcome.this,home.class);
                startActivity(i);
            }
        });

           Reg=findViewById(R.id.Reg);
           Reg.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i=new Intent(Welcome.this,button1.class);
                   startActivity(i);
               }
           });

           Book=findViewById(R.id.Book);
           Book.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i=new Intent(Welcome.this,Photo.class);
                   startActivity(i);
               }
           });

        Certificate=findViewById(R.id.Certificate);
        Certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Welcome.this,changepassword.class);
                startActivity(i);
            }
        });

        Dmc=findViewById(R.id.Dmc);
        Dmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Welcome.this,mobile.class);
                startActivity(i);
            }
        });



    }
    }























































































