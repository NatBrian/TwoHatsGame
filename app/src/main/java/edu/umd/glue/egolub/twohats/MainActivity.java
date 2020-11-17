package edu.umd.glue.egolub.twohats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView guessPlayer01;
    TextView guessPlayer02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessPlayer01 = ((TextView)findViewById(R.id.labelComputerGuess01));
        guessPlayer02 = ((TextView)findViewById(R.id.labelComputerGuess02));

        /*
        Button setPlayer0101 = findViewById(R.id.buttonPlayer01Color01);
        setPlayer0101.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {clearComputerGuesses();}});
        Button setPlayer0102 = findViewById(R.id.buttonPlayer01Color02);
        setPlayer0102.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {clearComputerGuesses();}});
        */
        RadioGroup setPlayer01 = findViewById(R.id.buttonsPlayer01);
        setPlayer01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (RadioGroup group,int checkedId){
                clearComputerGuesses();
            }
        });


        Spinner setPlayer02 = findViewById(R.id.spinnerPlayer02);
        setPlayer02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                clearComputerGuesses();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                clearComputerGuesses();
            }
        });
    }


    public void clearComputerGuesses() {
        guessPlayer01.setText("");
        guessPlayer02.setText("");
    }

    public void setComputerGuesses(View view) {
        String guess01, guess02;

        //Player One will guess they are wearing the same hat color as Player Two
        Spinner setPlayer02 = (Spinner)findViewById(R.id.spinnerPlayer02);
        guess01 = getResources().getStringArray(R.array.colors_array)[setPlayer02.getSelectedItemPosition()];

        //Player Two will guess they are wearing the other hat color than Player One
        RadioGroup setPlayer01 = (RadioGroup)findViewById(R.id.buttonsPlayer01);
        if (setPlayer01.getCheckedRadioButtonId() == R.id.buttonPlayer01Color01) {
            guess02 = getString(R.string.color02);
        }
        else {

            guess02 = getString(R.string.color01);
        }


        guessPlayer01.setText("My hat color is " + guess01 + ".");
        guessPlayer02.setText("My hat color is " + guess02 + ".");
    }
}
