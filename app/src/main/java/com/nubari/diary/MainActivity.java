package com.nubari.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nubari.diary.classFiles.Diary;
import com.nubari.diary.classFiles.Entry;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final Diary diary = new Diary(50);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        System.out.println("tool is " + toolbar);
        setSupportActionBar(toolbar);
        List<Entry> entries = diary.getEntries();
        Collections.reverse(entries);
        ArrayAdapter<Entry> entryArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                entries
        );
        ListView latestEntriesView = (ListView) findViewById(R.id.list_options);
        latestEntriesView.setAdapter(entryArrayAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EntryActivity.class);
                intent.putExtra("ID", id);
                intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        };
        latestEntriesView.setOnItemClickListener(itemClickListener);
    }

}