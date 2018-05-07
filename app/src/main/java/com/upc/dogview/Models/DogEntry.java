package com.upc.dogview.Models;

import android.os.Bundle;

import com.orm.SugarRecord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DogEntry {
    private String id;
    private String url;
    private String time;
    private String format;
    private String verified;
    private String checked;

    public DogEntry() {
    }

    public DogEntry(String id, String url, String time, String format, String verified, String checked) {
        this.id = id;
        this.url = url;
        this.time = time;
        this.format = format;
        this.verified = verified;
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public DogEntry setId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DogEntry setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTime() {
        return time;
    }

    public DogEntry setTime(String time) {
        this.time = time;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public DogEntry setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getVerified() {
        return verified;
    }

    public DogEntry setVerified(String verified) {
        this.verified = verified;
        return this;
    }

    public String getChecked() {
        return checked;
    }

    public DogEntry setChecked(String checked) {
        this.checked = checked;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();

        bundle.putString("id",getId());
        bundle.putString("url",getUrl());
        bundle.putString("time",getTime());
        bundle.putString("format",getFormat());
        bundle.putString("verified",getVerified());
        bundle.putString("checked",getChecked());

        return bundle;
    }

    public static class Builder{
        private DogEntry dogEntry;
        private List<DogEntry> dogEntries;

        public Builder() {
            this.dogEntry = new DogEntry();
            this.dogEntries = new ArrayList<>();
        }

        public Builder(DogEntry dogEntry) {
            this.dogEntry = dogEntry;
        }

        public Builder(List<DogEntry> dogEntries) {
            this.dogEntries = dogEntries;
        }

        public DogEntry build() {
            return dogEntry;
        }
        public List<DogEntry> buildAll(){
            return dogEntries;
        }

        public static Builder from(JSONObject jsonObject){
            try {
                return new Builder(new DogEntry()
                        .setId(jsonObject.getString("id"))
                        .setUrl(jsonObject.getString("url"))
                        .setTime(jsonObject.getString("time"))
                        .setFormat(jsonObject.getString("format"))
                        .setVerified(jsonObject.getString("verified"))
                        .setChecked(jsonObject.getString("checked"))
                );
            } catch (JSONException e) {
                e.printStackTrace();
                return new Builder();
            }
        }

        public static Builder from(JSONArray jsonArray){
            int length = jsonArray.length();
            List<DogEntry> dogEntries = new ArrayList<>();
            for (int i = 0; i < length; i++){
                try {
                    dogEntries.add(Builder.from(jsonArray.getJSONObject(i)).build());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return new Builder(dogEntries);
        }
        public static Builder from(Bundle bundle){
            return new Builder(new DogEntry()
                    .setId(bundle.getString("id"))
                    .setUrl(bundle.getString("url"))
                    .setTime(bundle.getString("time"))
                    .setFormat(bundle.getString("format"))
                    .setVerified(bundle.getString("verified"))
                    .setChecked(bundle.getString("checked")));
        }
    }
}
