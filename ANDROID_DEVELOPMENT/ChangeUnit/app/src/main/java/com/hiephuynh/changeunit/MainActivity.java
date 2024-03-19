package com.hiephuynh.changeunit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Declare vars
    EditText edtF,edtC;
    Button bntCF,bntFC,bntClr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mapping id
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        bntCF = findViewById(R.id.bntCF);
        bntFC = findViewById(R.id.bntFC);
        bntClr = findViewById(R.id.bntClr);
        //processing click actions

        //button convert F to C
        bntFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f = Integer.parseInt(edtF.getText().toString());
                double c = (f-32)/1.8;
                edtC.setText(c+"");

            }
        });
        //button convert C to F
        bntCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = Integer.parseInt(edtC.getText().toString());
                double f = (c * 1.8) + 32;
                edtF.setText(f+"");
            }
        });
        //button clear
        bntClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}