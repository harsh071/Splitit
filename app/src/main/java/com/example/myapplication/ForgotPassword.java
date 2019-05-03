package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        firebaseAuth=FirebaseAuth.getInstance();
    }

    void resetPass(View view){

        email=(EditText)findViewById(R.id.emailPasswordResetBox);
        String strEmail=email.getText().toString().trim();

        if(!strEmail.isEmpty()){
            firebaseAuth.sendPasswordResetEmail(strEmail);
            Toast.makeText(getApplicationContext(), "EMAIL SENT!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ForgotPassword.this,Login.class));

        }else{
            Toast.makeText(getApplicationContext(), "ENTER A VALID EMAIL!", Toast.LENGTH_SHORT).show();
        }

    }
}
