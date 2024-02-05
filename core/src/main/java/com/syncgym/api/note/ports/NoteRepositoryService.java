package com.syncgym.api.note.ports;

import com.syncgym.api.note.Note;

import java.util.Collection;

public interface NoteRepositoryService {

    Collection<Note> getAllNotesByExercise(String exerciseName);

    Note createNote(Note note);

    Note updateNoteById(Note note);

    void deleteNoteById(Long id);
}
