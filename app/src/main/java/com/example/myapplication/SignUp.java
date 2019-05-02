package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText phoneNo;
    private EditText password;
    private Button signUpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email=findViewById(R.id.boxSignUpEmail);
        password=findViewById(R.id.boxLoginPassword);
        signUpButton=findViewById(R.id.buttonSignUpAccount);
        name=findViewById(R.id.boxSignUpName);
        phoneNo=findViewById(R.id.boxSignUpNumber);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iname=name.getText().toString();
                String iemail=email.getText().toString();
                String iphoneNumber=phoneNo.getText().toString();
                String ipassword=password.getText().toString();

                validate(iname,iemail,iphoneNumber,ipassword);
            }
        });
    }



    private void validate(String name,String email,String phoneNumber, String password){

        int number;
        Toast.makeText(getApplicationContext(), "Signup successful", Toast.LENGTH_LONG).show();

        if(!name.isEmpty()&&!email.isEmpty()&&!phoneNumber.isEmpty()&&!password.isEmpty()){

            if(emailCheck(email)){

                if(phoneNumber.length()!=10) {

                    try {
                        number = Integer.parseInt(phoneNumber);

                        if(passwordChecker(password)){


                            // all input is valid
                            Toast.makeText(this, "Signup successful", Toast.LENGTH_LONG).show();

                        }

                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Please enter a valid Phone number", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this, "Phone number should be 10 digits", Toast.LENGTH_LONG).show();
                    }

            }else{
                Toast.makeText(this, "Please enter a valid Email", Toast.LENGTH_LONG).show();
            }


        }else{
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, "Password should have a minimum of 6 characters", Toast.LENGTH_LONG).show();
        }
        return retValue;
    }
}
