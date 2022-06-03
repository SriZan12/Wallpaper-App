package com.example.wally;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wally.databinding.ActivityAllWallpapersBinding;
import com.example.wally.databinding.ShowWallpaperBinding;

import java.util.ArrayList;
import java.util.List;

import Adapter.WallpaperAdapter;
import Adapter.onPhotoClickListener;
import Apis.ApiInstance;
import Apis.RetrofitInstance;
import Models.MainDetails;
import Models.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllWallpapers extends AppCompatActivity {

    ActivityAllWallpapersBinding wallpapersBinding;

    ApiInstance apiInstance;
    List<Photo> picList = new ArrayList<>();
    WallpaperAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wallpapersBinding = ActivityAllWallpapersBinding.inflate(getLayoutInflater());
        setContentView(wallpapersBinding.getRoot());

        showWallpapers();
        wallpapersBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = wallpapersBinding.searchBar.getText().toString();
                showSearchedWallpapers(query);
            }
        });
    }

    private void showWallpapers() {
        apiInstance = RetrofitInstance.getRetrofit().create(ApiInstance.class);

        apiInstance.getAllWallpaper(1,80).enqueue(new Callback<MainDetails>() {
            @Override
            public void onResponse(Call<MainDetails> call, Response<MainDetails> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(AllWallpapers.this, "Responded",Toast.LENGTH_SHORT).show();
                    wallpapersBinding.allRecycler.setLayoutManager(new GridLayoutManager(AllWallpapers.this,2));
                    picList.clear();
                    assert response.body() != null;
                    picList.addAll(response.body().getPhotos());
                    adapter = new WallpaperAdapter(AllWallpapers.this,picList,clickListener);
                    wallpapersBinding.allRecycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MainDetails> call, Throwable t) {
                Toast.makeText(AllWallpapers.this, "Not Responded",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private final onPhotoClickListener clickListener = new onPhotoClickListener() {
        @Override
        public void clickedPhoto(Photo photo) {
            Intent intent = new Intent(AllWallpapers.this,SetWallpaperActivity.class);
            intent.putExtra("photo",photo);
            startActivity(intent);

        }
    };

    private void showSearchedWallpapers(String query){
        apiInstance = RetrofitInstance.getRetrofit().create(ApiInstance.class);

        apiInstance.getAllWallpaper(query,1,80).enqueue(new Callback<MainDetails>() {
            @Override
            public void onResponse(Call<MainDetails> call, Response<MainDetails> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(AllWallpapers.this, "Responded",Toast.LENGTH_SHORT).show();
                    wallpapersBinding.allRecycler.setLayoutManager(new GridLayoutManager(AllWallpapers.this,2));
                    picList.clear();
                    assert response.body() != null;
                    picList.addAll(response.body().getPhotos());
                    adapter = new WallpaperAdapter(AllWallpapers.this,picList,clickListener);
                    wallpapersBinding.allRecycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MainDetails> call, Throwable t) {
                Toast.makeText(AllWallpapers.this, "Not Responded",Toast.LENGTH_SHORT).show();
            }
        });
    }
}