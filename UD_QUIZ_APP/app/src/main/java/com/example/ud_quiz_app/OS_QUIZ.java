package com.example.ud_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class OS_QUIZ extends AppCompatActivity {
    public static  ArrayList<model> listofq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_quiz);
        getSupportActionBar().hide();
        listofq=new ArrayList<>();




        //TODO
        //1
        listofq.add(new model("In an OS, the address generated by CPU is known as ________"
                ,"Logical Address","MAC Address",
                "Physical Address",
                "Logical Address","Absolute Address"));

        //2
        listofq.add(new model("What is a long-term scheduler?"
                ,
                "It selects which process has to be brought into the ready queue","It selects which process has to be brought into the ready queue",
                        "None of the above",

                        "It selects which process to remove from memory by swapping","It selects which process has to be executed next and allocates CPU"));

        //3
        listofq.add(new model("What is the ready state of a process?"
                ,"When process is scheduled to run after some execution","When process is scheduled to run after some execution",
                        "None of the above",
                "When process is using the CPU","When process is unable to run until some task has been completed"));

        //4
        listofq.add(new model("In an OS, the physical memory is divided into fixed size blocks known as"
                ,
                "Frames",
                "Frame Table",
                "Frames",
                        "Page Table",
                "Pages"));


        //5

        listofq.add(new model("the main difference between the short term scheduler and the long term scheduler is"
                ,"The frequency of their execution","The type of processes they schedule",
                "The length of their queues",
                "None of the above",
                "The frequency of their execution"));

        //6


        listofq.add(new model("In an OS, the mapping of the virtual address to physical address is done by"
                ,"Memory Management Unit","PCI",
                "Virtual Memory Manager",
                "Swapping","Memory Management Unit"));
        //7

        listofq.add(new model("In an OS, what is used as an index into the page table?"
                ,"Page number",
                        "Frame offset",
                "Frame bit",
                "Page offset","Page number"));

        //8

        listofq.add(new model("In indirect communication between processes A and B"
                ,
                "There is a mailbox to help communication between A and B","There is another machine between the two processes to help communication",

                        "There is another process C to handle and pass on the messages between A and B",
                "There is a shared memory to help communication between A and B","There is a mailbox to help communication between A and B"));

        //9

        listofq.add(new model("logical address space=2^x  page size= 2^Y addressing units,how many high order bits of a logical address designate the page number?"
                ,"X-Y",
                "X-Y",
                "Y",
                "Y-X","X"));

        //10

        listofq.add(new model("What is a short-term scheduler?"
                ,"It selects which process has to be executed next and allocates CPU",
                "It selects which process has to be brought into the ready queue",
                "It selects which process has to be executed next and allocates CPU",
                "None of the above",
                "It selects which process to remove from memory by swapping"));

        //11

        listofq.add(new model("In an OS, with contiguous memory allocation"
                ,"Each process is contained in a single contiguous section of memory","The memory space is contiguous",
                "Each process is contained in a single contiguous section of memory",

                        "All processes are contained in a single contiguous section of memory",
                "Each process is contained in different section of memory"));

        //12

        listofq.add(new model("Which system call creates the new process in Unix OS?"
                ,"Fork","New",
                "Create",
                "None of the above","Fork"));

        //13

        listofq.add(new model("In an OS, with fixed size partition, the degree of multiprogramming is depending on what?"
                ,"Number of partitions",
                "CPU utilization",
                "Memory size",
                "Number of partitions","None of the aboves"));


        //14

        listofq.add(new model("Which of the following do not belong to queues for processes?"
                ,"PCB queue","PCB queue",
                        "Device Queue",
                "Job Queue",
                "Ready Queue"));

        //15

        listofq.add(new model("In an OS, which is a memory management technique, where system stores and retrieves data from secondary memory?"
                ,"Paging","Fragmentation",
                "Mapping",
                "Paging",
                "Virtual Memory"));






    }
    public void clicked(View view)
    {
        Intent i = new Intent(this,os_continued.class);
        startActivity(i);
    }
    public void clicked2(View view)
    {
        Intent i = new Intent(this,it_college.class);
        startActivity(i);
    }
}