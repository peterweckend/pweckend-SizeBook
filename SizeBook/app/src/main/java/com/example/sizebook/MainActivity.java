package com.example.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addnew_main = (Button) findViewById(R.id.addnew_button_main);

        addnew_main.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "add new", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddNew.class);
                startActivity(intent);
            }

        });
    }




}
