package com.example.ferna.mytesty;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestTypes extends AppCompatActivity {

    public Button mcButton;
    public Button tfButton;
    public Button fbButton;
    public Button saveButton;
    public TextInputLayout quizName;
    private Context context = this;
    private DatabaseReference mDatabase;
    public Quiz newQuiz;


    private void init()
    {
        final FirebaseStorage storage = FirebaseStorage.getInstance();
        Intent i = getIntent();
        if(i.getSerializableExtra("Quiz") != null)
            newQuiz = (Quiz)i.getSerializableExtra("Quiz");
        else
            newQuiz = new Quiz();

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
                finish();
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
                finish();
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
                finish();
            }
        });

        saveButton = (Button)findViewById(R.id.saveButton4);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Upload to cloud nonsense
                newQuiz.finish();
                UploadTask uploadTask = null;
                StorageReference storageRef = storage.getReference();
                StorageReference quizRef = storageRef.child(quizName.getEditText().getText().toString() + ".qiz");
                StorageReference quizUserRef = storageRef.child("user/" + quizName.getEditText().getText().toString() + ".qiz");

                // While the file names are the same, the references point to different files
                quizRef.getName().equals(quizUserRef.getName());    // true
                quizRef.getPath().equals(quizUserRef.getPath());    // false

                byte[] yourBytes = null;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out = null;
                try {
                    out = new ObjectOutputStream(bos);
                    out.writeObject(newQuiz);
                    out.flush();
                    yourBytes = bos.toByteArray();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bos.close();
                    } catch (IOException ex) {
                        // ignore close exception
                    }
                }

                uploadTask = quizRef.putBytes(yourBytes);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                        // ...
                    }
                });
                finish();
            }
        });
    }


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_types);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        init();
    }

}
