package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class TestTypes extends AppCompatActivity {

    public Button mcButton;
    public Button tfButton;
    public Button fbButton;

    private void init()
    {

        mcButton = (Button)findViewById(R.id.mcButton);
        mcButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Quiz newQuiz = new Quiz();
                //JSON Stuff
                Gson gS = new Gson();
                String target = gS.toJson(newQuiz);
                Intent openNewMultQuiz;
                openNewMultQuiz = new Intent(TestTypes.this, MultipleChoice_Activity.class);
                openNewMultQuiz.putExtra("QuizString", target);
                startActivity(openNewMultQuiz);
            }
        });

        tfButton = (Button)findViewById(R.id.tfButton);
        tfButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Quiz newQuiz = new Quiz();
                //JSON Stuff
                Gson gS = new Gson();
                String target = gS.toJson(newQuiz);
                Intent newTFQuiz;
                newTFQuiz = new Intent(TestTypes.this, TrueFalse_Activity.class);
                newTFQuiz.putExtra("QuizString", target);
                startActivity(newTFQuiz);
            }
        });

        fbButton = (Button)findViewById(R.id.fbButton);
        fbButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Quiz newQuiz = new Quiz();
                //JSON Stuff
                Gson gS = new Gson();
                String target = gS.toJson(newQuiz);
                Intent openFreeQuiz;
                openFreeQuiz = new Intent(TestTypes.this, FreeResponse_Activity.class);
                openFreeQuiz.putExtra("QuizString", target);
                startActivity(openFreeQuiz);
            }
        });
    }


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_types);
        init();
    }
}
