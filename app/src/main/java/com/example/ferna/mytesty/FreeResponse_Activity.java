package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class FreeResponse_Activity extends AppCompatActivity
{

    public Button nxtButton;
    public Button saveButton;
    public TextInputLayout qstTxt;
    public TextInputLayout corAns;

    private void init()
    {
        Intent i = getIntent();
        final Quiz newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        qstTxt = findViewById(R.id.qstTxt);
        corAns = findViewById(R.id.corAns);

        nxtButton = (Button)findViewById(R.id.nxtButton3);
        nxtButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(qstTxt != null)
                    newQuiz.current.quizQuestion = qstTxt.getEditText();
                if(corAns != null)
                    newQuiz.current.corrAns = corAns.getEditText();
                //newQuiz.addQuest(3);
                finish();
                //Intent nextQuestion;
                //nextQuestion = new Intent(FreeResponse_Activity.this, FreeResponse_Activity.class);
                //nextQuestion.putExtra("Quiz", newQuiz);
                //startActivity(nextQuestion);
            }
        });

        /*saveButton = (Button)findViewById(R.id.saveButton3);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(qstTxt != null)
                    newQuiz.current.quizQuestion = qstTxt.getEditText();
                if(corAns != null)
                    newQuiz.current.corrAns = corAns.getEditText();
                Intent saveQuiz;
                saveQuiz = new Intent(FreeResponse_Activity.this, MainMenuActivity.class);
                saveQuiz.putExtra("Quiz", newQuiz);
                startActivity(saveQuiz);
            }
        });*/


    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_response);
        init();
    }

}
