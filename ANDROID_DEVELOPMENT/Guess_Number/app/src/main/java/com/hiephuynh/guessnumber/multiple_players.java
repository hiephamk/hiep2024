package com.hiephuynh.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class multiple_players extends AppCompatActivity {
    EditText edtwelcome,edtplayer1,edtplayer2;
    EditText edt_hint1 = findViewById(R.id.edt_hint1), edt_hint2 = findViewById(R.id.edt_hint2);
    Button btncheck,btnagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_players);

        edtwelcome = findViewById(R.id.edtwelcome);
        edtplayer1 = findViewById(R.id.edtplayer1);
        edtplayer2 = findViewById(R.id.edtplayer2);
        btncheck = findViewById(R.id.btncheck);
        btnagain = findViewById(R.id.btnagain);

        Intent myintent = getIntent();
        Bundle mybundle = myintent.getBundleExtra("mybundle");

        int a = mybundle.getInt("ranNum");

        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                int player1 = Integer.parseInt(edtplayer1.getText().toString());
                int player2 = Integer.parseInt(edtplayer2.getText().toString());
                if(player1 == a){
                    edtplayer1.setText("");
                    edtwelcome.setText("Congratulation, Player 1!! \n You have done in " + (i+1) + " times!"  );
                    //finish();
                }
                else if(player2 == a){
                    edtplayer1.setText("");
                    edtwelcome.setText("Congratulation, Player 2!! \n You have done in " + (i+1) + " times!"  );
                    //finish();
                }
                else if(player1 > a ){
                    edtplayer1.setText("");
                    edt_hint1.setText("Choose a smaller number" );
                    //finish();
                }
                else if(player2 > a ){
                    edtplayer1.setText("");
                    edt_hint2.setText("Choose a smaller number" );
                    //finish();
                }
                else if(player1 < a ){
                    edtplayer1.setText("");
                    edt_hint1.setText("Choose a greater number" );
                    //finish();
                }
                else if(player2 < a ){
                    edtplayer1.setText("");
                    edt_hint2.setText("Choose a greater number" );
                    //finish();
                }
            }
        });
        btnagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}