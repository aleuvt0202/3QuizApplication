package com.example.proiect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Finish extends AppCompatActivity {
    private TextView Quiz, good, link1, link2;
    private TextView Scor;
    private Button inapoi;

//    int finalScore = getIntent().getIntExtra("score", 0);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        String quizName = getIntent().getStringExtra("quizName");
        String linkDoc1 = getIntent().getStringExtra("link1");
        String linkDoc2 = getIntent().getStringExtra("link2");
        int finalScore = getIntent().getIntExtra("score", 0);


        TextView quizNameTextView = findViewById(R.id.Quiz);
        quizNameTextView.setText("Quiz: " + quizName);

        TextView scoreTextView = findViewById(R.id.Scor);
        scoreTextView.setText("Your score: " + finalScore);

        TextView goodTextView = findViewById(R.id.good);
        if(finalScore==5){
            goodTextView.setText("Your a master in this game!");
        }else if(finalScore==4){
            goodTextView.setText("Very good!");
        } else if(finalScore==3){
            goodTextView.setText("Good but not good!");
        } else if(finalScore==2){
            goodTextView.setText("You can check the links below for more documentation!");
        } else{
            goodTextView.setText("You can check the links below for more documentation!");
        }

        TextView link1TextView = findViewById(R.id.link1);
        link1TextView.setText("1:  " + linkDoc1);

        TextView link2TextView = findViewById(R.id.link2);
        link2TextView.setText("2:  " + linkDoc2);
        inapoi();
    }

    private void inapoi() {
        Button inapoi = findViewById(R.id.inapoi);
        inapoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Finish.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
