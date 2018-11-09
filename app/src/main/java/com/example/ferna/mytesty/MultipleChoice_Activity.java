package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultipleChoice_Activity extends AppCompatActivity {

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

        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                newQuiz.addQuest(0);
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
                finish();

            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_);
        init();
    }
}
