/*
 * MainActivity
 *
 * MainActivity is the first page the user sees when opening the app. It contains a list view
 * of all people in the SizeBook, an option to add new entries, and a count of all people.
 * Users are added to the bottom of the listview when they are created. Tapping on a person's
 * name will open ViewDetails. Long tapping on a person's name will open a prompt to delete
 * the person should the user choose. A count in the bottom left hand corner keeps track of
 * the number of users currently in the system.
 *
 * Feb 2 2017
 *
 * I wanted to keep a consistent layout throughout the app:
 * Data in the top area, a button centrally located in the bottom center, and any additional
 * information on the bottom sides. I didn't want any extra "delete", "edit", or "view details"
 * buttons next to every name cluttering up the screen, so I used tap and long tap to implement
 * those instead to keep the design cleaner looking.
 *
 * The only outstanding issue for MainActivity is that the "All Entries" title is closer to
 * the top row than I would like ideally. Editing the xml document to increase the title's
 * wrapping should fix the problem. Listeners helped update the main activity instantaneously.
 */

package com.example.sizebook;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;
import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonListManager.initManager(this.getApplicationContext());

        // grabs array for home screen
        ListView listView = (ListView) findViewById(R.id.person_listview_main);
        Collection<Person> persons = PersonListController.getPersonList().getPersons();
        final ArrayList<Person> list = new ArrayList<Person>(persons);
        final ArrayAdapter<Person> personAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(personAdapter);
        personCount(); // update number of people in arraylist

        // a change observer
        PersonListController.getPersonList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Person> persons = PersonListController.getPersonList().getPersons();
                list.addAll(persons);
                personCount(); // update number of people in arraylist
                personAdapter.notifyDataSetChanged();
            }

        });

        // if a person is long clicked, show option to delete
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setMessage("Delete "+list.get(position).toString()+"?");
                adb.setCancelable(true);
                final int finalPosition = position;
                // if they delete
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Person person = list.get(finalPosition);
                        PersonListController.getPersonList().removePerson(person);
                    }
                });
                // if they choose not to delete
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                adb.show();
                return true;
            }
        });


        // called when user tries to add new and presses AddNew button
        Button addnew_main = (Button) findViewById(R.id.addnew_button_main);
        addnew_main.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "add new", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddNew.class);
                startActivity(intent);

            }


        });


        // normal tap on listview item, views more details
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "short click"+list.get(position).toString(), Toast.LENGTH_SHORT).show();

                Intent intent2 = new Intent(MainActivity.this, ViewDetails.class);
                intent2.putExtra("personList", list);   // send personList
                intent2.putExtra("index", position);    // send index of tapped Person
                startActivity(intent2);
            }
        });
    }

    // retrieves the number of Persons on the ArrayList
    public void personCount() {
        PersonListController pc = new PersonListController();
        int size = pc.getPersonList().getPersonCount();
        Integer pcobject = ((Integer) size);

        TextView tv1 = (TextView) findViewById(R.id.countval_text_main);
        tv1.setText(pcobject.toString());
    }




}
