package com.example.ferna.mytesty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

public class MainMenuActivity extends AppCompatActivity {

    public Button newTestButton;
    public Button signoutButton;
    private FirebaseAuth mAuth;



    private void init()
    {
        newTestButton = (Button)findViewById(R.id.newTestButton);
        newTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTestTypes;
                openTestTypes = new Intent(MainMenuActivity.this, TestTypes.class);
                startActivity(openTestTypes);
            }
        });

        signoutButton = (Button)findViewById(R.id.sign_out_button);
        signoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                Toast.makeText(MainMenuActivity.this, "Sign Out Successful",
                        Toast.LENGTH_SHORT).show();
                Intent backToLogin;
                backToLogin = new Intent(MainMenuActivity.this, LoginActivity.class);
                startActivity(backToLogin);
            }
        });
    }



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        init();
    }
}
