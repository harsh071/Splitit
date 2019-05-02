package com.example.myapplication;


import java.util.ArrayList;

// stores the user information
public class Person {

    private String name;                    // name of person
    private String email;                   // email of person
    private String phoneNo;                 // phone number of person
    private String password;                // password of person
    private ArrayList<Expense> expenses;    // The expense history of person
    private ArrayList<Person> friends;      // THe friends of this person
    private int owe;    // amount they owe
    private int owed;   // amount owed


    //------------------------------------------------------
    // Person
    //
    // PURPOSE:   Constructor
    //-----------------------------------------------------
    public Person(String name,String email,String phoneNo,String password){

        this.name=name;
        this.email=email;
        this.phoneNo=phoneNo;
        this.password=password;
    }



    //------------------------------------------------------
    // addFriend
    //
    // PURPOSE:   adds friend to this person
    //-----------------------------------------------------
    public void addFriend(Person person){
        friends.add(person);
    }

    public void addExpense(Expense e, int valueOwed, int valueOwe){
        expenses.add(e);
        owe+=valueOwe;
        owed+=valueOwed;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}