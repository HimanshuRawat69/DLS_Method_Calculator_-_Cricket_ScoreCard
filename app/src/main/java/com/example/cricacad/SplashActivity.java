package com.example.cricacad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
getSupportActionBar().hide();
        Thread thread=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(700);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(SplashActivity.this, LogoActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();
    }
}