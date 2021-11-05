package com.example.oddpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Settings extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    //for the login button
    private FirebaseAuth FirebaseAuth;

    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //check condition
        if (AppCompatDelegate.getDefaultNightMode()== AppCompatDelegate.MODE_NIGHT_YES){
            //when night mode is equal to yes
            //set dark mode

            setTheme(R.style.Theme_Dark);
        }else{
            //when night mode is equal to No
            //set light theme
            setTheme(R.style.Theme_Light);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //button logout
        FirebaseAuth = FirebaseAuth.getInstance();


        switchCompat = findViewById(R.id.switch1);
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.Settings);


        //switch for dark mode

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //check condition
                if (isChecked){
                    //when switch button is checked
                    //set night mode

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    //when switch button is unchecked
                    //set light to day mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }


            }
        });





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

