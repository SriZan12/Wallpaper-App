package com.example.wally;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.example.wally.databinding.ActivitySetWallpaperBinding;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import Models.Photo;

public class SetWallpaperActivity extends AppCompatActivity {

    ActivitySetWallpaperBinding binding;
    Photo photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySetWallpaperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hideStatusBar();

        Intent intent = getIntent();
        photos = (Photo) intent.getSerializableExtra("photo");

        binding.setAsWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAsWallpaper();
                finishAffinity();
            }
        });

        binding.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadImage();
            }
        });


        Picasso.get().
                load(photos.getSrc().getPortrait()).
                into(binding.picture);
    }

    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }

    private void setAsWallpaper() {


        WallpaperManager m = WallpaperManager.getInstance(this);

        try {
            Bitmap bitmap = ((BitmapDrawable)binding.picture.getDrawable()).getBitmap();
            m.setBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadImage(){
        DownloadManager downloadManager;

        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

        Uri uri = Uri.parse(photos.getSrc().getOriginal());

        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false)
                .setTitle("Wallpaper " + photos.getPhotographer())
                .setMimeType("image/jpeg")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES,"Wallpaper " + photos.getPhotographer() + "jpg");

        downloadManager.enqueue(request);
        Toast.makeText(SetWallpaperActivity.this,"Download Completed",Toast.LENGTH_SHORT).show();

    }
}