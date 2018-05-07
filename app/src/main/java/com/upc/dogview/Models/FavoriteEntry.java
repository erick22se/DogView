package com.upc.dogview.Models;

import com.orm.SugarRecord;

import java.util.List;

public class FavoriteEntry extends SugarRecord {
    private String id;
    private String url;

    public FavoriteEntry() {
    }

    public FavoriteEntry(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getIdFavorite() {
        return id;
    }

    public FavoriteEntry setIdFavorite(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public FavoriteEntry setUrl(String url) {
        this.url = url;
        return this;
    }

    public static FavoriteEntry FindById(String id) {
        List<FavoriteEntry> favoriteEntries = find(
                FavoriteEntry.class,
                "id = ?",
                id
        );
        return favoriteEntries.isEmpty() ? null : favoriteEntries.get(0);
    }
}
