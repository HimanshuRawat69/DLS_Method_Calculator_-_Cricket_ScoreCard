package com.example.cricacad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BowlerSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowler_select);
        getSupportActionBar().hide();

        EditText BowlerName=findViewById(R.id.editTextText5);
        Button StartMatch=findViewById(R.id.button4);

        StartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( BowlerName.length()>0) {
                    String bowlername = BowlerName.getText().toString().trim();
                    Intent intent1=getIntent();
                    Intent intent = new Intent(BowlerSelect.this, ScoreCard.class);
                    intent.putExtra("Striker",intent1.getStringExtra("Striker"));
                    intent.putExtra("NonStriker",intent1.getStringExtra("NonStriker"));
                    intent.putExtra("teamAname",intent1.getStringExtra("teamAname"));
                    intent.putExtra("teamBname",intent1.getStringExtra("teamBname"));
                    intent.putExtra("overs",intent1.getStringExtra("overs"));
                    intent.putExtra("Bowler", bowlername);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(BowlerSelect.this,"Fill All Details!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}