package com.example.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class AddNew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);



        //Button submit_addnew = (Button) findViewById(R.id.submit_button_addnew);

//        submit_addnew.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "submit", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(AddNew.this, MainActivity.class);
//                startActivity(intent);
//            }
//
//        });




    }

    public void addPersonAction(View v){

//        int dateval;
//        EditText values = (EditText) findViewById(R.id.date_field_addnew);
//        if (values.getText().toString().trim().length() == 0){
//            dateval = 10;
//        }
//        else{
//            dateval = Integer.parseInt(values.getText().toString());
//        }


        float neck;
        EditText values = (EditText) findViewById(R.id.neck_field_addnew);
        if (values.getText().toString().trim().length() == 0){
            neck = 0;
        }
        else{
            neck = Float.valueOf(values.getText().toString());
        }


        float bust;
        EditText values2 = (EditText) findViewById(R.id.bust_field_addnew);
        if (values2.getText().toString().trim().length() == 0){
            bust = 0;
        }
        else{
            bust = Float.valueOf(values2.getText().toString());
        }


        float chest;
        EditText values3 = (EditText) findViewById(R.id.chest_field_addnew);
        if (values3.getText().toString().trim().length() == 0){
            chest = 0;
        }
        else{
            chest = Float.valueOf(values3.getText().toString());
        }


        float waist;
        EditText values4 = (EditText) findViewById(R.id.waist_field_addnew);
        if (values4.getText().toString().trim().length() == 0){
            waist = 0;
        }
        else{
            waist = Float.valueOf(values4.getText().toString());
        }


        float hip;
        EditText values5 = (EditText) findViewById(R.id.hip_field_addnew);
        if (values5.getText().toString().trim().length() == 0){
            hip = 0;
        }
        else{
            hip = Float.valueOf(values5.getText().toString());
        }


        float inseam;
        EditText values6 = (EditText) findViewById(R.id.inseam_field_addnew);
        if (values6.getText().toString().trim().length() == 0){
            inseam = 0;
        }
        else{
            inseam = Float.valueOf(values6.getText().toString());
        }


        String comments;
        EditText values7 = (EditText) findViewById(R.id.comment_field_addnew);
        if (values7.getText().toString().trim().length() == 0){
            comments = "defaultcomment";
        }
        else{
            comments = values7.getText().toString();
        }






        EditText textView = (EditText) findViewById(R.id.name_field_addnew);

        if (textView.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Name required.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            PersonListController pt = new PersonListController();

            pt.addPerson(new Person(textView.getText().toString(), neck, bust, chest, waist, hip, inseam, comments));
            Toast.makeText(this, "adding a student", Toast.LENGTH_SHORT).show();

            //        Intent intent = new Intent(AddNew.this, MainActivity.class);
            //        startActivity(intent);
            finish();
        }
    }

}
