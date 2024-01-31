package com.example.cricacad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DlsActivity extends AppCompatActivity {

    Spinner spinner;
    Team1CutShortFragment team1;
    Team2CutShortFragement team2;
    Team2ResultFragement teamResult;
    List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dls);
        getSupportActionBar().hide();
        spinner=findViewById(R.id.spinner);
        team1=new Team1CutShortFragment();
        team2=new Team2CutShortFragement();
        teamResult=new Team2ResultFragement();
        names=new ArrayList<>();
        names.add("Team 1 CutShort");
        names.add("Team 2 CutShort");
        names.add("Team 2 Final Result");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(DlsActivity.this,R.layout.list,names);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        selectFragement(team1);
                        break;
                    case 1:
                        selectFragement(team2);
                        break;
                    case 2:
                        selectFragement(teamResult);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });



    }
    private void selectFragement(Fragment fragement)
        {
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayout,fragement);
            fragmentTransaction.commit();
        }
}