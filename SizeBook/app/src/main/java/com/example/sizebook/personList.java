package com.example.sizebook;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by PeterWeckend on 2017-01-28.
 */

public class personList {
    private int personCount;
    private ArrayList<Person> plist;

    public personList() {
        this.personCount = 0;
        plist = new ArrayList<Person>();

    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public Collection<Person> getPersons(){
        return plist;
    }

    public void addPerson(Person person) {
        plist.add(person);
        personCount ++;
    }

    public void removePerson(Person person) {
        plist.remove(person);
        personCount --;
    }

    public void setCount(int newcount) {
        personCount = newcount;
    }
}
