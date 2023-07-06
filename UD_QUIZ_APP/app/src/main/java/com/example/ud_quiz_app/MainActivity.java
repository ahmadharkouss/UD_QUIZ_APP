package com.example.ud_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btn=findViewById(R.id.Main_btn);
    }
    public void onclick(View v)
    {
        Intent i = new Intent(this , login.class);
        startActivity(i);

    }
    public void oninfo(View v)
    {
        Toast.makeText(this,"This app was designed to help UD students study for their exams.",Toast.LENGTH_LONG).show();

    }
}