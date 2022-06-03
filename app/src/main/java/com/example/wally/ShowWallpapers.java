package com.example.wally;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wally.databinding.ShowWallpaperBinding;

import java.util.ArrayList;
import java.util.List;

import Adapter.WallpaperAdapter;
import Adapter.onPhotoClickListener;
import Apis.ApiInstance;
import Models.MainDetails;
import Models.Photo;
import Apis.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowWallpapers extends AppCompatActivity {

    ShowWallpaperBinding binding;
    ApiInstance apiInstance;
    List<Photo> picList = new ArrayList<>();
    WallpaperAdapter adapter;

    String query = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ShowWallpaperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        String query = intent.getStringExtra("category");
        showWallpapers(query);

    }

    private void showWallpapers(String query) {
        apiInstance = RetrofitInstance.getRetrofit().create(ApiInstance.class);

        apiInstance.getAllWallpaper(query,1,80).enqueue(new Callback<MainDetails>() {
            @Override
            public void onResponse(Call<MainDetails> call, Response<MainDetails> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(ShowWallpapers.this, "Responded",Toast.LENGTH_SHORT).show();
                    binding.recycler.setLayoutManager(new GridLayoutManager(ShowWallpapers.this,2));
                    picList.clear();
                    assert response.body() != null;
                    picList.addAll(response.body().getPhotos());
                    adapter = new WallpaperAdapter(ShowWallpapers.this,picList,clickListener);
                    binding.recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MainDetails> call, Throwable t) {
                Toast.makeText(ShowWallpapers.this, "Not Responded",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private final onPhotoClickListener clickListener = new onPhotoClickListener() {
    @Override
    public void clickedPhoto(Photo photo) {
       Intent intent = new Intent(ShowWallpapers.this,SetWallpaperActivity.class);
       intent.putExtra("photo",photo);
       startActivity(intent);

    }
     };
}