package com.nubari.diary;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nubari.diary.classFiles.Diary;
import com.nubari.diary.classFiles.Entry;

import java.util.Collections;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    private Diary diary = new Diary(50);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        System.out.println("tool is " + toolbar);
        setSupportActionBar(toolbar);
        List<Entry> entries;
        Intent intent = getIntent();
        if (intent.hasExtra("DIARY")) {
            //System.out.println("Test made it here");
            diary = intent.getParcelableExtra("DIARY");
            //System.out.println("new entry is " + diary.getEntries().get(1).getTitle());
        }
        entries = diary.getEntries();
        Collections.reverse(entries);
        ArrayAdapter<Entry> entryArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_entry: {
                Intent intent = new Intent(this, CreateEntryActivity.class);
                intent.putExtra("DIARY", diary);
                startActivity(intent);
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}