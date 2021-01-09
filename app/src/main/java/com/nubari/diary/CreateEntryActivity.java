package com.nubari.diary;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.nubari.diary.classFiles.Diary;


public class CreateEntryActivity extends AppCompatActivity {
    private Diary diary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_createEntry);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        diary = intent.getParcelableExtra("DIARY");
        //System.out.println("test diary " + diary.getEntries().get(0).getTitle());

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClickCreateEntry(View view) {
        EditText titleView = (EditText) findViewById(R.id.create_entry_title);
        String title = titleView.getText().toString();
        EditText entryBodyView = (EditText) findViewById(R.id.create_entry_body);
        String body = entryBodyView.getText().toString();
        if (diary != null) {
            diary.addEntry(title, body);
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("DIARY", diary);
        startActivity(intent);
    }

}