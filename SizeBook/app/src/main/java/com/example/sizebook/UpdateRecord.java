/*
 * UpdateRecord
 *
 * UpdateRecord enables users to edit and change existing Persons. The edited object is pulled
 * from ViewDetails, which sends the index of the object to update. The Person's attribute
 * values are displayed as an editable form with the values preloaded. Like AddNew, measures
 * exist to ensure the user enters valid input (ex: only numbers for Neck, Bust, Chest, etc.)
 * and all numbers are rounded to the nearest 1/2.
 *
 *
 * Feb 2 2017
 *
 * Like the other activities, the one button is centered on the bottom. I added in field names
 * for each of the values so the user could tell them apart and know which field corresponds to
 * which value. Formatting instructions for date were included.
 *
 * There are no issues with this class that I know of.
 */

package com.example.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Updates a Person's record, more details in above comments
public class UpdateRecord extends AppCompatActivity {
    private Person personu;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        PersonListManager.initManager(this.getApplicationContext());
        // retrive what person we want to update
        personu = (Person) getIntent().getSerializableExtra("person");
        index = getIntent().getIntExtra("index", 0);

        // set all fields to show the attribute values of the correct Person
        TextView nametext = (TextView) findViewById(R.id.name_field_updaterecord);
        nametext.setText(personu.getName());

        Date date = personu.getDate();
        // retrieve date
        TextView datetext = (TextView) findViewById(R.id.date_field_updaterecord);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // put date into proper yyyy-mm-dd format
            date = format.parse(datetext.getText().toString());
        } catch(ParseException e) {
            e.printStackTrace();
        }
        // set date field to date
        datetext.setText(format.format(date));

        TextView necktext = (TextView) findViewById(R.id.neck_field_updaterecord);
        necktext.setText(personu.getNeck().toString());

        TextView busttext = (TextView) findViewById(R.id.bust_field_updaterecord);
        busttext.setText(personu.getBust().toString());

        TextView chesttext = (TextView) findViewById(R.id.chest_field_updaterecord);
        chesttext.setText(personu.getChest().toString());

        TextView waisttext = (TextView) findViewById(R.id.waist_field_updaterecord);
        waisttext.setText(personu.getWaist().toString());

        TextView hiptext = (TextView) findViewById(R.id.hip_field_updaterecord);
        hiptext.setText(personu.getHip().toString());

        TextView inseamtext = (TextView) findViewById(R.id.inseam_field_updaterecord);
        inseamtext.setText(personu.getInseam().toString());

        TextView commenttext = (TextView) findViewById(R.id.comment_field_updaterecord);
        commenttext.setText(personu.getComment().toString());

        // when the update button is pressed, this occurs
        Button edit_viewdetail = (Button) findViewById(R.id.update_button_updaterecord);
        edit_viewdetail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Record Updated", Toast.LENGTH_SHORT).show();

                EditText values = (EditText) findViewById(R.id.name_field_updaterecord);
                String name = values.getText().toString();


                EditText values2 = (EditText) findViewById(R.id.date_field_updaterecord);

                Date date = new Date();
                // convert string in certain format to proper date object
                String enterdate_string = values2.getText().toString();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = format.parse(enterdate_string);
                } catch(ParseException e) {
                    e.printStackTrace();
                }

                // set all values to the edited versions
                EditText values3 = (EditText) findViewById(R.id.neck_field_updaterecord);
                float neck = Float.valueOf(values3.getText().toString());
                neck = (float) (Math.round(neck * 2) / 2.0);  // round to nearest 1/2

                EditText values4 = (EditText) findViewById(R.id.bust_field_updaterecord);
                float bust = Float.valueOf(values4.getText().toString());
                bust = (float) (Math.round(bust * 2) / 2.0);

                EditText values5 = (EditText) findViewById(R.id.chest_field_updaterecord);
                float chest = Float.valueOf(values5.getText().toString());
                chest = (float) (Math.round(chest * 2) / 2.0);

                EditText values6 = (EditText) findViewById(R.id.waist_field_updaterecord);
                float waist = Float.valueOf(values6.getText().toString());
                waist = (float) (Math.round(waist * 2) / 2.0);

                EditText values7 = (EditText) findViewById(R.id.hip_field_updaterecord);
                float hip = Float.valueOf(values7.getText().toString());
                hip = (float) (Math.round(hip * 2) / 2.0);

                EditText values8 = (EditText) findViewById(R.id.inseam_field_updaterecord);
                float inseam = Float.valueOf(values8.getText().toString());
                inseam = (float) (Math.round(inseam * 2) / 2.0);

                EditText values9 = (EditText) findViewById(R.id.comment_field_updaterecord);
                String comment = values9.getText().toString();

                // update person (in PersonListController) to new values
                PersonListController updatept = new PersonListController();
                updatept.updatePerson(index, name, date, neck, bust, chest, waist,hip,inseam, comment);

                Intent intent = new Intent(UpdateRecord.this, MainActivity.class);
                startActivity(intent);
            }


        });



    }
}
