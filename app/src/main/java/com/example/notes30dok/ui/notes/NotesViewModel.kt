package com.example.notes30dok.ui.notes

import androidx.lifecycle.ViewModel
import com.example.notes30dok.data.Note
import com.example.notes30dok.data.NoteRepository

class NotesViewModel(private val noteRepository: NoteRepository)
    : ViewModel() {

    fun getNotes() = noteRepository.getNotes()

    fun addNote(note: Note) = noteRepository.addNote(note)
}