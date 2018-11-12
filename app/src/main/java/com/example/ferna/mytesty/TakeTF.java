package com.example.ferna.mytesty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class TakeTF extends AppCompatActivity {

    public Button nextButton;
    public Button prevButton;
    public CheckBox tru;
    public CheckBox fal;
    public TextView quesText;
    public Quiz newQuiz;


    private void init()
    {
        nextButton = findViewById(R.id.nxtQuest3);
        prevButton = findViewById(R.id.prvQuest3);
        tru = findViewById(R.id.falseBox);
        fal = findViewById(R.id.trueBox);
        quesText = findViewById(R.id.tfText);

        Intent i = getIntent();
        newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        if(newQuiz.current.next == null)
            nextButton.setText("Finish");
        if(newQuiz.current.previous == null)
            prevButton.setText("");

        quesText.setText(newQuiz.current.getQuizQuestion());

        //Make sure only one box is checked
        onlyCheckOne();

        //Go to next question or show score on button click
        findNext();

        //Go to previous question on button click
        findPrevious();

    }

    private void checkAnswer()
    {
        if((newQuiz.current.getTruFal() == true) && (tru.isChecked()))
            newQuiz.current.setAnsweredCorrect(true);
        else if((newQuiz.current.getTruFal() == false) && (fal.isChecked()))
            newQuiz.current.setAnsweredCorrect(true);
        else
            newQuiz.current.setAnsweredCorrect(false);
    }

    private void onlyCheckOne()
    {
        tru.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(fal.isChecked())
                    fal.toggle();

                if(!tru.isChecked())
                    tru.toggle();
            }
        });

        fal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!fal.isChecked())
                    fal.toggle();

                if(tru.isChecked())
                    tru.toggle();
            }
        });
    }

    private void findNext()
    {
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                checkAnswer();
                if(newQuiz.current.next != null) {
                    newQuiz.nextQuestion();
                    if (newQuiz.current.getQuesType() == 0) {
                        Intent takeMC = new Intent(TakeTF.this, TakeMC.class);
                        takeMC.putExtra("Quiz", newQuiz);
                        startActivity(takeMC);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 1) {
                        Intent takeTF = new Intent(TakeTF.this, TakeTF.class);
                        takeTF.putExtra("Quiz", newQuiz);
                        startActivity(takeTF);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 2) {
                        Intent takeFR = new Intent(TakeTF.this, TakeFR.class);
                        takeFR.putExtra("Quiz", newQuiz);
                        startActivity(takeFR);
                        finish();
                    }
                }
                else
                {
                    Intent finishQuiz = new Intent(TakeTF.this, GetScore.class);
                    finishQuiz.putExtra("Quiz", newQuiz);
                    startActivity(finishQuiz);
                    finish();
                }
            }
        });
    }

    private void findPrevious()
    {
        prevButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                checkAnswer();
                if(newQuiz.current.previous != null)
                {
                    newQuiz.previousQuestion();
                    if (newQuiz.current.getQuesType() == 0) {
                        Intent takeMC = new Intent(TakeTF.this, TakeMC.class);
                        takeMC.putExtra("Quiz", newQuiz);
                        startActivity(takeMC);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 1) {
                        Intent takeTF = new Intent(TakeTF.this, TakeTF.class);
                        takeTF.putExtra("Quiz", newQuiz);
                        startActivity(takeTF);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 2) {
                        Intent takeFR = new Intent(TakeTF.this, TakeFR.class);
                        takeFR.putExtra("Quiz", newQuiz);
                        startActivity(takeFR);
                        finish();
                    }
                }
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_tf);
        init();
    }
}
