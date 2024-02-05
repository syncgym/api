package com.syncgym.api.note.usecases.getAllNotesByExerciseUseCase;

import com.syncgym.api.note.Note;

import java.util.Collection;

public interface GetAllNotesByExerciseUseCase {

    Collection<Note> execute(String exerciseName);
}
