package com.syncgym.api.note.usecases.getAllNotesByExerciseUseCase;

import com.syncgym.api.note.Note;
import com.syncgym.api.note.ports.NoteRepositoryService;

import java.util.Collection;

public class GetAllNotesByExerciseUseCaseImpl implements GetAllNotesByExerciseUseCase {

    private final NoteRepositoryService noteRepositoryService;

    public GetAllNotesByExerciseUseCaseImpl(NoteRepositoryService noteRepositoryService) {
        this.noteRepositoryService = noteRepositoryService;
    }

    @Override
    public Collection<Note> execute(String exerciseName) {
        return noteRepositoryService.getAllNotesByExercise(exerciseName);
    }
}
