package com.example.anthonyrafael_00000038087_if570_al_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView textView,tvRef1,tvRef2,tvRef3,tvRef4,tvRef5,tvRef6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = findViewById(R.id.tvName);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        tvRef1 = findViewById(R.id.tvRef1);
        tvRef1.setMovementMethod(LinkMovementMethod.getInstance());

        tvRef2 = findViewById(R.id.tvRef2);
        tvRef2.setMovementMethod(LinkMovementMethod.getInstance());

        tvRef3 = findViewById(R.id.tvRef3);
        tvRef3.setMovementMethod(LinkMovementMethod.getInstance());

        tvRef4 = findViewById(R.id.tvRef4);
        tvRef4.setMovementMethod(LinkMovementMethod.getInstance());

        tvRef5 = findViewById(R.id.tvRef5);
        tvRef5.setMovementMethod(LinkMovementMethod.getInstance());

        tvRef6 = findViewById(R.id.tvRef6);
        tvRef6.setMovementMethod(LinkMovementMethod.getInstance());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}