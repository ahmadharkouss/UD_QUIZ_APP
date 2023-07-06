package com.example.ud_quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.view.View;

public class Businnes_college extends AppCompatActivity implements MyAdapter.onNotelistener {
    RecyclerView recyclerview;
    String s1[];
    int images[] ={R.drawable.financial_accunting,R.drawable.starategic_management,R.drawable.internationalagreements,R.drawable.auditing,R.drawable.internationalagreements,R.drawable.financial_accunting,R.drawable.businesslaw,R.drawable.businesssociety,R.drawable.starategic_management,R.drawable.hsn,R.drawable.internationalagreements,R.drawable.microecomics};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businnes_college);
        recyclerview = findViewById(R.id.rec);
        s1=getResources().getStringArray(R.array.courses2);


        MyAdapter myadapter = new MyAdapter(this,s1,images,this);
        Spacing it = new Spacing(65);
        recyclerview.addItemDecoration(it);
        recyclerview.setAdapter(myadapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    //need to change

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