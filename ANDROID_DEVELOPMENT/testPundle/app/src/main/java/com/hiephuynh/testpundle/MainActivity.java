package com.hiephuynh.testpundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edtrange, edtguess, edtresult;
    Button btnstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtguess = findViewById(R.id.edtguess);
        edtrange = findViewById(R.id.edtrange);
        edtresult = findViewById(R.id.edtresult);
        btnstart = findViewById(R.id.btnstart);


            int range = Integer.parseInt(edtrange.getText().toString());
           

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b = Integer.parseInt(edtguess.getText().toString());
                if (b == a) {
                    edtresult.setText("Congratulation!");
                }
                else if (b < a) {
                    edtresult.setText("input a greater number");
                }

                else {
                    edtresult.setText("input a smaller number");
                }
            }

        });


    }


    }

