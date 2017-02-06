package com.example.sizebook;

import android.widget.EditText;

import java.io.IOException;
import java.util.Date;

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

    public void updatePerson(int index, String name, Date date, float neck, float bust, float chest, float waist, float hip, float inseam, String comment) {
        Person person = findPerson(index);

        person.setName(name);
        person.setDate(date);
        person.setNeck(neck);
        person.setBust(bust);
        person.setChest(chest);
        person.setWaist(waist);
        person.setHip(hip);
        person.setInseam(inseam);
        person.setComment(comment);

    }

    public Person findPerson(int index) {
        return getPersonList().getPerson(index);
    }
}
