package com.example.reddittopviewer;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.reddittopviewer.databinding.ActivityScrollingBinding;

import org.jetbrains.annotations.Contract;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.reddittopviewer.databinding.ActivityScrollingBinding binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        new Thread(new Runnable() {
            public void run(){
                //txt1.setText("Thread!!");
            }
            public void main(String[] args){
                URL Reddit_top;
                try {
                    Reddit_top = new URL("https://www.reddit.com/top.json");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                JSONObject json  = JSONFetch(Reddit_top);
                System.out.println(json);
            }
            @NonNull
            private String readAll(@NonNull Reader rd) throws IOException {
                StringBuilder sb = new StringBuilder();
                int cp;
                while ((cp = rd.read()) != -1) {
                    sb.append((char) cp);
                }
                return sb.toString();
            }

            @NonNull
            @Contract("_ -> new")
            public JSONObject JSONFetch(URL url)//Imports the JSON file and fetches the data from it
            {
                try (InputStream is = url.openStream()) {
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                    String jsonText = readAll(rd);
                    return new JSONObject(jsonText);
                } catch (IOException | JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
