package com.example.myapplication;

import java.util.ArrayList;

public class Expense {

    private String expenseName;
    private Person payee;
    private ArrayList<Person> people;   // people involved
    private int numPersons;
    private int amount;                  // The value that is split

    public Expense(String name,Person payee, int amount,ArrayList<Person> people){
        this.people=people;
        expenseName=name;
        this.payee=payee;
        this.amount=amount;
        numPersons=people.size();
        calculate();
    }

    public Expense(String name,Person payee, int amount,Group g){
        this.people=g.getPeople();
        expenseName=name;
        this.payee=payee;
        this.amount=amount;
        numPersons=people.size();
        calculate();
    }

    public void calculate(){

        int perHead=amount/(numPersons*1);


        for(int i=0;i<numPersons;i++){  // split expense among everyone

            if(!people.get(i).equals(payee))
                people.get(i).addExpense(this,0,perHead);
            else
                payee.addExpense(this,amount-perHead,0);    // the payee

        }
    }




}
