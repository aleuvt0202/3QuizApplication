package com.example.proiect;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.proiect.QuizContract.*;


import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class DbHelper2 extends SQLiteOpenHelper{
    private static final String DATABASE="SecondQuiz";
    private static final int DATABASE_VERSION=1;
    private SQLiteDatabase db;
    public DbHelper2(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQl_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " TEXT" +
                ")";

        db.execSQL(SQl_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    public void fillQuestionsTable(){
        Quiz q1 = new Quiz("Which 2000 Film Is GTA V Heavily Influenced By?", "Snatch", "Sexy Beast", "Memento", 2);
        addQ(q1);
        Quiz q2 = new Quiz("Who Voiced Trevor In GTA V?", "Steven Ogg", "Jay Klaitz", "Shawn Fonteno", 1);
        addQ(q2);
        Quiz q3 = new Quiz("What Is The Name Of Franklin's Dog?", "Spot", "Rover", "Chop", 3);
        addQ(q3);
        Quiz q4 = new Quiz("Who Voiced Michael In GTA V?", "Ned Luke", "Jay Klaitz", "Steven Ogg", 1);
        addQ(q4);
        Quiz q5 = new Quiz("Which Small Faces Song Is Featured In The Trailer For GTA V?", "Rene", "Ogden's Nut Gone Flake", "Lazy Sunday", 2);
        addQ(q5);
    }
    private void addQ(Quiz quiz){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, quiz.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, quiz.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, quiz.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, quiz.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, quiz.getAnswearNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
    public List<Quiz> getAllQuestions() {
        List<Quiz> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Quiz question = new Quiz();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswearNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
