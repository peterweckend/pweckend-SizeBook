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

        ListView listView = (ListView) findViewById(R.id.person_listview_main);
        Collection<Person> persons = PersonListController.getPersonList().getPersons();
        final ArrayList<Person> list = new ArrayList<Person>(persons);
        final ArrayAdapter<Person> personAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(personAdapter);
        personCount();

        // added a change observer
        PersonListController.getPersonList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Person> persons = PersonListController.getPersonList().getPersons();
                list.addAll(persons);
                personCount();
                personAdapter.notifyDataSetChanged();
            }

        });

        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setMessage("Delete "+list.get(position).toString()+"?");
                adb.setCancelable(true);
                final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Person person = list.get(finalPosition);
                        PersonListController.getPersonList().removePerson(person);
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                adb.show();
                return true;
            }
        });



        Button addnew_main = (Button) findViewById(R.id.addnew_button_main);
        addnew_main.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "add new", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddNew.class);
                startActivity(intent);

            }


        });

        // no adapterview in tutorials
        // +list.get(position).toString()
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "short click"+list.get(position).toString(), Toast.LENGTH_SHORT).show();

                Intent intent2 = new Intent(MainActivity.this, ViewDetails.class);
                intent2.putExtra("personList", list);
                intent2.putExtra("index", position);
                startActivity(intent2);
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        ListView listView = (ListView) findViewById(R.id.person_listview_main);
//        Collection<Person> persons = PersonListController.getPersonList().getPersons();
//        final ArrayList list = new ArrayList<Person>(persons);
//        ArrayAdapter<Person> personAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, list);
//        listView.setAdapter(personAdapter);
//        personCount();
//
//    }


    public void personCount() {
        PersonListController pc = new PersonListController();
        int size = pc.getPersonList().getPersonCount();
        Integer pcobject = ((Integer) size);

        TextView tv1 = (TextView) findViewById(R.id.countval_text_main);
        tv1.setText(pcobject.toString());
    }




}
