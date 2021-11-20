package com.example.oddpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewPremium = findViewById(R.id.imagepremium);

        ImageView imageView = findViewById(R.id.imagefree);
// set button selector
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);
//free odd image onclick
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Odd.class);
            startActivity(intent);
            finish();

        });

//premium odd image onclick

        imageViewPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Premium.class);
                startActivity(intent);
                finish();
            }
        });



        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
// if button is selected for animation
            switch (item.getItemId())
            {
                case R.id.Odd:
                    startActivity(new Intent(getApplicationContext(),Odd.class ));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.home:
                    return true;

                case R.id.LiveScore:
                    startActivity(new Intent(getApplicationContext(), LiveScore.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.Settings:
                    startActivity(new Intent(getApplicationContext(), Settings.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            //anything else is selected it should return false
            return false;
        });
    }

}