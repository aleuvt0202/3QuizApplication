package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GodOfWar extends AppCompatActivity {
    private TextView Question;
    private TextView scor;
    private TextView numQuestion;
    private RadioGroup rbGroup;
    private RadioButton button1;
    private RadioButton button2;
    private RadioButton button3;
    private Button submit;

    private ColorStateList textColorDefaultRb;
    private List<Quiz> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Quiz currentQuestion;
    private int score;
    private boolean answered;


    private String link1="https://godofwar.fandom.com/wiki/God_of_War_(2018)";
    private String link2="https://gamerant.com/god-of-war-100-questions-unlockable-costumes/";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_of_war);

        Question = findViewById(R.id.Question);
        scor = findViewById(R.id.scor);
        numQuestion = findViewById(R.id.numQuestion);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        submit = findViewById(R.id.submit);
        rbGroup = findViewById(R.id.rbGroup);

        textColorDefaultRb = button1.getTextColors();

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestions();

        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNestQuestion();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(button1.isChecked() || button2.isChecked() || button3.isChecked()){
                        checkAnswer();
                    } else {
                        Toast.makeText(GodOfWar.this, "Select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNestQuestion();;
                }

            }
        });
    }

    private void showNestQuestion(){
        button1.setTextColor(textColorDefaultRb);
        button2.setTextColor(textColorDefaultRb);
        button3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter<questionCountTotal){
            currentQuestion = questionList.get(questionCounter);

            Question.setText(currentQuestion.getQuestion());
            button1.setText(currentQuestion.getOption1());
            button2.setText(currentQuestion.getOption2());
            button3.setText(currentQuestion.getOption3());

            questionCounter++;
            numQuestion.setText("Question: "+ questionCounter+"/"+questionCountTotal);
            answered=false;
            submit.setText("Submit");
        } else {
            finishQuiz();
        }
    }

    private void checkAnswer(){
        answered= true;
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNum = rbGroup.indexOfChild(rbSelected)+1;
        if(answerNum == currentQuestion.getAnswearNr()){
            score++;
            scor.setText("Score: "+score);
        }
        showSolution();
    }

    private void showSolution(){
        button1.setTextColor(Color.RED);
        button2.setTextColor(Color.RED);
        button3.setTextColor(Color.RED);

        switch (currentQuestion.getAnswearNr()){
            case 1:
                button1.setTextColor(Color.GREEN);
                Question.setText("Answer 1 is correct!");
                break;
            case 2:
                button2.setTextColor(Color.GREEN);
                Question.setText("Answer 2 is correct!");
                break;
            case 3:
                button3.setTextColor(Color.GREEN);
                Question.setText("Answer 3 is correct!");
                break;
        }

        if(questionCounter<questionCountTotal){
            submit.setText("Next");
        } else {
            submit.setText("Finish");
        }
    }
    private void finishQuiz(){
        Intent intent = new Intent(GodOfWar.this, Finish.class);
        intent.putExtra("score", score);
        intent.putExtra("quizName", "God of War");
        intent.putExtra("link1", link1);
        intent.putExtra("link2", link2);
        startActivity(intent);
    }
}