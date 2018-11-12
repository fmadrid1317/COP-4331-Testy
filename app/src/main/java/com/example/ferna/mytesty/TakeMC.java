package com.example.ferna.mytesty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class TakeMC extends AppCompatActivity {

    public Button nextButton;
    public Button prevButton;
    public CheckBox ans1;
    public CheckBox ans2;
    public CheckBox ans3;
    public CheckBox ans4;
    public TextView quesText;
    public Quiz newQuiz;


    private void init()
    {
        nextButton = findViewById(R.id.nxtQuest);
        prevButton = findViewById(R.id.prvQuest);
        ans1 = findViewById(R.id.checkBox3);
        ans2 = findViewById(R.id.checkBox);
        ans3 = findViewById(R.id.checkBox2);
        ans4 = findViewById(R.id.checkBox4);
        quesText = findViewById(R.id.mcText);

        Intent i = getIntent();
        newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        if(newQuiz.current.next == null)
            nextButton.setText("Finish");
        if(newQuiz.current.previous == null)
            prevButton.setText("");

        quesText.setText(newQuiz.current.getQuizQuestion());
        ans1.setText(newQuiz.current.getCorrAns());
        ans2.setText(newQuiz.current.getWrongAns1());
        ans3.setText(newQuiz.current.getWrongAns2());
        ans4.setText(newQuiz.current.getWrongAns3());

        //Make sure only one box is checked
        onlyCheckOne();

        //Go to next question or show score on button click
        findNext();

        //Go to previous question on button click
        findPrevious();

    }

    private void onlyCheckOne()
    {
        ans1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!ans1.isChecked())
                    ans1.toggle();

                if(ans2.isChecked())
                    ans2.toggle();

                if(ans3.isChecked())
                    ans3.toggle();

                if(ans4.isChecked())
                    ans4.toggle();
            }
        });

        ans2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(ans1.isChecked())
                    ans1.toggle();

                if(!ans2.isChecked())
                    ans2.toggle();

                if(ans3.isChecked())
                    ans3.toggle();

                if(ans4.isChecked())
                    ans4.toggle();
            }
        });

        ans3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(ans1.isChecked())
                    ans1.toggle();

                if(ans2.isChecked())
                    ans2.toggle();

                if(!ans3.isChecked())
                    ans3.toggle();

                if(ans4.isChecked())
                    ans4.toggle();
            }
        });

        ans4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(ans1.isChecked())
                    ans1.toggle();

                if(ans2.isChecked())
                    ans2.toggle();

                if(ans3.isChecked())
                    ans3.toggle();

                if(!ans4.isChecked())
                    ans4.toggle();
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
                if(newQuiz.current.next != null) {
                    newQuiz.nextQuestion();
                    if (newQuiz.current.getQuesType() == 0) {
                        Intent takeMC = new Intent(TakeMC.this, TakeMC.class);
                        takeMC.putExtra("Quiz", newQuiz);
                        startActivity(takeMC);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 1) {
                        Intent takeTF = new Intent(TakeMC.this, TakeTF.class);
                        takeTF.putExtra("Quiz", newQuiz);
                        startActivity(takeTF);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 2) {
                        Intent takeFR = new Intent(TakeMC.this, TakeFR.class);
                        takeFR.putExtra("Quiz", newQuiz);
                        startActivity(takeFR);
                        finish();
                    }
                }
                else
                {
                    Intent finishQuiz = new Intent(TakeMC.this, GetScore.class);
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
                if(newQuiz.current.previous != null)
                {
                    newQuiz.previousQuestion();
                    if (newQuiz.current.getQuesType() == 0) {
                        Intent takeMC = new Intent(TakeMC.this, TakeMC.class);
                        takeMC.putExtra("Quiz", newQuiz);
                        startActivity(takeMC);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 1) {
                        Intent takeTF = new Intent(TakeMC.this, TakeTF.class);
                        takeTF.putExtra("Quiz", newQuiz);
                        startActivity(takeTF);
                        finish();
                    } else if (newQuiz.current.getQuesType() == 2) {
                        Intent takeFR = new Intent(TakeMC.this, TakeFR.class);
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
        setContentView(R.layout.activity_take_mc);
        init();
    }
}
