package com.example.ud_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private RadioButton rd1;
    private RadioButton rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rd1=findViewById(R.id.bus);
        rd2=findViewById(R.id.it);
    }

    //Option1 :click on images

    public void it(View v)
    {
        rd2.toggle();
    }
    public  void business(View v)
    {
        rd1.toggle();
    }


    //Option 2:click on radio buttons
    public void cont(View v)
    {
       if (rd1.isChecked())
       {
           Intent i = new Intent(this,Businnes_college.class);
           startActivity(i);
       }
       if(rd2.isChecked())
       {
           Intent i = new Intent(this,it_college.class);
           startActivity(i);
       }
       else
       {
           if (!rd1.isChecked() && !rd2.isChecked())
           {
               Context context = getApplicationContext();
               CharSequence text = "Error:you need to choose one college";
               int duration = Toast.LENGTH_LONG;
               Toast error =  Toast.makeText(context,text,duration);
               error.show();
           }

       }
    }
}