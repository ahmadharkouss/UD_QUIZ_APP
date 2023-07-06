package com.example.ud_quiz_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[];
    int images[];
    Context context;
    private onNotelistener onNotelistener2;
    public MyAdapter(Context ct , String s1[] , int img[] ,onNotelistener onNotelistener2)
    {
           context=ct;
           data1=s1;
           images=img;
           this.onNotelistener2=onNotelistener2;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent ,false);
        return new MyViewHolder(view,onNotelistener2);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mytext1.setText(data1[position]);
        holder.Myimage.setImageResource(images[position]);



    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mytext1;
        ImageView Myimage;
        onNotelistener onNotelistener1;

        public MyViewHolder(@NonNull View itemView , onNotelistener onNotelistener1) {
            super(itemView);
            mytext1 = itemView.findViewById(R.id.course_name);
            Myimage = itemView.findViewById(R.id.myimage_view);
            this.onNotelistener1=onNotelistener1;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onNotelistener1.onnoteclick(getAdapterPosition());

        }
    }
    public interface onNotelistener
    {
        void onnoteclick(int position);
    }
}
