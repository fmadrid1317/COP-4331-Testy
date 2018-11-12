package com.example.ferna.mytesty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class FindQuiz extends AppCompatActivity
{
    public Button findButton;
    public TextInputLayout quizName;
    public ObjectInput in = null;
    private DatabaseReference mDatabase;
    public Quiz newQuiz;
    public FirebaseStorage storage;

    private void init()
    {
        storage = FirebaseStorage.getInstance();

        quizName = findViewById(R.id.fndQuiz);

        findButton = (Button)findViewById(R.id.findButton);
        findButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Download Bytes from Cloud nonsense
                UploadTask uploadTask = null;
                StorageReference storageRef = storage.getReference();
                StorageReference quizRef = storageRef.child(quizName.getEditText().getText().toString() + ".qiz");
                //StorageReference quizUserRef = storageRef.child("user/" + quizName.getEditText().getText().toString() + ".qiz");
                //StorageReference quizUserRef = storageRef.child(quizName.getEditText().getText().toString() + ".qiz");
                //StorageReference gsReference = storage.getReferenceFromUrl("gs://cop-4331c-project-testy.appspot.com"+quizName.getEditText().getText().toString()+".qiz");

                final long ONE_MEGABYTE = 1024 * 1024;
                quizRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes)
                    {
                        //Make The Quiz
                        newQuiz = setData(bytes);
                        newQuiz.nextQuestion();

                        //Start the quiz
                        if(newQuiz.head.getQuesType() == 0)
                        {
                            Intent takeMC = new Intent(FindQuiz.this, TakeMC.class);
                            takeMC.putExtra("Quiz", newQuiz);
                            startActivity(takeMC);
                            finish();
                        }

                        else if(newQuiz.head.getQuesType() == 1)
                        {
                            Intent takeTF = new Intent(FindQuiz.this, TakeTF.class);
                            takeTF.putExtra("Quiz", newQuiz);
                            startActivity(takeTF);
                            finish();
                        }

                        else if(newQuiz.head.getQuesType() == 2)
                        {
                            Intent takeFR = new Intent(FindQuiz.this, TakeFR.class);
                            takeFR.putExtra("Quiz", newQuiz);
                            startActivity(takeFR);
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

                //finish();
            }
        });
    }

    private Quiz setData(byte[] bytes)
    {
        Quiz tempQuiz = null;
        try
        {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            in = new ObjectInputStream(bis);
            tempQuiz = (Quiz)in.readObject();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (in != null)
                    in.close();
            }
            catch (IOException ex)
            {
                // ignore close exception
            }
            return tempQuiz;
        }
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_quiz);
        //storage = FirebaseStorage.getInstance();
        init();
    }
}
