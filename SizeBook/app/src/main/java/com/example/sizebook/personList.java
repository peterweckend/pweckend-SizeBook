/*
 * personList
 *
 * personList is a collection of Person objects. personList has methods to let one get
 * the size of the list, fetch specific Persons in the list, add or remove Persons from
 * the list, and finally contains methods for SizeBook Listeners. Listeners can be
 * retrieved, added, removed, and notified.
 *
 * Feb 3 2017
 *
 * All the basic app tutorials and examples I looked had a class for the main object's list,
 * and this class has methods and functionality that would not be possible (or useful) if they
 * were put inside Person.java.
 *
 * There are no outstanding issues with this page that I know of.
 */

package com.example.sizebook;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by PeterWeckend on 2017-01-28.
 */

public class personList implements Serializable {

    // missing serialVersionUID, doesn't show up
    protected ArrayList<Person> plist = null;
    protected transient ArrayList<Listener> listeners = null;

    public personList() {
        plist = new ArrayList<Person>();
        listeners = new ArrayList<Listener>();


    }

    private ArrayList<Listener> getListeners() {
        if (listeners == null){
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }

    public int getPersonCount() {
        return plist.size();
    }


    public Collection<Person> getPersons(){
        return plist;
    }

    public Person getPerson(int index){
        return plist.get(index);
    }

    public void addPerson(Person person) {
        plist.add(person);
        notifyListeners();

    }

    private void notifyListeners() {
        for (Listener listener : getListeners()) {
            listener.update();
        }
    }

//    private void readObject(java.io.ObjectInputStream in)
//            throws IOException, ClassNotFoundException {
//        //super.readObject(in);
//        listeners = new ArrayList<Listener>();
//    }

    public void removePerson(Person person) {
        plist.remove(person);
        notifyListeners();

    }

    // probably not needed
    public static boolean contains(Person testPerson){
        return personList.contains(testPerson);
    }

    public void addListener(Listener l) {
        getListeners().add(l);
    }

    public void removeListener(Listener l){
        getListeners().remove(l);
    }

    // many missing methods from video not added; used for testing?


}
