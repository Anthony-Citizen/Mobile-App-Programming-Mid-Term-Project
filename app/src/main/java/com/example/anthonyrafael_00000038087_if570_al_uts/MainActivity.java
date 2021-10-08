package com.example.anthonyrafael_00000038087_if570_al_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnProfile,btnLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesProfile();
            }
        });

        btnLibrary = findViewById(R.id.btnLibrary);
        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesLibrary();
            }
        });
    }

    private void switchActivitiesProfile() {
        Intent switchActivityProfileIntent = new Intent(this, Profile.class);
        startActivity(switchActivityProfileIntent);
    }

    private void switchActivitiesLibrary() {
        Intent switchActivityProfileIntent = new Intent(this, Login.class);
        startActivity(switchActivityProfileIntent);
    }
}