package com.upc.dogview.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONException;
import org.json.JSONObject;

public class SharePreferenceManager {
    Context context;
    SharedPreferences sharedPreferences;

    public SharePreferenceManager(Context context) {
        this.context = context;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
    }

    public void savePreference(Session session){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id",session.getId());
            jsonObject.put("url",session.getUrl());
            jsonObject.put("uploadAt",session.getUploadAt());
            jsonObject.put("createdAt",session.getCreateAt());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sharedPreferences.edit().putString("userSession",jsonObject.toString()).commit();
    }
    public void deletePreference(){

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id","");
            jsonObject.put("url","");
            jsonObject.put("uploadAt","");
            jsonObject.put("createdAt","");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sharedPreferences.edit().putString("userSession",jsonObject.toString()).commit();
    }
    public Session getUserPreference(){

        Session session = new Session();
        try {
            JSONObject jsonObject = new JSONObject(sharedPreferences.getString("userSession",""));
            if(!jsonObject.isNull("id"))
                session.setId(jsonObject.getString("id"));
            if(!jsonObject.isNull("url"))
                session.setUrl(jsonObject.getString("url"));
            if(!jsonObject.isNull("uploadAt"))
                session.setCreateAt(jsonObject.getString("uploadAt"));
            if(!jsonObject.isNull("createdAt"))
                session.setUploadAt(jsonObject.getString("createdAt"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return session;
    }
}
