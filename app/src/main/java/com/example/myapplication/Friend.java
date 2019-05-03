package com.example.myapplication;

public class Friend {
    private String name;
    private double owes;

    public Friend(){

    }
    public Friend(String name, double owes) {
        this.name = name;
        this.owes = owes;
    }

    public String getName() {
        return name;
    }

    public double getOwes() {
        return owes;
    }

    public void setOwes(float owes) {
        this.owes = owes;
    }

    public void setName(String name) {
        this.name = name;
    }
}
