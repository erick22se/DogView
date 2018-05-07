package com.upc.dogview.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidnetworking.widget.ANImageView;
import com.upc.dogview.Activities.AboutActivity;
import com.upc.dogview.Models.DogEntry;
import com.upc.dogview.R;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {

    List<DogEntry> dogEntries;

    public DogAdapter(List<DogEntry> dogEntries) {
        this.dogEntries = dogEntries;
}

    public DogAdapter() {
        dogEntries = new ArrayList<>();
    }

    @NonNull
    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {
        holder.ini(dogEntries.get(position));
    }

    @Override
    public int getItemCount() {
        return dogEntries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ANImageView dogAnImageView;
        Button moreInfoButton;
        DogEntry dogEntry;

        public ViewHolder(View itemView) {
            super(itemView);
            dogAnImageView = itemView.findViewById(R.id.dog_AN_image);
            moreInfoButton = itemView.findViewById(R.id.more_info_button);

            moreInfoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, AboutActivity.class);
                    intent.putExtra("bundle",dogEntry.toBundle());
                    context.startActivity(intent);
                }
            });

        }
        public void ini(DogEntry dogEntry){
            dogAnImageView.setImageUrl(dogEntry.getUrl());
            dogAnImageView.setDefaultImageResId(R.drawable.ic_launcher_background);
            dogAnImageView.setErrorImageResId(R.drawable.ic_launcher_background);
            this.dogEntry = dogEntry;
        }
    }

    public List<DogEntry> getDogEntries() {
        return dogEntries;
    }

    public DogAdapter setDogEntries(List<DogEntry> dogEntries) {
        this.dogEntries = dogEntries;
        return this;
    }
}
