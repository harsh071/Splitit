package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Bill extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
    }

    public void addClick(View view){
        ProgressBar tl = (ProgressBar)findViewById(R.id.progressBar);

        tl.setVisibility(View.VISIBLE);
        Button b1 = (Button) findViewById(R.id.add);

        tl.setVisibility(View.VISIBLE);
        b1.setVisibility(view.INVISIBLE);
        Toast.makeText(this,"Bill has been added!", Toast.LENGTH_LONG).show();
        thread.start();

    }
    public void HomeClick(View view) {
        startActivity(new Intent(Bill.this , MainActivity.class));
    }
    Thread thread = new Thread(){
        @Override
        public void run() {
            try {

                Thread.sleep(1800); // As I am using LENGTH_LONG in Toast
                startActivity(new Intent(Bill.this , MainActivity.class));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
