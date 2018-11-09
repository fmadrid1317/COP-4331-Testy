package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FreeResponse_Activity extends AppCompatActivity
{

    public Button saveButton;
    public TextInputLayout qstTxt;
    public TextInputLayout corAns;

    private void init()
    {
        Intent i = getIntent();
        final Quiz newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        qstTxt = findViewById(R.id.qstTxt);
        corAns = findViewById(R.id.corAns);

        saveButton = (Button)findViewById(R.id.saveButton3);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                newQuiz.addQuest(2);
                if(qstTxt != null)
                    newQuiz.current.quizQuestion = qstTxt.getEditText();
                if(corAns != null)
                    newQuiz.current.corrAns = corAns.getEditText();
                finish();
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
