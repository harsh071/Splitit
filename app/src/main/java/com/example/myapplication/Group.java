package com.example.myapplication;

import java.util.ArrayList;

public class Group {

    private String groupName;
    private ArrayList<Person> people;   // people involved

    public Group(String name,ArrayList<Person> people){
        this.people=people;
        groupName=name;
    }

    public void add(Person p){
        people.add(p);
    }

    public void remove(Person p){
        people.remove(p);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}
