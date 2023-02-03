package com.example.reddittopviewer;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.sql.Timestamp;

public class Post {

    //public JSONObject Top;
    public String Author;
    public Timestamp Created;
    public URL Thumbnail;
    public URL Picture_full;
    public int Comments;

    public void ExtractData(JSONObject Obj) throws JSONException {

        Author  = (String) Obj.get("author");
        Created = (Timestamp) Obj.get("created");
        Thumbnail = (URL) Obj.get("thumbnail");
        Comments = (int) Obj.get("num_comments");
        Picture_full = (URL) Obj.get("url");
    }
}
