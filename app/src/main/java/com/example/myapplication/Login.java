package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button loginButton;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email= findViewById(R.id.emailLoginBox);
        password=findViewById(R.id.boxLoginPassword);
        loginButton=findViewById(R.id.buttonLogin2);
        signUpButton=findViewById(R.id.loginPageSignUpButton);


        loginButton.setOnClickListener(new View.OnClickListener() { // listens to the login button
            @Override
            public void onClick(View v) {

                // validates the credintals
                validateCredintals(email.getText().toString(),password.getText().toString());


            }
        });


        signUpButton.setOnClickListener(new View.OnClickListener() { // listens to the login button
            @Override
            public void onClick(View v) {

                // takes to sign in page
                Intent signIn=new Intent(Login.this,SignUp.class);
                startActivity(signIn);

            }
        });
    }

    private void validateCredintals(String email, String password){

        if(email.equals("11")&&password.equals("11")){  // temporary credintals

            Intent logIn=new Intent(Login.this,MainActivity.class);
            startActivity(logIn);

        }else{
            Toast.makeText(getApplicationContext(), "INVALID EMAIL OR PASSWORD", Toast.LENGTH_LONG).show();
        }
    }
}
