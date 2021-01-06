package com.nubari.diary.classFiles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class EntryTest {
    Entry entry;

    @BeforeEach
    void setUp() {
        entry = new Entry();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatEntryTitleAndBodyAreInitializedWhenCreated() {
        Entry entry = new Entry("Test Title", "Test body");
        assertEquals("Test Title", entry.getTitle());
        assertEquals("Test body", entry.getBody());
    }

    @Test
    void testThatEntryDateIsSetWhenEntryObjectIsCreated() {
        Entry entry = new Entry("Test Title", "Test body");
        assertNotNull(entry.getDateCreated());
    }

    @Test
    void testThatEntryTitleCanBeUpdated() {
        entry.setTitle("Test new title");
        assertEquals("Test new title", entry.getTitle());
        entry.setTitle("Test title 2");
        assertEquals("Test title 2", entry.getTitle());
    }

    @Test
    void testThatEntryBodyCanBeUpdated() {
        entry.setBody("Test Body");
        assertEquals("Test Body", entry.getBody());
        entry.setBody("Test Body 2");
        assertEquals("Test Body 2", entry.getBody());
    }

}