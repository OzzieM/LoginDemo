package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tView = findViewById(R.id.welcomeText);

        Bundle name = getIntent().getExtras();
        String n = name.getString("name");
        String welcomeMSG = ("Welcome " + n);
        tView.setText(welcomeMSG);
    }
}