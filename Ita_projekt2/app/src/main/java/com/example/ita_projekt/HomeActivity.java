package com.example.ita_projekt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ita_projekt.MainProgram.AddEditNoteActivity;
import com.example.ita_projekt.MainProgram.Note;
import com.example.ita_projekt.MainProgram.NoteAdapter;
import com.example.ita_projekt.MainProgram.NoteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static final int ADD_RECEPT_REQUST = 1;
    public static final  int EDIT_NOTE_REQUEST = 2;
    public NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_dodaj_note);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddEditNoteActivity.class);
                startActivityForResult(intent,ADD_RECEPT_REQUST);

            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(NoteViewModel.class);

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() { //avtomatsko  posodobi in izbrise fragment
            @Override
            public void onChanged(List<Note> notes) { //klican bo po vsaki spremembi
                //Toast.makeText(HomeActivity.this,"HELLO",Toast.LENGTH_SHORT).show();
                adapter.setNotes(notes); // klicejo se avtomatsko nazaj
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteViewModel.delete(adapter.getNoteAt(viewHolder.getBindingAdapterPosition())); // ?? tu je drugace
                //TOAST
                Toast.makeText(HomeActivity.this,"Ni zbrisan", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        //tu bomo po hendlali klikanje
        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Note note) {
                Intent intent = new Intent(HomeActivity.this, AddEditNoteActivity.class);
                intent.putExtra(AddEditNoteActivity.EXTRA_ID, note.getId());
                intent.putExtra(AddEditNoteActivity.EXTRA_TITLE, note.getTitle());
                intent.putExtra(AddEditNoteActivity.EXTRA_DESCRIPTION, note.getDescription());
                intent.putExtra(AddEditNoteActivity.EXTRA_PRIORITY, note.getPriority());
                startActivityForResult(intent, EDIT_NOTE_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode  == ADD_RECEPT_REQUST &&  resultCode == RESULT_OK){
            String title = data.getStringExtra(AddEditNoteActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditNoteActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITY, 1);
            String avtor = data.getStringExtra(AddEditNoteActivity.EXTRA_AVTOR);

            Note note = new Note(title,description,priority,avtor);
            noteViewModel.insert(note);

            Toast.makeText(this,"Shranjeno", Toast.LENGTH_SHORT).show();

        }else if(requestCode  == EDIT_NOTE_REQUEST &&  resultCode == RESULT_OK){
            int id = data.getIntExtra(AddEditNoteActivity.EXTRA_ID, -1);

            if(id == -1){
                Toast.makeText(this,"NE more bit posodobljeno", Toast.LENGTH_SHORT).show();
                return;
            }
            String title = data.getStringExtra(AddEditNoteActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditNoteActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITY, 1);
            String avtor = data.getStringExtra(AddEditNoteActivity.EXTRA_AVTOR);
            Note note = new Note(title, description,priority,avtor);
            note.setId(id); // tu se zgodi operacija
            noteViewModel.update(note);
            Toast.makeText(this,"Posodobljeno", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Ni Shranjeno", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_all:
                noteViewModel.deleteAllNotes();
                Toast.makeText(this,"Vsi so zbrisani", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}