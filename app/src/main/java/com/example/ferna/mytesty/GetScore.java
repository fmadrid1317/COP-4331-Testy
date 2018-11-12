package com.example.ferna.mytesty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetScore extends AppCompatActivity
{
    public Button doneButton;
    public TextView score;
    public Quiz newQuiz;


    private void init()
    {
        doneButton = findViewById(R.id.doneButt);
        score = findViewById(R.id.resultText);

        Intent i = getIntent();
        newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        score.setText(null); //need to find the score somehow


        doneButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        init();
    }
}
