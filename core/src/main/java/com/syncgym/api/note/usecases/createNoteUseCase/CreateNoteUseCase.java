package com.syncgym.api.note.usecases.createNoteUseCase;

import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.exercise.exceptions.ExerciseNotFoundException;
import com.syncgym.api.note.Note;

public interface CreateNoteUseCase {

    Note execute(String userUsername, String exerciseName, String noteContent) throws CommonUserNotFoundException, ExerciseNotFoundException;
}
