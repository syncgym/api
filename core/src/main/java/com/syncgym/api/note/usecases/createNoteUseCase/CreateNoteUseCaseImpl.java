package com.syncgym.api.note.usecases.createNoteUseCase;

import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.commonUser.usecases.getByUsernameCommonUserUseCase.GetByUsernameCommonUserUseCase;
import com.syncgym.api.exercise.exceptions.ExerciseNotFoundException;
import com.syncgym.api.exercise.usecases.getExerciseByNameUseCase.GetExerciseByNameUseCase;
import com.syncgym.api.note.Note;
import com.syncgym.api.note.ports.NoteRepositoryService;

import java.util.Date;

public class CreateNoteUseCaseImpl implements CreateNoteUseCase {

    private final NoteRepositoryService noteRepositoryService;

    private final GetByUsernameCommonUserUseCase getByUsernameCommonUserUseCase;

    private final GetExerciseByNameUseCase getExerciseByNameUseCase;

    public CreateNoteUseCaseImpl(NoteRepositoryService noteRepositoryService, GetByUsernameCommonUserUseCase getByUsernameCommonUserUseCase, GetExerciseByNameUseCase getExerciseByNameUseCase) {
        this.noteRepositoryService = noteRepositoryService;
        this.getByUsernameCommonUserUseCase = getByUsernameCommonUserUseCase;
        this.getExerciseByNameUseCase = getExerciseByNameUseCase;
    }

    @Override
    public Note execute(String userUsername, String exerciseName, String noteContent) throws CommonUserNotFoundException, ExerciseNotFoundException {
        var user = getByUsernameCommonUserUseCase.execute(userUsername);
        var exercise = getExerciseByNameUseCase.execute(exerciseName);

        return noteRepositoryService.createNote(new Note(null, user, exercise, noteContent, new Date()));
    }
}
