package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MultipleChoice_Activity extends AppCompatActivity {

    public Button nxtButton;
    public Button saveButton;
    public EditText qstTxt;
    public EditText corAns;
    public EditText incAns1;
    public EditText incAns2;
    public EditText incAns3;

    private void init(){
        nxtButton = (Button)findViewById(R.id.nxtButton);
        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextQuestion;
                nextQuestion = new Intent(MultipleChoice_Activity.this, MultipleChoice_Activity.class);
                startActivity(nextQuestion);
            }
        });

        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveQuiz;
                saveQuiz = new Intent(MultipleChoice_Activity.this, MainMenuActivity.class);
                startActivity(saveQuiz);
            }
        });

        //qstTxt = findViewById(R.id.qstTxt);
        //corAns = findViewById(R.id.corAns);
        //incAns1 = findViewById(R.id.incAns1);
        //incAns2 = findViewById(R.id.incAns2);
        //incAns3 = findViewById(R.id.incAns3);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_);
        init();
    }
}
