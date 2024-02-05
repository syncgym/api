package com.syncgym.api.note.ports;

import com.syncgym.api.note.Note;

import java.util.Collection;
import java.util.Optional;

public interface NoteRepositoryService {

    Collection<Note> getAllNotesByExercise(String exerciseName);

    Optional<Note> getNoteById(Long id);

    Note createNote(Note note);

    Note updateNoteById(Note note);

    void deleteNoteById(Long id);
}
