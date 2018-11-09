package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class MultipleChoice_Activity extends AppCompatActivity {

    public Button nxtButton;
    public Button saveButton;
    public TextInputLayout qstTxt;
    public TextInputLayout corAns;
    public TextInputLayout incAns1;
    public TextInputLayout incAns2;
    public TextInputLayout incAns3;





    private void init(){
        Intent i = getIntent();
        final Quiz newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        qstTxt = findViewById(R.id.qstTxt);
        corAns = findViewById(R.id.corAns);
        incAns1 = findViewById(R.id.incAns1);
        incAns2 = findViewById(R.id.incAns2);
        incAns3 = findViewById(R.id.incAns3);

        nxtButton = (Button)findViewById(R.id.nxtButton);
        nxtButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(qstTxt != null)
                    newQuiz.current.quizQuestion = qstTxt.getEditText();
                if(corAns != null)
                    newQuiz.current.corrAns = corAns.getEditText();
                if(incAns1 != null)
                    newQuiz.current.wrongAns1 = incAns1.getEditText();
                if(incAns2 != null)
                    newQuiz.current.wrongAns2 = incAns2.getEditText();
                if(incAns3 != null)
                    newQuiz.current.wrongAns3 = incAns3.getEditText();
                //newQuiz.addQuest(0);
                finish();
                //Intent nextQuestion;
                //nextQuestion = new Intent(MultipleChoice_Activity.this, MultipleChoice_Activity.class);
                //nextQuestion.putExtra("Quiz", newQuiz);
                //startActivity(nextQuestion);
            }
        });

        /*saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(qstTxt != null)
                    newQuiz.current.quizQuestion = qstTxt.getEditText();
                if(corAns != null)
                    newQuiz.current.corrAns = corAns.getEditText();
                if(incAns1 != null)
                    newQuiz.current.wrongAns1 = incAns1.getEditText();
                if(incAns2 != null)
                    newQuiz.current.wrongAns2 = incAns2.getEditText();
                if(incAns3 != null)
                    newQuiz.current.wrongAns3 = incAns3.getEditText();
                Intent saveQuiz;
                saveQuiz = new Intent(MultipleChoice_Activity.this, MainMenuActivity.class);
                saveQuiz.putExtra("Quiz", newQuiz);
                startActivity(saveQuiz);
            }
        });*/


    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_);
        init();
    }
}
