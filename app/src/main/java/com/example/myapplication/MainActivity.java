package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;



public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private RecyclerView friendsList;
    private FirebaseFirestore firestore;
    private List<Friend> fList;
    private FriendsListAdapter friendsListAdapter;



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


        //Friends list.
        fList = new ArrayList<>();
        friendsListAdapter = new FriendsListAdapter(fList);

        friendsList = findViewById(R.id.friend_list);
        friendsList.setHasFixedSize(true);
        friendsList.setLayoutManager(new LinearLayoutManager(this));
        friendsList.setAdapter(friendsListAdapter);

        firestore = FirebaseFirestore.getInstance();

        firestore.collection("Friends").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange doc: queryDocumentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){
                        String name =  doc.getDocument().getString("Name");
                        double owes =  doc.getDocument().getDouble("Owes");

                        Friend friend  = new Friend(name,owes);
                        fList.add(friend);

                        friendsListAdapter.notifyDataSetChanged();
                    }
                }
            }
        });



    }

    void menuClick(View view){
        startActivity(new Intent(MainActivity.this,Menu.class));
    }




}
