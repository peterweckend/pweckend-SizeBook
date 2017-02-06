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

public class UpdateRecord extends AppCompatActivity {
    private Person personu;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        PersonListManager.initManager(this.getApplicationContext());
        personu = (Person) getIntent().getSerializableExtra("person");
        index = getIntent().getIntExtra("index", 0);

        TextView nametext = (TextView) findViewById(R.id.name_field_updaterecord);
        nametext.setText(personu.getName());

        Date date = personu.getDate();
        TextView datetext = (TextView) findViewById(R.id.date_field_updaterecord);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(datetext.getText().toString());
        } catch(ParseException e) {
            e.printStackTrace();
        }
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


        Button edit_viewdetail = (Button) findViewById(R.id.update_button_updaterecord);
        edit_viewdetail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "record updated", Toast.LENGTH_SHORT).show();

                EditText values = (EditText) findViewById(R.id.name_field_updaterecord);
                String name = values.getText().toString();


                EditText values2 = (EditText) findViewById(R.id.date_field_updaterecord);
                //personu.setDate(values2.getText().toString());


                Date date = new Date();
                //EditText enterdate = (EditText) findViewById(R.id.date_field_addnew);

                String enterdate_string = values2.getText().toString();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = format.parse(enterdate_string);
                } catch(ParseException e) {
                    e.printStackTrace();
                }


                EditText values3 = (EditText) findViewById(R.id.neck_field_updaterecord);
                float neck = Float.valueOf(values3.getText().toString());
                neck = (float) (Math.round(neck * 2) / 2.0);

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

                PersonListController updatept = new PersonListController();
                updatept.updatePerson(index, name, date, neck, bust, chest, waist,hip,inseam, comment);

                Intent intent = new Intent(UpdateRecord.this, MainActivity.class);
                startActivity(intent);
            }


        });



    }
}
