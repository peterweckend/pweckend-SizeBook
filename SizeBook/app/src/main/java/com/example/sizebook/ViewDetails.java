package com.example.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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


        personList = (ArrayList<Person>) getIntent().getSerializableExtra("personList");
        index = getIntent().getIntExtra("index", 0);
        final Person person = personList.get(index);

        TextView nametext = (TextView) findViewById(R.id.name_field_viewdetail);
        nametext.setText(person.getName());

        TextView datetext = (TextView) findViewById(R.id.date_field_viewdetail);
        //datetext.setText(convertStringToDate(person.getDate()));

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
                Toast.makeText(getApplicationContext(), "edit record", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewDetails.this, UpdateRecord.class);
                intent.putExtra("person", person);
                startActivity(intent);

            }


        });

    }


    public String convertStringToDate(Date indate)
    {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
   /*you can also use DateFormat reference instead of SimpleDateFormat
    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
    */
        try{
            dateString = sdfr.format(indate);
        }catch (Exception ex ){
            System.out.println(ex);
        }
        return dateString;
    }
}
