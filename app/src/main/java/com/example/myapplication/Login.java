package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button loginButton;
    private Button signUpButton;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();

        FirebaseUser user=firebaseAuth.getCurrentUser();    // get current user

        if(user!=null){     // if user has already logged in
            finish();
            Intent logIn=new Intent(Login.this,MainActivity.class);
            startActivity(logIn);
        }

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

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Logging In");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();

                    finish();
                    Intent logIn=new Intent(Login.this,MainActivity.class);
                    startActivity(logIn);

                }else{
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "INVALID EMAIL OR PASSWORD", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}


