package com.example.admin.randomuserapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RandomUserDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_user_detail);
        Intent intent = getIntent();

            String firstName = intent.getStringExtra("username");
            String email = intent.getStringExtra("email");
            TextView username = findViewById(R.id.username);
            TextView useremail = findViewById(R.id.email);
            username.setText(firstName);
            useremail.setText(email);


    }
}
