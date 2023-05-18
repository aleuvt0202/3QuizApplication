package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.crypto.Cipher;

public class Quiz{
    private String Question;
    private String option1;
    private String option2;
    private String option3;
    private int answearNr;

    public Quiz(){}
    public Quiz(String question, String option1, String option2, String option3, int answearNr) {
        this.Question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answearNr = answearNr;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswearNr() {
        return answearNr;
    }

    public void setAnswearNr(int answearNr) {
        this.answearNr = answearNr;
    }
}
