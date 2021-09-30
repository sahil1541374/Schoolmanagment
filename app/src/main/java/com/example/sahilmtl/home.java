package com.example.sahilmtl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity implements View.OnClickListener {
    EditText t1, t2;
    Button b1;
    private com.google.firebase.auth.FirebaseAuth FirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_home);
        t1 = (EditText) findViewById(R.id.email);
        t2 = (EditText) findViewById(R.id.pass);
        b1 = (Button) findViewById(R.id.buttonSearch);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String email = t1.getText().toString().trim();
        String pass = t2.getText().toString().trim();


        if (email.isEmpty()) {
            t1.setError("Emai Cant't Blank");
            t1.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            t2.setError("password Cant't Blank");
            t2.requestFocus();
            return;
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            t1.setError("Plz Enter Vaild Format Email");
            t1.requestFocus();
        }

        if (pass.length() < 6) {
            t2.setError("Plz Enter Minimum length pass Is 6");
            t2.requestFocus();
        }


        FirebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Log.d("MSG", "signInWithEmail:success:" + task.isSuccessful());
                        if (task.isSuccessful()) {
                            Toast.makeText(home.this, "User Login Successfull",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(home.this, Welcome.class));
                            finish();
                        }

                        // If sign in fails,display a message to the user.if sign in succeeds
                        //the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in thelistener.


                        if (!task.isSuccessful()) {
                            Log.w("MSG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(home.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });




    }

    public void newUser(View view) {

        startActivity(new Intent(home.this,signup.class));
    }
}
