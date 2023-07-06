package com.example.ud_quiz_app;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Spacing extends RecyclerView.ItemDecoration {
    private final int verticalsp;

    public Spacing(int verticalsp) {
        this.verticalsp = verticalsp;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
       outRect.bottom = verticalsp;
    }
}
