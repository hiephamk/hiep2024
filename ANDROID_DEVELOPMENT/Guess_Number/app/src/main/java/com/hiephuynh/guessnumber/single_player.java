package com.hiephuynh.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class single_player extends AppCompatActivity {
    EditText edtGuess,edtResult;
    Button btnCheck,btnAgain;
    //Intent intentPlayGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player);
        edtGuess = findViewById(R.id.edtGuess);
        edtResult = findViewById(R.id.edtResult);
        btnCheck = findViewById(R.id.btnCheck);
        btnAgain = findViewById(R.id.btnAgain);

        Intent myintent = getIntent();
        Bundle mybundle = myintent.getBundleExtra("mybundle");

        int a = mybundle.getInt("ranNum");



       btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
            int guess = Integer.parseInt(edtGuess.getText().toString());
                if(guess == a){
                    edtGuess.setText("");
                    edtResult.setText("Congratulation!\n You have done in " + (i+1) + " times!"  );
                    //finish();
                }
                else if(guess < a){
                    edtGuess.setText("");
                    i++;
                    edtResult.setText("Choose a greater number.");
                }
                if(guess > a){
                    edtGuess.setText("");
                    i++;
                    edtResult.setText("Choose a smaller number");
                }

            }
        });
       btnAgain.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });

    }
}