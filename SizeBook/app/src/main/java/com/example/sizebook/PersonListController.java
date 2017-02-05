package com.example.sizebook;

/**
 * Created by PeterWeckend on 2017-02-04.
 */

public class PersonListController {

    // lazy singleton
    private static personList plist = null;

    static public personList getPersonList() {
        if (plist == null) {
            plist = new personList();
        }
        return plist;
    }

    public void addPerson(Person person){
        getPersonList().addPerson(person);
    }

//    public void getCount(){
//        getPersonList().getPersonCount();
//    }
}
