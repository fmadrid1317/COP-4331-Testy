package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FreeResponse_Activity extends AppCompatActivity
{

    public Button nxtButton;
    public Button saveButton;
    public EditText qstTxt;
    public EditText corAns;

    private void init()
    {
        nxtButton = (Button)findViewById(R.id.nxtButton3);
        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextQuestion;
                nextQuestion = new Intent(FreeResponse_Activity.this, FreeResponse_Activity.class);
                startActivity(nextQuestion);
            }
        });

        saveButton = (Button)findViewById(R.id.saveButton3);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveQuiz;
                saveQuiz = new Intent(FreeResponse_Activity.this, MainMenuActivity.class);
                startActivity(saveQuiz);
            }
        });

        //qstTxt = findViewById(R.id.qstTxt);
        //corAns = findViewById(R.id.corAns);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_response);
        init();
    }

}
