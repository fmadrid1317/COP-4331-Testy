package com.example.ferna.mytesty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Random;

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

        if(!newQuiz.current.getRandomized())
            randomAssign();

        ans1.setText(newQuiz.current.getRandomizedAnswer(0));
        ans2.setText(newQuiz.current.getRandomizedAnswer(1));
        ans3.setText(newQuiz.current.getRandomizedAnswer(2));
        ans4.setText(newQuiz.current.getRandomizedAnswer(3));

        loadAnswer();

        //Make sure only one box is checked
        onlyCheckOne();

        //Go to next question or show score on button click
        findNext();

        //Go to previous question on button click
        findPrevious();

    }

    //Bad randomization of answer choices
    private void randomAssign()
    {   int randInt;
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        newQuiz.current.setRandomized(true);

        randInt = rnd.nextInt(4);
        newQuiz.current.setCorrAnsPlace(randInt);

        while(randInt == newQuiz.current.getCorrAnsPlace())
        {
            randInt = rnd.nextInt(4);
            newQuiz.current.setWrongAns1Place(randInt);
        }

        while((randInt == newQuiz.current.getCorrAnsPlace()) || (randInt == newQuiz.current.getWrongAns1Place()))
        {
            randInt = rnd.nextInt(4);
            newQuiz.current.setWrongAns2Place(randInt);
        }

        if((newQuiz.current.getCorrAnsPlace() != 0) && (newQuiz.current.getWrongAns1Place() != 0) && (newQuiz.current.getWrongAns2Place() != 0))
            newQuiz.current.setWrongAns3Place(0);
        else if((newQuiz.current.getCorrAnsPlace() != 1) && (newQuiz.current.getWrongAns1Place() != 1) && (newQuiz.current.getWrongAns2Place() != 1))
            newQuiz.current.setWrongAns3Place(1);
        else if((newQuiz.current.getCorrAnsPlace() != 2) && (newQuiz.current.getWrongAns1Place() != 2) && (newQuiz.current.getWrongAns2Place() != 2))
            newQuiz.current.setWrongAns3Place(2);
        else
            newQuiz.current.setWrongAns3Place(3);

    }

    private void loadAnswer()
    {
        if(newQuiz.current.getSavedAnswer().equals("0"))
            ans1.toggle();
        else if(newQuiz.current.getSavedAnswer().equals("1"))
            ans2.toggle();
        else if(newQuiz.current.getSavedAnswer().equals("2"))
            ans3.toggle();
        else if(newQuiz.current.getSavedAnswer().equals("3"))
            ans4.toggle();
    }

    private void saveAnswer()
    {
        if(ans1.isChecked())
            newQuiz.current.setSavedAnswer("0");
        else if(ans2.isChecked())
            newQuiz.current.setSavedAnswer("1");
        else if(ans3.isChecked())
            newQuiz.current.setSavedAnswer("2");
        else if(ans4.isChecked())
            newQuiz.current.setSavedAnswer("3");

    }

    private void checkAnswer()
    {
        if(ans1.isChecked())
        {
            if(ans1.getText().toString().equals(newQuiz.current.getCorrAns()))
                newQuiz.current.setAnsweredCorrect(true);
            else
                newQuiz.current.setAnsweredCorrect(false);
        }
        else if(ans2.isChecked())
        {
            if(ans2.getText().toString().equals(newQuiz.current.getCorrAns()))
                newQuiz.current.setAnsweredCorrect(true);
            else
                newQuiz.current.setAnsweredCorrect(false);
        }
        else if(ans3.isChecked())
        {
            if(ans3.getText().toString().equals(newQuiz.current.getCorrAns()))
                newQuiz.current.setAnsweredCorrect(true);
            else
                newQuiz.current.setAnsweredCorrect(false);
        }
        else if(ans4.isChecked())
        {
            if(ans4.getText().toString().equals(newQuiz.current.getCorrAns()))
                newQuiz.current.setAnsweredCorrect(true);
            else
                newQuiz.current.setAnsweredCorrect(false);
        }
        else
            newQuiz.current.setAnsweredCorrect(false);
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
                checkAnswer();
                saveAnswer();
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
                checkAnswer();
                saveAnswer();
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
