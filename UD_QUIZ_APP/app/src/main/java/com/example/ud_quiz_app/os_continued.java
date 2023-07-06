package com.example.ud_quiz_app;

import static com.example.ud_quiz_app.OS_QUIZ.listofq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class os_continued extends AppCompatActivity {
    //declare variables
    CountDownTimer countDownTimer;

    //progres bar =number of questions remaining
    int prog=0;

    //progressbar=for number of questions
    ProgressBar progressBar;

    ArrayList<model> listall;
    model model;

    //index for object list
    int index=0;

    //time for timer
    int timer=0;
    int mintimer=0;

    TextView timer_display;
    //texts
    TextView card ,pa,pb,pc,pd;
    //cards
    CardView cd , ca , cb , cc , ce;

    //next button
    Button btn;

     int correctcount=0;//?
     int wrongcount=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_continued);
        getSupportActionBar().hide();
        timer_display=findViewById(R.id.timer);

        //get all id from layout
        Hooks();
        //add list from previous activity
        listall=listofq;
        //shuffle all objects in the list = shuffle questions
        Collections.shuffle(listall);
        //starts with index 0 of the list
        model=listofq.get(index);
        //set data of object to the layout
        setalldata();
        //add click listeners to options
        addonclick();



        //quiz timer
        //8min=480s
        // 480sx10^3ms
        countDownTimer=new CountDownTimer(480000,1000) {
            @Override
            public void onTick(long l) {
                if(timer<10)
                {
                    if(mintimer<10)
                    {
                        //01:01
                        timer_display.setText("0"+mintimer+":0"+timer);
                    }
                    else

                    {
                        //11:01
                        timer_display.setText(mintimer+":0"+timer);
                    }

                }
                if(timer<60 && timer>10)
                {
                    if(mintimer<10)
                    {
                        //01:10
                        timer_display.setText("0"+mintimer+":"+timer);
                    }
                    else
                    {
                        //15:15
                        timer_display.setText(mintimer+":"+timer);
                    }

                }
                if(timer==60)
                {
                    timer=0;
                    mintimer+=1;
                }

                timer++;

            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(os_continued.this , R.style.dialog);
                dialog.setContentView(R.layout.timout);
                dialog.show();
                dialog.findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i= new Intent(os_continued.this,OS_QUIZ.class);
                        startActivity(i);
                    }
                });

            }
        }.start();
    }



    //exit button listenner

    public void exit(View view)
    {
        Intent i = new Intent(this,OS_QUIZ.class);
        startActivity(i);
    }

    //next button listenner

    public void onnext(View v)
    {
       //add if no button is pressed

            prog++;
            progressBar.setProgress(prog);

            resetcolor();
            enablebutton();

            //set limit depending on number  of questions
            //all questions before last question
            if(index <listall.size()-1)
            {


                index++;
                //get the next object
                model=listall.get(index);
                //set the new values of the next object
                setalldata();
            }
            //last question
            //Game won=end of the quiz
            else{
                Gamewon();

            }


    }


    //set values of object to the layout
    private void setalldata() {
        card.setText(model.getQuestion());
        pa.setText(model.getOa());
        pb.setText(model.getOb());
        pc.setText(model.getOc());
        pd.setText(model.getOd());

    }

    //get id from layout
    private void Hooks() {
        //progressbar
        progressBar=findViewById(R.id.progressBar);

        //cards
        cd=findViewById(R.id.card);
        ca=findViewById(R.id.A);
        cb=findViewById(R.id.B);
        cc=findViewById(R.id.C);
        ce=findViewById(R.id.D);

        //text
        card=findViewById(R.id.quest);
        pa=findViewById(R.id.opa);
        pb=findViewById(R.id.opb);
        pc=findViewById(R.id.opc);
        pd=findViewById(R.id.opd);

        //next button

        btn=findViewById(R.id.next);
    }


    //answer is correct
    public void correct()
    {
        correctcount++;

    }

    //answer is wrong
    public void wrong()
    {
        wrongcount++;

    }

    //end of the quiz
    private void Gamewon() {
        Intent intent = new Intent(os_continued.this,final_state.class);
        String w= String.valueOf(wrongcount);
        String c= String.valueOf(correctcount);
        intent.putExtra("OOP" ,c);
        intent.putExtra("OOP2" ,w);
        startActivity(intent);


    }

    //enable cards to be clicked
    public void enablebutton()
    {
        ca.setClickable(true);
        cb.setClickable(true);
        cc.setClickable(true);
        ce.setClickable(true);
    }


    //disable cards to be clicked
    public void disablebutton()
    {
        ca.setClickable(false);
        cb.setClickable(false);
        cc.setClickable(false);
        ce.setClickable(false);

    }

    //colors of button in corrolation of answers

    //reset colors of button

    public void resetcolor()
    {
        ca.setCardBackgroundColor(getResources().getColor(R.color.white));
        cb.setCardBackgroundColor(getResources().getColor(R.color.white));
        cc.setCardBackgroundColor(getResources().getColor(R.color.white));
        ce.setCardBackgroundColor(getResources().getColor(R.color.white));
    }



    //add onclicklistener for the options cards
    public void addonclick()
    {
        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if oa==the answer , change the color of the card to green
                if(model.getOa().equals(model.getAnswer()))
                {
                    ca.setCardBackgroundColor(getResources().getColor(R.color.green));
                    //start correct function
                    correct();
                    //disable button
                    disablebutton();
                }
                else
                {
                    ca.setCardBackgroundColor(getResources().getColor(R.color.red));
                    wrong();
                    //disable button
                    disablebutton();

                }



            }
        });

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if ob==the answer , change the color of the card to green
                if(model.getOb().equals(model.getAnswer()))
                {
                    cb.setCardBackgroundColor(getResources().getColor(R.color.green));
                    correct();
                }
                else
                {
                    cb.setCardBackgroundColor(getResources().getColor(R.color.red));
                    wrong();
                    //disable button
                    disablebutton();

                }

            }
        });

        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if oc==the answer , change the color of the card to green
                if(model.getOc().equals(model.getAnswer()))
                {
                    cc.setCardBackgroundColor(getResources().getColor(R.color.green));
                    correct();
                }
                else
                {
                    cc.setCardBackgroundColor(getResources().getColor(R.color.red));
                    wrong();
                    //disable button
                    disablebutton();

                }

            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if od==the answer , change the color of the card to green
                if(model.getOd().equals(model.getAnswer()))
                {
                    ce.setCardBackgroundColor(getResources().getColor(R.color.green));
                    correct();
                }
                else
                {
                    ce.setCardBackgroundColor(getResources().getColor(R.color.red));
                    wrong();
                    //disable button
                    disablebutton();

                }

            }
        });
    }
}

//to do change timer diferent than progress bar