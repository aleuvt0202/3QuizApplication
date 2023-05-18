package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";

    public Button button2;
    public Button button3;
    public Button button4;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GodButton();
        GTAButton();
        HGButton();

    }

    private void GodButton() {
        Button buton2 = findViewById(R.id.button2);
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GodOfWar.class);
                startActivity(intent);
            }
        });
    }

    private void GTAButton() {
        Button buton3 = findViewById(R.id.button3);
        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GTA.class);
                startActivity(intent);
            }
        });
    }

    private void HGButton() {
        Button buton4 = findViewById(R.id.button4);
        buton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Hogwards.class);
                startActivity(intent);
            }
        });
    }



}