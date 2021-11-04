package com.example.oddpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    Handler handler;
// Helps to navigate to next activity after launch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this,Register.class);
            startActivity(intent);
            finish();
        },2000);
    }
}