package com.upc.dogview.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.widget.ANImageView;
import com.upc.dogview.R;
import com.upc.dogview.Utilities.SharePreferenceManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    SharePreferenceManager spm;
    ANImageView anImageView;

    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        spm = new SharePreferenceManager(getActivity());
        if(spm.getUserPreference().getUrl().equalsIgnoreCase(""))
            return inflater.inflate(R.layout.fragment_favorite_unselected, container, false);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        anImageView = view.findViewById(R.id.favorite_AN_image);
        anImageView.setImageUrl(spm.getUserPreference().getUrl());
        anImageView.setDefaultImageResId(R.drawable.ic_launcher_background);
        anImageView.setErrorImageResId(R.drawable.ic_launcher_background);

        return view;
    }

}
