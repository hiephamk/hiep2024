package com.hiephuynh.my_game;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RadioGroup rad_group;
    RadioButton rad_single, rad_multiple;
    EditText edt_range;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rad_group = findViewById(R.id.rad_group);
        rad_single = findViewById(R.id.rad_single);
        rad_multiple = findViewById(R.id.rad_multiple);
        edt_range = findViewById(R.id.edt_range);
        //edt_select = findViewById(R.id.edt_select);
        btn_start = findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int select = rad_group.getCheckedRadioButtonId();
                RadioButton rad_select = findViewById(select);
                String select_player = rad_select.getText().toString();
                */
                //create a random number
                int range = Integer.parseInt(edt_range.getText().toString());
                Random rd = new Random();
                int a = rd.nextInt(range);

                Bundle main_bundle = new Bundle();
                main_bundle.putInt("random_number",a);

                //String select_player = edt_select.getText().toString();

                //create intent and bundle
                if(rad_single.isChecked()) {

                Intent main_intent = new Intent(MainActivity.this, singleplayer.class);

                main_intent.putExtra("main_package",main_bundle);

                startActivity(main_intent);
                }
                else if(rad_multiple.isChecked()) {
                    Intent main_intent = new Intent(MainActivity.this,multipleplayer.class);
                    main_intent.putExtra("main_package",main_bundle);
                    startActivity(main_intent);

                }
            }
        });

    }
}