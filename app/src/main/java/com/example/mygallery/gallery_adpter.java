package com.example.mygallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.location.GnssStatusCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class gallery_adpter extends RecyclerView.Adapter<gallery_view_holder> {
    Context context;
    List<gallery> galleryList;

    public gallery_adpter(Context context, List<gallery> galleryList) {
        this.context = context;
        this.galleryList = galleryList;
    }

    @NonNull
    @Override
    public gallery_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery,parent,false);
        return new gallery_view_holder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull gallery_view_holder holder, int position) {
        gallery gallery = galleryList.get(position);
        holder.img.setImageURI(gallery.getImageUri());

        holder.itemView.setOnClickListener( v -> {

            String uristring = String.valueOf(gallery.imageUri);

            Intent intent = new Intent(context,FullImageActivity.class);
            intent.putExtra("img",uristring);

            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }
}
