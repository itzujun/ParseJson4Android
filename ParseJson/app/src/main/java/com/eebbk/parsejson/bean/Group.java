package com.eebbk.parsejson.bean;

import java.util.ArrayList;

public class Group{
    private ArrayList<Person> personList;

    public Group(ArrayList<Person> personList){
        this.personList = personList;
    }

    public ArrayList<Person> getPersonList(){
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList){
        this.personList = personList;
    }
}
