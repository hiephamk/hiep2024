package com.hiephuynh.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnstart;
    EditText edtrange;
    RadioGroup radgroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart = findViewById(R.id.btnstart);
        radgroup = findViewById(R.id.radgroup);
        edtrange = findViewById(R.id.edtrange);



        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int range = Integer.parseInt(edtrange.getText().toString());
                int idselect = radgroup.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(idselect);
                String choose = radselect.getText().toString();

                //declare intent method for mainActivity
                if (choose.equals("Single Player")) {
                    Intent myintent = new Intent(MainActivity.this, single_player.class);
                    //int range = Integer.parseInt(edtRange.getText().toString());
                    Random rd = new Random();
                    int ranNum = rd.nextInt(range);
                    //edtRannum.setText(ranNum +"");
                    //storage data into bundle
                    Bundle mybundle = new Bundle();
                    //Put data into bundle
                    mybundle.putInt("ranNum", ranNum);
                    //put bundle into intent
                    myintent.putExtra("mybundle", mybundle);
                    //start intent
                    startActivity(myintent);
                } else if (choose.equals("Multiple Player")) {
                    Intent myintent = new Intent(MainActivity.this, multiple_players.class);
                    //int range = Integer.parseInt(edtRange.getText().toString());
                    Random rd = new Random();
                    int ranNum = rd.nextInt(range);
                    //edtRannum.setText(ranNum +"");
                    //storage data into bundle
                    Bundle mybundle = new Bundle();
                    //Put data into bundle
                    mybundle.putInt("ranNum", ranNum);
                    //put bundle into intent
                    myintent.putExtra("mybundle", mybundle);
                    //start intent
                    startActivity(myintent);

                }
            }
        });
    }

    }
