package com.example.labexam4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.labexam4.databinding.ActivityUpdateNoteBinding


class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db: NotesDatabaseHelper
    private var noteId:  Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)
        if(noteId==-1){
            finish()
            return
        }

        val note = db.getNoteByID(noteId)
        binding.UpdateTitleEditText.setText(note.title)
        binding.UpdateontentEditText.setText(note.content)

        binding.UpdateSaveButton.setOnClickListener {
            val newTitle = binding.UpdateTitleEditText.text.toString()
            val newContent = binding.UpdateontentEditText.text.toString()
            val updatedNote = Note(noteId, newTitle, newContent)
            db.updateNote(updatedNote)
            finish()
            Toast.makeText(this, "Changes saved", Toast.LENGTH_SHORT).show()
        }
    }
}