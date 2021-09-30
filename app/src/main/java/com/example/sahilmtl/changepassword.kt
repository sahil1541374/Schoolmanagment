package com.example.sahilmtl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_changepassword.*

class changepassword : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepassword)

        auth = FirebaseAuth.getInstance()
        btn_change_password.setOnClickListener {

            changepassword()

        }
    }
    private fun changepassword(){

        if(et_current_password.text.isNotEmpty() &&
                et_new_password.text.isNotEmpty() &&
                et_confirm_password.text.isNotEmpty()){

            if(et_new_password.text.toString().equals(et_confirm_password.text.toString())){

                val user : FirebaseUser?= auth.currentUser
                if(user != null &&user.email !=null){
                    val credential : AuthCredential = EmailAuthProvider
                            .getCredential(user.email!!, et_current_password.text.toString())

// Prompt the user to re-provide their sign-in credentials
                    user?.reauthenticate(credential)
                            ?.addOnCompleteListener {

                                if(it.isSuccessful) {

                                    Toast.makeText(this,"Password Success.", Toast.LENGTH_SHORT)
                                            .show()

                                    user?.updatePassword(et_new_password.text.toString())
                                            ?.addOnCompleteListener { task ->
                                                if (task.isSuccessful) {

                                                    Toast.makeText(this,"Password changed.", Toast.LENGTH_SHORT)
                                                            .show()
                                                    auth.signOut()
                                                }
                                            }
                                }else {

                                    Toast.makeText(this,"Please Enter Correct Current Password.", Toast.LENGTH_SHORT)
                                            .show()
                                }

                            }


                }else{
                    startActivity(Intent(this,home::class.java))
                    finish()
                }

            }else{

                Toast.makeText(this,"Password missmatching.", Toast.LENGTH_SHORT)
                        .show()
            }

        }else{
            Toast.makeText(this,"please enter all the fields.", Toast.LENGTH_SHORT)
                    .show()
        }

    }
}
