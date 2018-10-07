package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultipleChoice_Activity extends AppCompatActivity {

    public Button nxtButton;
    public Button saveButton;

    private void init(){
        nxtButton = (Button)findViewById(R.id.nxtButton);
        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTestTypes;
                openTestTypes = new Intent(MultipleChoice_Activity.this, MultipleChoice_Activity.class);
                startActivity(openTestTypes);
            }
        });

        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTestTypes;
                openTestTypes = new Intent(MultipleChoice_Activity.this, MainMenuActivity.class);
                startActivity(openTestTypes);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_);
        init();
    }
}
