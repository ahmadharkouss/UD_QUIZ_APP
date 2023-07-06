package com.example.ud_quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.view.View;

public class it_college extends AppCompatActivity implements MyAdapter.onNotelistener {
    RecyclerView recyclerview;
    String s1[];
    int images[] ={R.drawable.os , R.drawable .infosec , R.drawable.oop , R.drawable.math  , R.drawable.networking,R.drawable.math , R.drawable.internet_application,R.drawable.electronics,R.drawable.microprocessors,R.drawable.physics,R.drawable.signal_processing,R.drawable.physics};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_college);

        recyclerview = findViewById(R.id.rec);
        s1=getResources().getStringArray(R.array.courses);


        MyAdapter myadapter = new MyAdapter(this,s1,images,this);
        Spacing it = new Spacing(65);
        recyclerview.addItemDecoration(it);
        recyclerview.setAdapter(myadapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onnoteclick(int position) {
        final Intent intent;
        switch (position)
        {
            case 0:
                intent=new Intent(this,OS_QUIZ.class);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(this,info_sec_quiz.class);
                startActivity(intent);
                break;

            default:
                break;

        }

    }
}