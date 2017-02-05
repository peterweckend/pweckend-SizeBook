package com.example.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateRecord extends AppCompatActivity {
    private Person personu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        PersonListManager.initManager(this.getApplicationContext());
        personu = (Person) getIntent().getSerializableExtra("person");

        TextView nametext = (TextView) findViewById(R.id.name_field_updaterecord);
        nametext.setText(personu.getName());

        TextView datetext = (TextView) findViewById(R.id.date_field_updaterecord);
        //datetext.setText(convertStringToDate(person.getDate()));

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
                personu.setName(values.toString());

//                EditText values2 = (EditText) findViewById(R.id.date_field_updaterecord);
//                personu.setDate(values.toString());

                EditText values3 = (EditText) findViewById(R.id.neck_field_updaterecord);
                personu.setNeck(Float.valueOf(values.toString()));

                EditText values4 = (EditText) findViewById(R.id.bust_field_updaterecord);
                personu.setBust(Float.valueOf(values.toString()));

                EditText values5 = (EditText) findViewById(R.id.chest_field_updaterecord);
                personu.setChest(Float.valueOf(values.toString()));

                EditText values6 = (EditText) findViewById(R.id.waist_field_updaterecord);
                personu.setWaist(Float.valueOf(values.toString()));

                EditText values7 = (EditText) findViewById(R.id.hip_field_updaterecord);
                personu.setHip(Float.valueOf(values.toString()));

                EditText values8 = (EditText) findViewById(R.id.inseam_field_updaterecord);
                personu.setInseam(Float.valueOf(values.toString()));

                EditText values9 = (EditText) findViewById(R.id.comment_field_updaterecord);
                personu.setComment(values.toString());





                finish();
            }


        });



    }
}
