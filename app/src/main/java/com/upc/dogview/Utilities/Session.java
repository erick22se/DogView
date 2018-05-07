package com.upc.dogview.Utilities;

public class Session {
    private String id;
    private String url;
    private String uploadAt;
    private String createAt;

    public Session() {
        id="";
        url="";
        uploadAt="";
        createAt="";
    }

    public Session(String id, String url, String uploadAt, String createAt) {
        this.id = id;
        this.url = url;
        this.uploadAt = uploadAt;
        this.createAt = createAt;
    }

    public String getId() {
        return id;
    }

    public Session setId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Session setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUploadAt() {
        return uploadAt;
    }

    public Session setUploadAt(String uploadAt) {
        this.uploadAt = uploadAt;
        return this;
    }

    public String getCreateAt() {
        return createAt;
    }

    public Session setCreateAt(String createAt) {
        this.createAt = createAt;
        return this;
    }
}
