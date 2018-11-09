package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;

public class TrueFalse_Activity extends AppCompatActivity
{

    public Button nxtButton;
    public Button saveButton;
    public TextInputLayout qstTxt;
    public CheckBox trueCheck;
    public CheckBox falseCheck;


    private void init()
    {
        Intent i = getIntent();
        final Quiz newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        qstTxt = findViewById(R.id.qstTxt);
        trueCheck = findViewById(R.id.trueCheck);
        falseCheck = findViewById(R.id.falseCheck);

        nxtButton = (Button)findViewById(R.id.nxtButton2);
        nxtButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(qstTxt != null)
                    newQuiz.current.quizQuestion = qstTxt.getEditText();
                if(trueCheck.hasSelection())
                    newQuiz.current.truFal = true;
                else
                    newQuiz.current.truFal = false;
                //newQuiz.addQuest(1);
                finish();
                //Intent nextQuestion;
                //nextQuestion = new Intent(TrueFalse_Activity.this, TrueFalse_Activity.class);
                //nextQuestion.putExtra("Quiz", newQuiz);
                //startActivity(nextQuestion);
            }
        });

        /*saveButton = (Button)findViewById(R.id.saveButton2);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(qstTxt != null)
                    newQuiz.current.quizQuestion = qstTxt.getEditText();
                if(trueCheck.hasSelection())
                    newQuiz.current.truFal = true;
                else
                    newQuiz.current.truFal = false;
                Intent saveQuiz;
                saveQuiz = new Intent(TrueFalse_Activity.this, MainMenuActivity.class);
                saveQuiz.putExtra("Quiz", newQuiz);
                startActivity(saveQuiz);
            }
        });*/


    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);
        init();
    }

}


