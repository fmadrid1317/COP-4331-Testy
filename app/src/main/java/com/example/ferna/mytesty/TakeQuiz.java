package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class TakeQuiz extends AppCompatActivity {

    private static final String TAG = "TakeQuiz";

    public Quiz newQuiz;
    public TextView question;
    public CheckBox chkBox1;
    public CheckBox chkBox2;
    public CheckBox chkBox3;
    public CheckBox chkBox4;
    public TextInputLayout ansFR;
    public Button prev;
    public Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_take_quiz);


        Intent tkQuiz = getIntent();


        if(tkQuiz.getSerializableExtra("Quiz") != null)
            newQuiz = (Quiz)tkQuiz.getSerializableExtra("Quiz");
        else
            newQuiz = new Quiz();

        newQuiz.nextQuestion();


       // Log.d(TAG, "The magic number is "+newQuiz.current.getQuesType());


        // System.out.println("The magic number is "+newQuiz.current.getQuesType());

        while(newQuiz.current != null) {



            //Multiple Choice
            if (newQuiz.current.getQuesType() == 0) {

                Intent takeMC;
                takeMC = new Intent(TakeQuiz.this, TakeMC.class);
                takeMC.putExtra("Quiz", newQuiz);
                startActivity(takeMC);
                setContentView(R.layout.activity_take_mc);
                question = (TextView)findViewById(R.id.mcText);
                question.setText(newQuiz.current.getQuizQuestion());
                chkBox1 = (CheckBox)findViewById(R.id.checkBox);
                chkBox1.setText(newQuiz.current.getCorrAns());
                chkBox2 = (CheckBox)findViewById(R.id.checkBox2);
                chkBox2.setText(newQuiz.current.getWrongAns1());
                chkBox3 = (CheckBox)findViewById(R.id.checkBox3);
                chkBox3.setText(newQuiz.current.getWrongAns2());
                chkBox4 = (CheckBox)findViewById(R.id.checkBox4);
                chkBox4.setText(newQuiz.current.getWrongAns3());

             //True False
            }else if (newQuiz.current.getQuesType() == 1) {

                Intent takeTF;
                takeTF = new Intent(TakeQuiz.this, TakeTF.class);
                takeTF.putExtra("Quiz", newQuiz);
                startActivity(takeTF);
                setContentView(R.layout.activity_take_tf);
                question = (TextView)findViewById(R.id.tfText);
                question.setText(newQuiz.current.getQuizQuestion());
                chkBox1 = (CheckBox)findViewById(R.id.trueBox);
                chkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                    {
                        if ( isChecked )
                        {

                        }

                    }
                });
                chkBox2 = (CheckBox)findViewById(R.id.falseBox);
                chkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                    {
                        if ( isChecked )
                        {
                            // perform logic
                        }

                    }
                });
                newQuiz.nextQuestion();

             //Free Response
            }else if (newQuiz.current.getQuesType() == 2) {

                Intent takeFR;
                takeFR = new Intent(TakeQuiz.this, TakeFR.class);
                takeFR.putExtra("Quiz", newQuiz);
                startActivity(takeFR);
                setContentView(R.layout.activity_take_fr);
                question = (TextView)findViewById(R.id.frText);
                question.setText(newQuiz.current.getQuizQuestion());
                ansFR = (TextInputLayout)findViewById(R.id.corAns);
                newQuiz.nextQuestion();
            }

        }

    }
}
