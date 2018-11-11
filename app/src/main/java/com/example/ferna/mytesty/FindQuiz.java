package com.example.ferna.mytesty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class FindQuiz extends AppCompatActivity
{
    public Button findButton;
    public TextInputLayout quizName;
    private DatabaseReference mDatabase;


    private void init()
    {
        final FirebaseStorage storage = FirebaseStorage.getInstance();
        final Quiz newQuiz = null;

        findButton = (Button)findViewById(R.id.findButton);
        findButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Download Bytes from Cloud nonsense
                byte[] bytes = null;
                UploadTask uploadTask = null;
                StorageReference storageRef = storage.getReference();
                StorageReference quizRef = storageRef.child(quizName.getEditText().getText().toString() + ".qiz");
                StorageReference quizUserRef = storageRef.child("user/" + quizName.getEditText().getText().toString() + ".qiz");
                StorageReference gsReference = storage.getReferenceFromUrl("gs://bucket/user/"+quizName.getEditText().getText().toString()+".qiz");

                StorageReference islandRef = storageRef.child("images/island.jpg");

                final long ONE_MEGABYTE = 1024 * 1024;
                islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // Data for "images/island.jpg" is returns, use this as needed
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

                //MakeTheQuiz (Still Needs Work)
                /*ObjectInput in = null;
                try {
                    in = new ObjectInputStream(bytes);
                    newQuiz = in.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException ex) {
                        // ignore close exception
                    }
                }

                finish();*/
            }
        });
    }


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_quiz);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        init();
    }
}
