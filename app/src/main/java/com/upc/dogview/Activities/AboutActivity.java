package com.upc.dogview.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;
import com.upc.dogview.Models.DogEntry;
import com.upc.dogview.R;
import com.upc.dogview.Utilities.Session;
import com.upc.dogview.Utilities.SharePreferenceManager;

import java.util.Date;

public class AboutActivity extends AppCompatActivity {

    SharePreferenceManager spm;
    DogEntry dogEntry;
    ANImageView anImageView;
    TextView dateTextView;
    ImageButton favoriteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        spm = new SharePreferenceManager(this);
        ini();
        if(!bundle.isEmpty()){
            dogEntry = DogEntry.Builder.from(bundle).build();
            update(dogEntry);
        }

    }

    public void ini(){
        dateTextView = findViewById(R.id.dateTextView);
        anImageView = findViewById(R.id.aboutAnImageView);
        favoriteButton = findViewById(R.id.favoriteImageButton);
    }

    public void update(final DogEntry dogEntry){
        dateTextView.setText(dogEntry.getTime());
        anImageView.setImageUrl(dogEntry.getUrl());
        anImageView.setErrorImageResId(R.drawable.ic_launcher_background);
        anImageView.setDefaultImageResId(R.drawable.ic_launcher_background);
        String id = spm.getUserPreference().getId();
        if(id.equalsIgnoreCase(dogEntry.getId())){
            favoriteButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_24dp));
            favoriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    spm.deletePreference();
                    finish();
                }
            });
        }

        else{
            favoriteButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_border_24dp));
            favoriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Date date = new Date();
                    Session session = new Session(dogEntry.getId(),dogEntry.getUrl(),dogEntry.getTime(),date.toString());
                    spm.savePreference(session);
                    finish();
                }
            });
        }

    }

}
