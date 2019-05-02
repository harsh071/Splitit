package com.example.myapplication;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText phoneNo;
    private EditText password;
    private Button signUpButton;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth=FirebaseAuth.getInstance();

        email=findViewById(R.id.boxSignUpEmail);
        password=findViewById(R.id.boxSignUpPassword);
        signUpButton=findViewById(R.id.buttonSignUpAccount);
        name=findViewById(R.id.boxSignUpName);
        phoneNo=findViewById(R.id.boxSignUpNumber);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iname=name.getText().toString().trim();
                String iemail=email.getText().toString().trim();
                String iphoneNumber=phoneNo.getText().toString().trim();
                String ipassword=password.getText().toString();

                validate(iname,iemail,iphoneNumber,ipassword);
            }
        });
    }



    private void validate(String name,String email,String phoneNumber, String password){

        int number;

        if(!name.isEmpty()&&!email.isEmpty()&&!phoneNumber.isEmpty()&&!password.isEmpty()){

            if(emailCheck(email)){

                if(phoneNumber.length()==10) {

                        if(passwordChecker(password)){

                            // CREATE A NEW PERSON
                            Person newUser=new Person(name,email,phoneNumber,password);
                            // ADD USER TO THE DATABASE

                            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){

                                        Toast.makeText(SignUp.this, "Sign up Successful!", Toast.LENGTH_LONG).show();
                                        Intent signedUp=new Intent(SignUp.this,Login.class);
                                        startActivity(signedUp);

                                    }else{

                                        Toast.makeText(SignUp.this, "Sign Up Failed, Network Problem", Toast.LENGTH_LONG).show();

                                    }

                                }
                            });






                        }
                }else{
                    Toast.makeText(this, "Phone number should be 10 digits", Toast.LENGTH_SHORT).show();
                    }

            }else{
                Toast.makeText(this, "Please enter a valid Email", Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean emailCheck(String email){

        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        boolean retvalue=false;

        if(mat.matches()){
            retvalue=true;

        }

        return retvalue;
    }


    public boolean passwordChecker(String password){

        boolean retValue=false;
        if(password.length()>=6){
            retValue=true;
        }else{
            Toast.makeText(this, "Password should have a minimum of 6 characters", Toast.LENGTH_SHORT).show();
        }
        return retValue;
    }
}
