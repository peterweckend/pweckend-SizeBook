package com.example.sizebook;

import java.io.IOException;

/**
 * Created by PeterWeckend on 2017-02-04.
 */

public class PersonListController {

    // lazy singleton
    private static personList plist = null;

    static public personList getPersonList() {
        if (plist == null) {
            try {
                plist = PersonListManager.getManager().loadPersonList();
                plist.addListener(new Listener() {
                    @Override
                    public void update() {
                        savePersonList();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize PersonList from PersonListManager");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize PersonList from PersonListManager");

            }
        }
        return plist;
    }

    static public void savePersonList() {
        try {
            PersonListManager.getManager().savePersonList(getPersonList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not deserialize PersonList from PersonListManager");
        }
    }


    public void addPerson(Person person){
        getPersonList().addPerson(person);
    }

//    public void getCount(){
//        getPersonList().getPersonCount();
//    }
}
