/*
 * AddNew
 *
 * Activity that lets user add a new user to their Sizebook. Name is required, and you
 * will be unable to submit without a valid name. All fields must have valid characters.
 * Ex: you cannot type in letters while filling out the Neck field, and no special characters
 * or letters can be entered in the date field.
 * Additionally, all number fields (neck, bust, chest, etc.) will round to the nearest half.
 * Ex: 8.566 will round to 8.5 and 3.98 will round to 4.
 * Values not filled out by the user will be automatically created by the app. The date will
 * be replaced with the current date if not filled out, comments will be blank, and the
 * measurements will be 0.
 *
 * Feb 3 2017
 *
 * I tried to pick a clean, simple style for adding users. Adding field hints helped users
 * identify which areas to fill out for which information, and a create button on the bottom
 * seemed to be the most effective solution. I tried to emulate Add New activities I've seen
 * in other apps I've used.
 *
 * There are no outstanding issues with this class that I know of. Previously there were
 * issues updating MainActivity after an entry was added but this was solved with Listeners.
 * There were also issues limiting input to the required type but I changed the text fields to
 * only accept the right types.
 */

package com.example.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        PersonListManager.initManager(this.getApplicationContext());

    }

    // when add button is clicked, addPersonAction is called
    public void addPersonAction(View v){

        // if date not entered, get current date
        Date date = new Date();
        EditText enterdate = (EditText) findViewById(R.id.date_field_addnew);
        if (enterdate.getText().toString().trim().length() == 0) {

        } else {
            String enterdate_string = enterdate.getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(enterdate_string);
            } catch(ParseException e) {
                e.printStackTrace();
            }
        }

        // for all other values, if not entered, put 0 or "" by default
        float neck;
        EditText values = (EditText) findViewById(R.id.neck_field_addnew);
        if (values.getText().toString().trim().length() == 0){
            neck = 0;
        }
        else{
            neck = Float.valueOf(values.getText().toString());
            neck = (float) (Math.round(neck * 2) / 2.0);
        }


        float bust;
        EditText values2 = (EditText) findViewById(R.id.bust_field_addnew);
        if (values2.getText().toString().trim().length() == 0){
            bust = 0;
        }
        else{
            bust = Float.valueOf(values2.getText().toString());
            bust = (float) (Math.round(bust * 2) / 2.0);
        }


        float chest;
        EditText values3 = (EditText) findViewById(R.id.chest_field_addnew);
        if (values3.getText().toString().trim().length() == 0){
            chest = 0;
        }
        else{
            chest = Float.valueOf(values3.getText().toString());
            chest = (float) (Math.round(chest * 2) / 2.0);
        }


        float waist;
        EditText values4 = (EditText) findViewById(R.id.waist_field_addnew);
        if (values4.getText().toString().trim().length() == 0){
            waist = 0;
        }
        else{
            waist = Float.valueOf(values4.getText().toString());
            waist = (float) (Math.round(waist * 2) / 2.0);
        }


        float hip;
        EditText values5 = (EditText) findViewById(R.id.hip_field_addnew);
        if (values5.getText().toString().trim().length() == 0){
            hip = 0;
        }
        else{
            hip = Float.valueOf(values5.getText().toString());
            hip = (float) (Math.round(hip * 2) / 2.0);
        }


        float inseam;
        EditText values6 = (EditText) findViewById(R.id.inseam_field_addnew);
        if (values6.getText().toString().trim().length() == 0){
            inseam = 0;
        }
        else{
            inseam = Float.valueOf(values6.getText().toString());
            inseam = (float) (Math.round(inseam * 2) / 2.0);
        }


        String comments;
        EditText values7 = (EditText) findViewById(R.id.comment_field_addnew);
        if (values7.getText().toString().trim().length() == 0){
            comments = "";
        }
        else{
            comments = values7.getText().toString();
        }



        EditText textView = (EditText) findViewById(R.id.name_field_addnew);

        // make sure the name was entered
        if (textView.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Name Required.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            PersonListController pt = new PersonListController();

            pt.addPerson(new Person(textView.getText().toString(), date, neck, bust, chest, waist, hip, inseam, comments));
            Toast.makeText(this, "Person Added.", Toast.LENGTH_SHORT).show();

            finish();
        }
    }

}
