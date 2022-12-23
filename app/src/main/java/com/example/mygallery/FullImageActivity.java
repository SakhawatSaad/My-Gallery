package com.example.mygallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mygallery.databinding.ActivityFullImageBinding;
import com.example.mygallery.databinding.ActivityMainBinding;

public class FullImageActivity extends AppCompatActivity {

    ActivityFullImageBinding binding;

    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityFullImageBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        intent= getIntent();

        Uri imguri = Uri.parse(intent.getStringExtra("img"));

        binding.fullImage.setImageURI(imguri);



    }
}