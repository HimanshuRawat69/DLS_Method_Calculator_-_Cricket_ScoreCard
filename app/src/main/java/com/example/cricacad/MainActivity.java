package com.example.cricacad;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.example.cricacad.databinding.ActivityMainBinding;
import com.example.cricacad.ui.dashboard.DashboardFragment;
import com.example.cricacad.ui.home.HomeFragment;
import com.example.cricacad.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        com.example.cricacad.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

getSupportActionBar().hide();

        binding.navView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new HomeFragment())
                            .commit();
                }
                else if(id==R.id.navigation_notifications) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new NotificationsFragment())
                            .commit();
                }
                else if(id==R.id.navigation_dashboard) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new DashboardFragment())
                            .commit();
                }
                return true;
            }
        });

    }
}
