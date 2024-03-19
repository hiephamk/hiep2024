package com.hiephuynh.my_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class singleplayer extends AppCompatActivity {
    EditText edt_result, edt_guess;
    Button btn_check, btn_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        edt_result = findViewById(R.id.edt_result);
        edt_guess = findViewById(R.id.edt_guess);
        btn_check = findViewById(R.id.btn_check);
        btn_again = findViewById(R.id.btn_again);
        //take intent
        Intent single_intent = getIntent();
        //take bundle
        Bundle single_bundle = single_intent.getBundleExtra("main_package");
        //get data from bundle
        int b = single_bundle.getInt("random_number");

        //process of checking of right number

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int guessNum = Integer.parseInt(edt_guess.getText().toString());
                if (guessNum == b) {
                    edt_guess.setText("");
                    edt_result.setText("Congratulation!!! You are winner");
                } else if (guessNum > b) {
                    edt_guess.setText("");
                    edt_result.setText("Choose a smaller number");
                } else {
                    edt_guess.setText("");
                    edt_result.setText("Choose a greater number");
                }
            }
            });
        btn_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}