package com.example.labexam4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.labexam4.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddNotesBinding
    private lateinit var db: NotesDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0,title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Task saved", Toast.LENGTH_SHORT).show()
        }
    }
}