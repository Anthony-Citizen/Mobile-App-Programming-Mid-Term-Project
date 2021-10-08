package com.example.anthonyrafael_00000038087_if570_al_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button send_button;
    EditText send_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        send_button = findViewById(R.id.send_button_id);
        send_text = findViewById(R.id.send_text_id);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String str = send_text.getText().toString();

                if (TextUtils.isEmpty(str))
                {
                    Toast.makeText(Login.this,
                            "Empty field not allowed!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Login.this,
                            "Welcome "+str,
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Library.class);

                    intent.putExtra("name", str);

                    startActivity(intent);
                }
            }
        });
    }
}