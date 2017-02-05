package com.example.sizebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Created by PeterWeckend on 2017-02-05.
 */

public class PersonListManager {
    static final String prefFile = "PersonList";
    static final String plKey = "personList";

    Context context;

    static private PersonListManager personListManager = null;

    public static void initManager(Context context) {
        if (personListManager == null) {
            if (context == null) {
                throw new RuntimeException("missing context for PersonListManager");
            }
            personListManager = new PersonListManager(context);
        }
    }


    public static PersonListManager getManager() {
        if (personListManager == null) {
            throw new RuntimeException("did not initialize Manager");
        }
        return personListManager;
    }

    public PersonListManager(Context context) {
        this.context = context;
    }

    public personList loadPersonList() throws IOException, ClassNotFoundException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String personListData = settings.getString(plKey, "");
        if (personListData.equals("")){
            return new personList();
        } else {
            return personListFromString(personListData);
        }
    }

    static public personList personListFromString(String personListData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(personListData, Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (personList) oi.readObject();

    }

    static public String personListToString(personList pl) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(pl);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public void savePersonList(personList pl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(plKey, personListToString(pl));
        editor.commit();
    }


}
