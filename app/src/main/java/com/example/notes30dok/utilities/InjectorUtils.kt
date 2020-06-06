package com.example.notes30dok.utilities

import com.example.notes30dok.data.FakeDatabase
import com.example.notes30dok.data.NoteRepository
import com.example.notes30dok.ui.notes.NotesViewModelFactory

object InjectorUtils {

    fun provideNotesViewModelFactory(): NotesViewModelFactory {
        val noteRepository = NoteRepository.getInstance(FakeDatabase.getInstance().noteDao)
        return NotesViewModelFactory(noteRepository)
    }
}