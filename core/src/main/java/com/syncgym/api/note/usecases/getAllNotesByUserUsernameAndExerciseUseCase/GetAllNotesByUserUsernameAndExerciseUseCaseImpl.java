package com.syncgym.api.note.usecases.getAllNotesByUserUsernameAndExerciseUseCase;

import com.syncgym.api.note.Note;
import com.syncgym.api.note.ports.NoteRepositoryService;

import java.util.Collection;

public class GetAllNotesByUserUsernameAndExerciseUseCaseImpl implements GetAllNotesByUserUsernameAndExerciseUseCase {

    private final NoteRepositoryService noteRepositoryService;

    public GetAllNotesByUserUsernameAndExerciseUseCaseImpl(NoteRepositoryService noteRepositoryService) {
        this.noteRepositoryService = noteRepositoryService;
    }

    @Override
    public Collection<Note> execute(String exerciseName, String userUsername) {
        return noteRepositoryService.getAllNotesByUserUsernameAndExercise(exerciseName, userUsername);
    }
}
