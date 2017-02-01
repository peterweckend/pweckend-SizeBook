package com.example.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddNew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);



        Button submit_addnew = (Button) findViewById(R.id.submit_button_addnew);

        submit_addnew.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "submit", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddNew.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }



}
