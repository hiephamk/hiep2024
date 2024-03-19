package com.hiephuynh.my_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class multipleplayer extends AppCompatActivity {
    EditText edt_report, edt_guess1, edt_player1, edt_guess2,edt_player2, edt_rannum;
    Button btn_check2, btn_again2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipleplayer);
        edt_report = findViewById(R.id.edt_report);
        edt_guess1 = findViewById(R.id.edt_guess1);
        edt_guess2 = findViewById(R.id.edt_guess2);
        edt_player1 = findViewById(R.id.edt_player1);
        edt_player2 = findViewById(R.id.edt_player2);
        btn_check2 = findViewById(R.id.btn_check2);
        btn_again2 = findViewById(R.id.btn_again2);
        edt_rannum = findViewById(R.id.edt_rannum);

        Intent multiple_intent = getIntent();
        Bundle multiple_bundle = multiple_intent.getBundleExtra("main_package");
        int c = multiple_bundle.getInt("random_number");


        btn_check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edt_rannum.setText(c+"");
                int guessNum = Integer.parseInt(edt_guess1.getText().toString());

                if (guessNum == c) {
                    edt_guess1.setText("");
                    edt_player1.setText("");
                    edt_player2.setText("");
                    edt_report.setText("Congratulation!!! Player 1 is winner");

                }
                else if (guessNum > c) {
                    edt_guess1.setText("");
                    edt_player1.setText("Choose a smaller number");

                }
                else {
                    edt_guess1.setText("");
                    edt_player1.setText("Choose a greater number");

                }
                int guessNum2 = Integer.parseInt(edt_guess2.getText().toString());
                if (guessNum2 == c) {
                    edt_guess2.setText("");
                    edt_player2.setText("");
                    edt_player1.setText("");
                    edt_report.setText("Congratulation!!! Player 2 is winner");
                }
                else if (guessNum2 > c) {
                    edt_guess2.setText("");
                    edt_player2.setText("Choose a smaller number");
                }
                else {
                    edt_guess2.setText("");
                    edt_player2.setText("Choose a greater number");
                }

            }
        });
        btn_again2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}