package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String folerToList = Environment.getDownloadCacheDirectory().getAbsolutePath();
        setAdapterList(folerToList);
        
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String text = Environment.getDownloadCacheDirectory().getAbsolutePath() + "/" + items.get(position);
        setAdapterList(text);
    }

    public void setAdapterList(String folerToList){
        ArrayList<String> _items;
        File folerFile = new File(folerToList);
        if (folerFile.isDirectory()){
            File[] files = folerFile.listFiles();
            for (File f: files){
                _items.add(f.getAbsolutePath());
            }

        } else {
            //open file
        }
        CustomAdapter adapter = new CustomAdapter(_items);
        setListAdapter(adapter);
    }

}