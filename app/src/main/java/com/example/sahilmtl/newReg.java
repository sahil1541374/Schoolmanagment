package com.example.sahilmtl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Selection;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Calendar;

public class

newReg extends AppCompatActivity {

    EditText student, father, mother, aadhar, dob, mobile, address;
    RadioButton rMale,rfmale;
    Spinner scaste, srel, smed, sdes, sreg;
    Button buttonSearch;
    DatabaseReference databaseReference;






    String class1[] = {"Select", "Gen", "Obc", "Sc", "St"};
    String class2[] = {"Select", "BUDDHIST", "CHRISTAN", "HINDU", "MUSLIM", "OTHER", "PARSI", "SIKH"};
    String class3[] = {"Select", "ENGLISH", "PUNJABI"};
    String class4[] = {"Select", "YES", "NO"};
    String class5[] = {"Select", "Pre Primary 1", "Pre Primary 2", "Class 1st", "Class 2nd", "Class 3rd", "Class 4th", "Class 5th"};

    

    public newReg() {
        // Required empty public constructor
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reg);
        student = findViewById(R.id.student);
        father = findViewById(R.id.father);
        mother = findViewById(R.id.mother);
        aadhar = findViewById(R.id.aadhar);
        dob = findViewById(R.id.dob);
        scaste = findViewById(R.id.scaste);
        srel = findViewById(R.id.srel);
        smed = findViewById(R.id.smed);
        sdes = findViewById(R.id.sdes);
        sreg = findViewById(R.id.sreg);
        mobile = findViewById(R.id.admision);
        address = findViewById(R.id.address);
        buttonSearch = findViewById(R.id.buttonSearch);

        rMale = findViewById(R.id.rMale);
        rfmale = findViewById(R.id.rFmale);




        databaseReference = FirebaseDatabase.getInstance().getReference("school");




        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        newReg.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        dob.setText(date);
                    }
                } , year,month,day);
                datePickerDialog.show();

            }
        });


        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,class1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scaste.setAdapter(arrayAdapter);
        scaste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



                scaste.setSelection(i);




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {






            }
        });



        ArrayAdapter<String>arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,class2);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        srel.setAdapter(arrayAdapter1);
        srel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



                srel.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


        ArrayAdapter<String>arrayAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,class3);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smed.setAdapter(arrayAdapter2);
        smed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                smed.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String>arrayAdapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,class4);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sdes.setAdapter(arrayAdapter3);
        sdes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sdes.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String>arrayAdapter4=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,class5);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sreg.setAdapter(arrayAdapter4);
        sreg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sreg.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aadhar1 = aadhar.getText().toString();
                String student1 = student.getText().toString();
                String father1 = father.getText().toString();
                String mother1 = mother.getText().toString();
                String dob1 = dob.getText().toString();
                String mobile1 = mobile.getText().toString();
                String address1 = address.getText().toString();
                String rMale1 = rMale.getText().toString();
                String rfmale1 = rfmale.getText().toString();

                String scaste1= (String) scaste.getSelectedItem();
                String srel1= (String) srel.getSelectedItem();
                String smed1= (String) smed.getSelectedItem();
                String sdes1= (String) sdes.getSelectedItem();
                String sreg1= (String) sreg.getSelectedItem();



                if(student1.isEmpty()){
                    student.setError("Please Enter Student Name");
                    student.requestFocus();
                    return;

                }


                if(father1.isEmpty()){
                    father.setError("Please Enter Father Name");
                    father.requestFocus();
                    return;
                }


                if(mother1.isEmpty()){
                    mother.setError("please Enter mother Name");
                    mother.requestFocus();
                    return;
                }




                if (aadhar1.isEmpty()){
                   aadhar.setError("Aadhar card cannot Blanck");
                   aadhar.requestFocus();
                   return;
               }

               if(aadhar1.length() <12){
                   aadhar.setError("Must Enter Correct Adhar Card Number");
                   aadhar.requestFocus();
                   return;
               }





               if(dob1.isEmpty()){
                   dob.setError("please Enter dob");
                   dob.requestFocus();
                   return;
               }

               if(mobile1.isEmpty()){
                   mobile.setError("please Enter Mobile Number");
                   mobile.requestFocus();
                   return;
               }

               if(mobile1.length()<10){
                   mobile.setError("Please Enter Correct Mobile Number");
                   mobile.requestFocus();
                   return;
               }

               if(address1.isEmpty()){
                   address.setError("Please Enter address");
                   address.requestFocus();
                   return;
               }

                if (scaste.getSelectedItem().toString().equals("Session")) {
                    Toast.makeText(getApplication(), "please select session", Toast.LENGTH_SHORT).show();
                }












                String id = databaseReference.push().getKey();
                dataex dataex = new dataex(id, aadhar1, student1, father1, mother1,dob1,scaste1,mobile1,address1,rMale1,rfmale1,srel1,smed1,sdes1,sreg1);
                databaseReference.child(aadhar1).setValue(dataex);

                Toast.makeText(newReg.this, "save", Toast.LENGTH_LONG).show();


            }
        });




    }




}
