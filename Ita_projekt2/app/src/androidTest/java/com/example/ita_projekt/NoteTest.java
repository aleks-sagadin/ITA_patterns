package com.example.ita_projekt;

import com.example.ita_projekt.MainProgram.Note;

import org.junit.Test;
import static org.junit.Assert.*;

public class NoteTest {

    Note note;

    @Test
    public void constructorTest(){
        note = new Note("Naslov", "opis",1,"Aleks");
        assertEquals("Naslov", note.getTitle());

    }
    @Test
    public  void constructorTestFalse(){

        note = new Note("Naslov", "opis",1,"Aleks");
        assertNotEquals("Naslov", note.getDescription());
    }

}
