package com.example.reddittopviewer;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import org.json.*;


public class Reddit_top extends AppCompatActivity{

    public Post[] Posts;

    public JSONObject JSONFetch(String url)//Imports the JSON file and fetches the data from it
    {
        {
            try {JSONObject obj = new JSONObject(url);
                return obj;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void JSONChildren(String name) throws JSONException {
        @NonNull JSONObject obj = new JSONObject();
        JSONArray arr = obj.getJSONArray(name);
        for (int i = 0; i<= arr.length(); i++) {
            Posts[i].ExtractData(arr.getJSONObject(i));
        }
    }
    public void ShowPosts(ScrollingActivity scrollingActivity)
    {
        LinearLayout ll  = (LinearLayout) findViewById(R.id.LL);
        for (Post i:Posts
        ) {
            TextView Text  = new TextView(scrollingActivity);
        }
    }
}



