package com.example.sahilmtl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class button1 extends AppCompatActivity {
    Button buttonSearch,add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        buttonSearch= findViewById(R.id.buttonSearch);
        add=findViewById(R.id.add);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(button1.this,newReg.class);
                    startActivity(i);
            }
        });


    }
}
