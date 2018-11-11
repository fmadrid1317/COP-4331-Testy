package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MultipleChoice_Activity extends AppCompatActivity {

    public Button saveButton;
    public TextInputLayout qstTxt;
    public TextInputLayout corAns;
    public TextInputLayout incAns1;
    public TextInputLayout incAns2;
    public TextInputLayout incAns3;
    private FirebaseAuth mAuth;
    public Quiz newQuiz;

    private DatabaseReference mDatabase;



    private void init(){
        Intent i = getIntent();
        newQuiz = (Quiz)i.getSerializableExtra("Quiz");

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
                newQuiz.addQuest(0, qstTxt.getEditText().toString(), corAns.getEditText().toString(), incAns1.getEditText().toString(),
                                    incAns2.getEditText().toString(), incAns3.getEditText().toString(), null);
                Intent testTypes = new Intent(MultipleChoice_Activity.this, TestTypes.class);
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
        setContentView(R.layout.activity_multiple_choice_);
        init();
    }
}
