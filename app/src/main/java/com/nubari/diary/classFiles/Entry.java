package com.nubari.diary.classFiles;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Entry {
    private String title;
    private String body;
    private LocalDate dateCreated;

    public Entry() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Entry(String title, String body) {
        this.title = title;
        this.body = body;
        this.dateCreated = LocalDate.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

}
