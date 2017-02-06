/*
 * ViewDetails
 *
 * ViewDetails enables users to view the information of Persons. The object information is pulled
 * from MainActivity, and the index of the selected ListView item is passed on to ViewDetails,
 * which is used to find the selected object. The Person's attribute
 * values are displayed as textviews with their values. At the bottom of the screen is a button
 * to edit the selected Person.
 *
 * Feb 2 2017
 *
 * Like the other activities, the one button is centered on the bottom. I added in field names
 * for each of the values so the user could tell them apart and know which field corresponds to
 * which value.
 *
 * There are no issues with this class that I know of.
 */

package com.example.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ViewDetails extends AppCompatActivity {
    private int index;
    private ArrayList<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        PersonListManager.initManager(this.getApplicationContext());


        personList = (ArrayList<Person>) getIntent().getSerializableExtra("personList");
        index = getIntent().getIntExtra("index", 0);
        final Person person = personList.get(index);

        TextView nametext = (TextView) findViewById(R.id.name_field_viewdetail);
        nametext.setText(person.getName());


        Date date = person.getDate();
        TextView datetext = (TextView) findViewById(R.id.date_field_viewdetail);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(datetext.getText().toString());
        } catch(ParseException e) {
            e.printStackTrace();
        }
        datetext.setText(format.format(date));


        TextView necktext = (TextView) findViewById(R.id.neck_field_viewdetail);
        necktext.setText(person.getNeck().toString());

        TextView busttext = (TextView) findViewById(R.id.bust_field_viewdetail);
        busttext.setText(person.getBust().toString());

        TextView chesttext = (TextView) findViewById(R.id.chest_field_viewdetail);
        chesttext.setText(person.getChest().toString());

        TextView waisttext = (TextView) findViewById(R.id.waist_field_viewdetail);
        waisttext.setText(person.getWaist().toString());

        TextView hiptext = (TextView) findViewById(R.id.hip_field_viewdetail);
        hiptext.setText(person.getHip().toString());

        TextView inseamtext = (TextView) findViewById(R.id.inseam_field_viewdetail);
        inseamtext.setText(person.getInseam().toString());

        TextView commenttext = (TextView) findViewById(R.id.comment_field_viewdetail);
        commenttext.setText(person.getComment().toString());


        Button edit_viewdetail = (Button) findViewById(R.id.edit_button_viewdetail);
        edit_viewdetail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "edit record", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewDetails.this, UpdateRecord.class);
                intent.putExtra("person", person);
                intent.putExtra("index", index);
                startActivity(intent);

            }


        });

    }


//    public String convertStringToDate(Date indate)
//    {
//        String dateString = null;
//        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
//   /*you can also use DateFormat reference instead of SimpleDateFormat
//    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
//    */
//        try{
//            dateString = sdfr.format(indate);
//        }catch (Exception ex ){
//            System.out.println(ex);
//        }
//        return dateString;
//    }
}
