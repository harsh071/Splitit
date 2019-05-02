package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableRow;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=(TabLayout)findViewById(R.id.tab_id);
        appBarLayout=(AppBarLayout)findViewById(R.id.homeBar);
        viewPager=(ViewPager)findViewById(R.id.view_pager);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());

        // adding the fragments
        adapter.addFragment(new FragmentFriends(),"Friends");
        adapter.addFragment(new FragmentGroups(),"Groups");
        adapter.addFragment(new FragmentActivity(),"Activity");

        // adapter setup

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


}
