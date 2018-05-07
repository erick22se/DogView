package com.upc.dogview.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.upc.dogview.Adapters.DogAdapter;
import com.upc.dogview.Models.DogEntry;
import com.upc.dogview.Network.DogApi;
import com.upc.dogview.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    List<DogEntry>dogEntries;
    DogAdapter dogAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        dogEntries = new ArrayList<>();
        recyclerView = view.findViewById(R.id.dogRecyclerView);
        dogAdapter = new DogAdapter();
        layoutManager = new GridLayoutManager(view.getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dogAdapter);
        updateList();

        return view;
    }

    private void updateList() {
        AndroidNetworking.get(DogApi.getDog())
                .addQueryParameter("limit","20")
                .setTag("DogRequest")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            dogEntries = DogEntry.Builder.from(response.getJSONArray("data")).buildAll();
                            dogAdapter.setDogEntries(dogEntries);
                            dogAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

}
