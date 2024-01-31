package com.example.cricacad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScorecardTossScreenDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard_toss_screen_details);
        getSupportActionBar().hide();

        EditText TeamAName=findViewById(R.id.editTextText);
        EditText TeamBName=findViewById(R.id.editTextText2);
        EditText TotalOvers=findViewById(R.id.editTextNumber9);
        Button StartMatch=findViewById(R.id.button2);

        StartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TeamAName.length()>0  && TeamBName.length()>0 && TotalOvers.length()>0) {
                    String teamAname = TeamAName.getText().toString().trim();
                    String teamBname = TeamBName.getText().toString().trim();
                    String overs = TotalOvers.getText().toString().trim();
                    Intent intent = new Intent(ScorecardTossScreenDetails.this, BatsmanNameActivty.class);
                    intent.putExtra("teamAname", teamAname);
                    intent.putExtra("teamBname", teamBname);
                    intent.putExtra("overs", overs);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(ScorecardTossScreenDetails.this,"Fill All Details!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}