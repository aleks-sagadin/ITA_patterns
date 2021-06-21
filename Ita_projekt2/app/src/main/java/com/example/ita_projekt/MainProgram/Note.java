package com.example.ita_projekt.MainProgram;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int priority;
    private String avtor;



    public String getAvtor() {
        return avtor;
    }
    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }
    //private String avtor;
    //private Drzava drzava;


    public Note(String title, String description, int priority, String avtor) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.avtor = avtor;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getPriority() {
        return priority;
    }
}