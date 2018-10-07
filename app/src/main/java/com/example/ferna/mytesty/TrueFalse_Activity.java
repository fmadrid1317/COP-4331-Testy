package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;

public class TrueFalse_Activity extends AppCompatActivity
{

    public Button nxtButton;
    public Button saveButton;
    public EditText qstTxt;
    public CheckBox trueCheck;
    public CheckBox falseCheck;

    private void init()
    {
        nxtButton = (Button)findViewById(R.id.nxtButton2);
        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextQuestion;
                nextQuestion = new Intent(TrueFalse_Activity.this, TrueFalse_Activity.class);
                startActivity(nextQuestion);
            }
        });

        saveButton = (Button)findViewById(R.id.saveButton2);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveQuiz;
                saveQuiz = new Intent(TrueFalse_Activity.this, MainMenuActivity.class);
                startActivity(saveQuiz);
            }
        });

        //qstTxt = findViewById(R.id.qstTxt);
        trueCheck = findViewById(R.id.trueCheck);
        falseCheck = findViewById(R.id.falseCheck);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);
        init();
    }

}


