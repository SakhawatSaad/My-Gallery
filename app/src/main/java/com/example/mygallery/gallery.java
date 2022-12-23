package com.example.mygallery;

import android.net.Uri;
import android.provider.MediaStore;

public class gallery {

    long id,date;
    double size;
    String name;
    Uri imageUri;

    public gallery(long id, long date, double size, String name, Uri imageUri) {
        this.id = id;
        this.date = date;
        this.size = size;
        this.name = name;
        this.imageUri = imageUri;
    }

    public long getId() {
        return id;
    }

    public long getDate() {
        return date;
    }

    public double getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Uri getImageUri() {
        return imageUri;
    }
}
