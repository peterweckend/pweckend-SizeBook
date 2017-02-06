/*
 * PersonListController
 *
 * Controller used to access personList built with the help of the Student Picker tutorials.
 * Lets you get the personList, save the personList, as well as add, find and update individual
 * users in the personList based on their index.
 *
 * Feb 4 2017
 *
 * The design of this class was built almost exclusively with the help of online tutorials and
 * the Student Picker videos' guidance. Adding, finding, and updating person was based off
 * similar functions for personList, but applied to an individual person.
 *
 * There are no outstanding issues with this page that I know of.
 */

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
