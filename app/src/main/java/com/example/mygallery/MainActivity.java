package com.example.mygallery;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.example.mygallery.databinding.ActivityMainBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<gallery> galleryList;
    gallery_adpter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        requestAllPermission();
    }

    private void requestAllPermission() {

        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {

                        getData();
                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {

                    }
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                }).check();
    }



    private void getData() {

        galleryList = new ArrayList<>();

        String[] projection = {

                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.SIZE,
                MediaStore.Images.Media.DATE_MODIFIED,
                MediaStore.Images.Media.DISPLAY_NAME
        };

        Uri contentUri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        Cursor cursor = getContentResolver().query(contentUri,projection,null,null);

        if (cursor != null && !cursor.equals("")) {

            cursor.moveToPosition(0);
            while (true){

                Long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID));
                double size = cursor.getDouble(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME));
                long date = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED));

                Uri imageUri = ContentUris.withAppendedId(contentUri,id);


                gallery gallery = new gallery(id,date,size,name,imageUri);
                galleryList.add(gallery);





                if (!cursor.isLast()){
                    cursor.moveToNext();
                }else {
                    break;
                }
            }

            adpter = new gallery_adpter(MainActivity.this,galleryList);
            binding.recycel.setAdapter(adpter);
        }

    }
}