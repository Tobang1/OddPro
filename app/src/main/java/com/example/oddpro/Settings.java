package com.example.oddpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.Settings);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
// if button is selected for animation
                switch (item.getItemId())
                {
                    case R.id.Odd:
                        startActivity(new Intent(getApplicationContext(), Odd.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.LiveScore:
                        startActivity(new Intent(getApplicationContext(), LiveScore.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Settings:

                        return true;
                }
                //anything else is selected it should return false
                return false;
            }
        });
    }
}