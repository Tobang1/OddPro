package com.example.oddpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Settings extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    //for the login button
    private FirebaseAuth FirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //button logout
        FirebaseAuth = FirebaseAuth.getInstance();


        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.Settings);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
// if button is selected for animation
                switch (item.getItemId()) {
                    case R.id.Odd:
                        startActivity(new Intent(getApplicationContext(), Odd.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.LiveScore:
                        startActivity(new Intent(getApplicationContext(), LiveScore.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.Settings:

                        return true;
                }
                //anything else is selected it should return false
                return false;
            }
        });

    }
// logout button onclick
    public void logout(View view) {
        FirebaseAuth.signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}

