package com.example.ferna.mytesty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetScore extends AppCompatActivity
{
    public Button doneButton;
    public TextView score;
    public Quiz newQuiz;
    public int numCorrect = 0;
    public int totalQuests = 0;


    private void init()
    {
        doneButton = findViewById(R.id.doneButt);
        score = findViewById(R.id.resultText);

        Intent i = getIntent();
        newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        getScore();

        score.setText(String.valueOf(numCorrect) + "/" + String.valueOf(totalQuests));


        doneButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

    }

    private void getScore()
    {
        newQuiz.reset();
        newQuiz.nextQuestion();
        while(newQuiz.current.next != null)
        {
            if(newQuiz.current.getAnsweredCorrect())
                numCorrect++;
            totalQuests++;
            newQuiz.nextQuestion();
        }
        if(newQuiz.current.getAnsweredCorrect())
            numCorrect++;
        totalQuests++;
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        init();
    }
}
