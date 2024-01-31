package com.example.cricacad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BatsmanNameActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batsman_name_activty);
        getSupportActionBar().hide();

        EditText StrikerName=findViewById(R.id.editTextText3);
        EditText NonStrikerName=findViewById(R.id.editTextText4);
        Button StartMatch=findViewById(R.id.button3);

        StartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( StrikerName.length()>0 && NonStrikerName.length()>0) {
                    String striker = StrikerName.getText().toString().trim();
                    String nonstriker = NonStrikerName.getText().toString().trim();

                    Intent intent = new Intent(BatsmanNameActivty.this, BowlerSelect.class);
                    Intent intent1=getIntent();
                    intent.putExtra("teamAname",intent1.getStringExtra("teamAname"));
                    intent.putExtra("teamBname",intent1.getStringExtra("teamBname"));
                    intent.putExtra("overs",intent1.getStringExtra("overs"));
                    intent.putExtra("Striker", striker);
                    intent.putExtra("NonStriker", nonstriker);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(BatsmanNameActivty.this,"Fill All Details!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}