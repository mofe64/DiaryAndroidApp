package com.nubari.diary.classFiles;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Entry implements Parcelable {
    private String title;
    private String body;
    private String dateCreated;

    public Entry() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Entry(String title, String body) {
        this.title = title;
        this.body = body;
        this.dateCreated = LocalDate.now().toString();
    }

    protected Entry(Parcel in) {
        title = in.readString();
        body = in.readString();
        dateCreated = in.readString();
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

    public String getDateCreated() {
        return dateCreated;
    }


    public static final Creator<Entry> CREATOR = new Creator<Entry>() {
        @Override
        public Entry createFromParcel(Parcel in) {
            return new Entry(in);
        }

        @Override
        public Entry[] newArray(int size) {
            return new Entry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeString(this.dateCreated);
    }

    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}
