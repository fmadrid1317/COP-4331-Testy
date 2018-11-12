package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class TrueFalse_Activity extends AppCompatActivity
{

    public Button saveButton;
    public TextInputLayout qstTxt;
    public CheckBox trueCheck;
    public CheckBox falseCheck;
    public Quiz newQuiz;


    private void init()
    {
        Intent i = getIntent();
        newQuiz = (Quiz)i.getSerializableExtra("Quiz");

        qstTxt = findViewById(R.id.qstTxt);
        trueCheck = findViewById(R.id.trueCheck);
        falseCheck = findViewById(R.id.falseCheck);
        saveButton = findViewById(R.id.saveButton2);

        trueCheck.toggle();

        //Make sure only one box is checked
        trueCheck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(falseCheck.isChecked())
                    falseCheck.toggle();

                if(!trueCheck.isChecked())
                    trueCheck.toggle();
            }
        });

        falseCheck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!falseCheck.isChecked())
                    falseCheck.toggle();

                if(trueCheck.isChecked())
                    trueCheck.toggle();
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                newQuiz.addQuest(1, qstTxt.getEditText().getText().toString(), null, null, null, null, trueCheck.hasSelection());
                Intent testTypes = new Intent(TrueFalse_Activity.this, TestTypes.class);
                testTypes.putExtra("Quiz", newQuiz);
                startActivity(testTypes);
                finish();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);
        init();
    }

}


