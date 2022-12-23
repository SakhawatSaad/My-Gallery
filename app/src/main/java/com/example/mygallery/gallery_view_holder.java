package com.example.mygallery;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class gallery_view_holder extends RecyclerView.ViewHolder {

    public AppCompatImageView img;
    public gallery_view_holder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
    }
}
