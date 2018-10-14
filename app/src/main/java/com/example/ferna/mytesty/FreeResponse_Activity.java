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

    Gson gS = new Gson();
    String target = getIntent().getStringExtra("QuizString");
    Quiz currentQuiz = gS.fromJson(target, Quiz.class);

    private void init()
    {

        qstTxt = findViewById(R.id.qstTxt);
        corAns = findViewById(R.id.corAns);

        nxtButton = (Button)findViewById(R.id.nxtButton3);
        nxtButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                qstTxt.getEditText().getText();
                corAns.getEditText().getText();
                target = gS.toJson(currentQuiz);
                Intent nextQuestion;
                nextQuestion = new Intent(FreeResponse_Activity.this, FreeResponse_Activity.class);
                nextQuestion.putExtra("QuizString", target);
                startActivity(nextQuestion);
            }
        });

        saveButton = (Button)findViewById(R.id.saveButton3);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                qstTxt.getEditText().getText();
                corAns.getEditText().getText();
                target = gS.toJson(currentQuiz);
                Intent saveQuiz;
                saveQuiz = new Intent(FreeResponse_Activity.this, MainMenuActivity.class);
                saveQuiz.putExtra("QuizString", target);
                startActivity(saveQuiz);
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_response);
        init();
    }

}
