package com.example.sizebook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by PeterWeckend on 2017-01-28.
 */

public class personList implements Serializable {

    // missing serialVersionUID, doesn't show up
    protected ArrayList<Person> plist;
    protected ArrayList<Listener> listeners;

    public personList() {
        plist = new ArrayList<Person>();
        listeners = new ArrayList<Listener>();


    }

    public int getPersonCount() {
        return plist.size();
    }


    public Collection<Person> getPersons(){
        return plist;
    }

    public void addPerson(Person person) {
        plist.add(person);
        notifyListeners();

    }

    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public void removePerson(Person person) {
        plist.remove(person);
        notifyListeners();

    }

    // probably not needed
    public static boolean contains(Person testPerson){
        return personList.contains(testPerson);
    }

    public void addListener(Listener l) {
        listeners.add(l);
    }

    public void removeListener(Listener l){
        listeners.remove(l);
    }

    // many missing methods from video not added; used for testing?


}
