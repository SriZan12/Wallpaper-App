package com.example.wally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wally.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Nature");
                startActivity(intent);
            }
        });

        binding.Bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","bus");
                startActivity(intent);
            }
        });

        binding.Car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","car");
                startActivity(intent);
            }
        });

        binding.Train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Train");
                startActivity(intent);
            }
        });

        binding.ocean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Ocean");
                startActivity(intent);
            }
        });

        binding.tigers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Tigers");
                startActivity(intent);
            }
        });

        binding.pears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Pears");
                startActivity(intent);
            }
        });

        binding.people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","People");
                startActivity(intent);
            }
        });

        binding.black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Black");
                startActivity(intent);
            }
        });

        binding.rain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Rain");
                startActivity(intent);
            }
        });

        binding.players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Players");
                startActivity(intent);
            }
        });

        binding.mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Mountain");
                startActivity(intent);
            }
        });

        binding.house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","House");
                startActivity(intent);
            }
        });

        binding.road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWallpapers.class);
                intent.putExtra("category","Road");
                startActivity(intent);
            }
        });

        binding.allWally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AllWallpapers.class));
            }
        });
    }
}