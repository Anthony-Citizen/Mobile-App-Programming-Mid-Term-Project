package com.example.anthonyrafael_00000038087_if570_al_uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class Library extends AppCompatActivity {

    private ArrayList<Integer> mSoundImage = new ArrayList<>();
    private ArrayList<Integer> mSound = new ArrayList<>();
    private ArrayList<String> mJudul = new ArrayList<>();
    private ArrayList<String> mKategori = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");

        this.setTitle(str);

        initSound();
    }

    private void initSound(){
        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound1);
        mJudul.add("Opening");
        mKategori.add("Intro");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound2);
        mJudul.add("Dream Sound");
        mKategori.add("Synth");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound3);
        mJudul.add("Sunset Horizon");
        mKategori.add("Instrument");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound4);
        mJudul.add("Heavy Rain");
        mKategori.add("Nature");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound5);
        mJudul.add("Gates of Heaven");
        mKategori.add("Orchestra");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound6);
        mJudul.add("Braam");
        mKategori.add("Hit");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound7);
        mJudul.add("Car");
        mKategori.add("Fast");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound8);
        mJudul.add("Alarm");
        mKategori.add("Wake Up");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound9);
        mJudul.add("Hmmm");
        mKategori.add("Man");

        mSoundImage.add(R.drawable.sound_image);
        mSound.add(R.raw.sound10);
        mJudul.add("Happy Outro");
        mKategori.add("End");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        DaftarSoundAdapter adapter = new DaftarSoundAdapter(mSoundImage,mSound, mJudul, mKategori, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent profileIntent = new Intent(Library.this, Profile.class);
                startActivity(profileIntent);
                break;
            case R.id.logout:
                Intent logoutIntent = new Intent(Library.this, MainActivity.class);
                startActivity(logoutIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    }*/
}