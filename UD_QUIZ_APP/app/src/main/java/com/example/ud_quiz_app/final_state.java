package com.example.ud_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import org.w3c.dom.Text;

public class final_state extends AppCompatActivity {

    private TextView correctct;
    private CircularProgressBar finalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_state);
        getSupportActionBar().hide();

        correctct=findViewById(R.id.ct);
        String correct_answers =getIntent().getStringExtra("OOP");
        correctct.setText(correct_answers);

        finalc=findViewById(R.id.circularProgressBar);
        finalc.setProgressMax(15);
        finalc.setProgress(Integer.parseInt(correct_answers));

    }
    public void return_back(View v ){
        Intent i = new Intent(this,login.class);
        startActivity(i);
    }
}