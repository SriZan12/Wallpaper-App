package Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wally.databinding.WallpaperDesignBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

import Models.Photo;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.wallpaperHolder> {

    Context context;
    List<Photo> photoList;
    onPhotoClickListener clickListener;

    public WallpaperAdapter(Context context, List<Photo> photoList, onPhotoClickListener clickListener) {
        this.context = context;
        this.photoList = photoList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public wallpaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        WallpaperDesignBinding binding = WallpaperDesignBinding.inflate(inflater, parent, false);
        return new wallpaperHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull wallpaperHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get()
                .load(photoList.get(position).getSrc().getPortrait())
                .into(holder.designBinding.imageview);

        Photo photo = photoList.get(position);

        holder.designBinding.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.clickedPhoto(photo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public static class wallpaperHolder extends RecyclerView.ViewHolder {

        WallpaperDesignBinding designBinding;

        public wallpaperHolder(@NonNull WallpaperDesignBinding binding) {
            super(binding.getRoot());

            this.designBinding = binding;
        }
    }
}
