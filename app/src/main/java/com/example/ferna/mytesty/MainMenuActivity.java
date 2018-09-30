package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    public Button newTestButton;

    public void init(){
        newTestButton = (Button)findViewById(R.id.newTestButton);
        newTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTestTypes;
                openTestTypes = new Intent(MainMenuActivity.this, TestTypes.class);
                startActivity(openTestTypes);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        init();
    }
}
