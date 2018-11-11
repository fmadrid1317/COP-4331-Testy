package com.example.ferna.mytesty;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestTypes extends AppCompatActivity {

    public Button mcButton;
    public Button tfButton;
    public Button fbButton;
    public Button saveButton;
    public TextInputLayout quizName;
    private Context context = this;

    private DatabaseReference mDatabase;


    private void init()
    {
        final Quiz newQuiz = new Quiz();

        quizName = findViewById(R.id.qizName);

        mcButton = (Button)findViewById(R.id.mcButton);
        mcButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent openNewMultQuiz;
                openNewMultQuiz = new Intent(TestTypes.this, MultipleChoice_Activity.class);
                openNewMultQuiz.putExtra("Quiz", newQuiz);
                startActivity(openNewMultQuiz);
            }
        });

        tfButton = (Button)findViewById(R.id.tfButton);
        tfButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent newTFQuiz;
                newTFQuiz = new Intent(TestTypes.this, TrueFalse_Activity.class);
                newTFQuiz.putExtra("Quiz", newQuiz);
                startActivity(newTFQuiz);
            }
        });

        fbButton = (Button)findViewById(R.id.fbButton);
        fbButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent openFreeQuiz;
                openFreeQuiz = new Intent(TestTypes.this, FreeResponse_Activity.class);
                openFreeQuiz.putExtra("Quiz", newQuiz);
                startActivity(openFreeQuiz);
            }
        });

        saveButton = (Button)findViewById(R.id.saveButton4);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FileOutputStream fos = null;
                try {
                    fos = context.openFileOutput(quizName.getEditText().toString(), Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try (ObjectOutputStream os = new ObjectOutputStream(fos))
                {

                    os.writeObject(newQuiz);
                    os.close();
                    fos.close();
                    //Log.d("Uhh", "FUG");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                finish();
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
