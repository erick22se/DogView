package com.upc.dogview;

import com.androidnetworking.AndroidNetworking;
import com.orm.SugarApp;

public class DogViewApp extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
