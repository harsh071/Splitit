package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activityTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
    }


    public void addClick(View view){
        startActivity(new Intent(activityTabActivity.this , Bill.class));
    }

    //go to friend tab
    public void  friendClick(View view){ // MainActivity and Friends is the same.
        startActivity(new Intent(activityTabActivity.this , MainActivity.class));
    }

    //go to groups tab

    public void groupsClick(View view){
        startActivity(new Intent(activityTabActivity.this , Groups.class));
    }

    //go to activity tab

    public void activityClick(View view){
        startActivity(new Intent(activityTabActivity.this , activityTabActivity.class));
    }
}
