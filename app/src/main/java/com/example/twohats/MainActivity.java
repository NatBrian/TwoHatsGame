package com.example.twohats;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Spinner person1 = (Spinner) findViewById(R.id.person1);
        Spinner person2 = (Spinner) findViewById(R.id.person2);

        // Create an ArrayAdapter using the string array and a default spinner layout
        // hat_colors is in values->strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hat_colors, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        person1.setAdapter(adapter);
        person2.setAdapter(adapter);

        // on button click
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView guess1 = (TextView) findViewById(R.id.guess1);
                final Spinner person2 = (Spinner) findViewById(R.id.person2);
                String selItem2 = person2.getSelectedItem().toString();
                if (selItem2.equals("Red")) {
                    guess1.setText("My Hat Color is Red");
                    guess1.setTextColor(Color.parseColor("#ff0000"));
                } else {
                    guess1.setText("My Hat Color is Blue");
                    guess1.setTextColor(Color.parseColor("#000dff"));
                }


                final TextView guess2 = (TextView) findViewById(R.id.guess2);
                final Spinner person1 = (Spinner) findViewById(R.id.person1);
                String selItem1 = person1.getSelectedItem().toString();
                if(selItem1.equals("Red")) {
                    guess2.setText("My Hat Color is Blue");
                    guess2.setTextColor(Color.parseColor("#000dff"));
                } else {
                    guess2.setText("My Hat Color is Red");
                    guess2.setTextColor(Color.parseColor("#ff0000"));
                }

                final TextView result = (TextView) findViewById(R.id.result);
                result.setText("YOU LOSE! Try again");
            }
        });

        person1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                final Spinner person1 = (Spinner) findViewById(R.id.person1);

                String selItem = person1.getItemAtPosition(arg2).toString();

                if(selItem.equals("Blue"))
                {
                    ImageView hat1= (ImageView) findViewById(R.id.hat1);
                    hat1.setImageResource(R.drawable.blue1);
                } else {
                    ImageView hat1= (ImageView) findViewById(R.id.hat1);
                    hat1.setImageResource(R.drawable.red0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        person2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                final Spinner person2 = (Spinner) findViewById(R.id.person2);

                String selItem = person2.getItemAtPosition(arg2).toString();

                if(selItem.equals("Blue"))
                {
                    ImageView hat1= (ImageView) findViewById(R.id.hat2);
                    hat1.setImageResource(R.drawable.blue1);
                } else {
                    ImageView hat1= (ImageView) findViewById(R.id.hat2);
                    hat1.setImageResource(R.drawable.red0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

