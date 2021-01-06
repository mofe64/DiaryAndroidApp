package com.nubari.diary.classFiles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
    Diary diary;
    @BeforeEach
    void setUp() {
        diary = new Diary(10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testDiaryShouldBeInitializedWithAnEmptyListOfEntries(){
        assertNotNull(diary.getEntries());
        assertEquals(0, diary.getEntries().size());
    }
    @Test
    void testDiaryShouldBeInitializedWithAnEntryLimit(){
        Diary diary = new Diary(10);
        assertEquals(10, diary.getEntryLimit());
    }
    @Test
    void testDiaryShouldBeAbleToAddEntries(){
        diary.addEntry("Test Title", "Test body");
        assertEquals(1, diary.getEntries().size());
    }

    @Test
    void  testDiaryShouldBeAbleToRemoveEntryViaIndex(){
        diary.addEntry("Test Title", "Test body");
        diary.addEntry("Test Title2", "Test body2");
        assertEquals(2, diary.getEntries().size());
        diary.removeEntry(0);
        assertEquals("Test Title2", diary.getEntries().get(0).getTitle());
    }
    @Test
    void testDiaryShouldBeAbleToRemoveEntryViaTitle(){
        diary.addEntry("Test Title", "Test body");
        diary.addEntry("Test Title2", "Test body2");
        assertEquals(2, diary.getEntries().size());
        diary.removeEntry("Test Title2");
        assertEquals(1, diary.getEntries().size());
        assertEquals("Test Title", diary.getEntries().get(0).getTitle());
    }

    @Test
    void testDiaryShouldBeAbleToUpdateEntryTitle(){
        diary.addEntry("Test Title", "Test body");
        assertEquals(1, diary.getEntries().size());
        diary.updateEntryTitle(0, "new Title");
        assertEquals("new Title", diary.getEntries().get(0).getTitle());
    }
    @Test
    void testDiaryShouldBeAbleToUpdateEntryBody(){
        diary.addEntry("Test Title", "Test body");
        assertEquals(1, diary.getEntries().size());
        diary.updateEntryBody(0, "new Body");
        assertEquals("new Body", diary.getEntries().get(0).getBody());
    }
}