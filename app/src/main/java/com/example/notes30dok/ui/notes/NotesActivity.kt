package com.example.notes30dok.ui.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.notes30dok.R
import com.example.notes30dok.data.Note
import com.example.notes30dok.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_notes.*
import java.lang.StringBuilder

@Suppress("DEPRECATION")
class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        initialiseUI()
    }

    private fun initialiseUI() {
        val factory = InjectorUtils.provideNotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(NotesViewModel::class.java)

        viewModel.getNotes().observe(this, Observer{ notes ->
            val stringBuilder = StringBuilder()
            notes.forEach{ note ->
                stringBuilder.append("$note\n\n")
            }
            textView_notes.text = stringBuilder.toString()
        })

        button_add_note.setOnClickListener{
            val note = Note(editText_note.text.toString(), editText_ref.text.toString())
            viewModel.addNote(note)
            editText_note.setText("")
            editText_ref.setText("")
        }
    }
}
