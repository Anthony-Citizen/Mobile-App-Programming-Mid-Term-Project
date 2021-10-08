package com.example.anthonyrafael_00000038087_if570_al_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class DetailSoundActivity extends AppCompatActivity {
    private static final String TAG = "DetailSoundActivity";

    private EditText etJudul;
    private EditText etKategori;
    private Button btnPlay;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sound);

        etJudul = (EditText) findViewById(R.id.etJudul);
        etKategori = (EditText) findViewById(R.id.etKategori);

        getIncomingIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getIncomingIntent() {
        Log.d(TAG, "IncomingIntent: called.");
        if(getIntent().hasExtra("judul") && getIntent().hasExtra("kategori") && getIntent().hasExtra("sound")) {
            String judul = getIntent().getStringExtra("judul");
            String kategori = getIntent().getStringExtra("kategori");
            Integer sound = getIntent().getIntExtra("sound",0);

            this.setTitle(judul);
            setContent(judul, kategori, sound);
        }
    }

    private void setContent(String judul, String kategori, Integer sound) {
        Log.d(TAG, judul);

        etJudul.setText(judul);
        etKategori.setText(kategori);

        btnPlay = (Button) findViewById(R.id.btnPlay);

        mp = MediaPlayer.create(DetailSoundActivity.this, sound);

        btnPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mp.start();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mp.isPlaying()) {
            mp.stop(); // or mp.pause();
            mp.release();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (mp.isPlaying()) {
            mp.stop(); // or mp.pause();
            mp.release();
        }
        finish();
        return true;
    }

}