package com.example.naturals.Activity.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.naturals.R;
import com.example.naturals.formLogin.TeladeLogin;

import android.os.Handler;
import android.app.Activity;


public class ActivityDelay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main1);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(ActivityDelay.this, TeladeLogin.class);
                startActivity(intent);
                finish();

            }
        }, 5000); // Atraso de 5 segundos
    }
}
