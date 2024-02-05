package com.syncgym.api.note.usecases.getAllNotesByUserUsernameAndExerciseUseCase;

import com.syncgym.api.note.Note;

import java.util.Collection;

public interface GetAllNotesByUserUsernameAndExerciseUseCase {

    Collection<Note> execute(String exerciseName, String userUsername);
}
