package com.nubari.diary.classFiles;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Diary implements Parcelable {
    private final List<Entry> entries;
    private final int entryLimit;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Diary(int entryLimit) {
        this.entries = new ArrayList<>();
        this.entryLimit = entryLimit;
//        entries.add(new Entry("test Title", "test body"));
    }

    protected Diary(Parcel in) {
        this.entryLimit = in.readInt();
        this.entries = in.createTypedArrayList(Entry.CREATOR);
    }

    public int getEntryLimit() {
        return entryLimit;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addEntry(String title, String body) {
        if (entries.size() < entryLimit) {
            Entry entry = new Entry(title, body);
            entries.add(entry);
        }
    }

    public void removeEntry(int index) {
        if (index > -1 && index < entries.size()) {
            entries.remove(index);
        }
    }

    public void removeEntry(String title) {
        String titleInLowerCase = title.toLowerCase();
        Entry entryToRemove = null;
        for (Entry entry : entries) {
            String entryTitle = entry.getTitle().toLowerCase();
            if (entryTitle.equals(titleInLowerCase)) {
                entryToRemove = entry;
            }
        }
        if (entryToRemove != null) {
            entries.remove(entryToRemove);
        }

    }

    public void updateEntryTitle(int index, String newEntryTitle) {
        if (index > -1 && index < entries.size()) {
            Entry entryToUpdate = entries.get(index);
            entryToUpdate.setTitle(newEntryTitle);
            entries.remove(entries.get(index));
            entries.add(entryToUpdate);
        }
    }

    public void updateEntryBody(int index, String newEntryBody) {
        if (index > -1 && index < entries.size()) {
            Entry entryToUpdate = entries.get(index);
            entryToUpdate.setBody(newEntryBody);
            entries.remove(entries.get(index));
            entries.add(entryToUpdate);
        }
    }
    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(this.entryLimit);
        dest.writeTypedList(this.entries);
    }

    public static final Parcelable.Creator<Diary> CREATOR = new Creator<Diary>() {
        @Override
        public Diary createFromParcel(Parcel source) {
            return new Diary(source);
        }

        @Override
        public Diary[] newArray(int size) {
            return new Diary[size];
        }
    };


}
