package com.syncgym.api.note.usecases.deleteNoteByIdUseCase;

import com.syncgym.api.note.exceptions.NoteNotFoundException;
import com.syncgym.api.note.ports.NoteRepositoryService;

public class DeleteNoteByIdUseCaseImpl implements DeleteNoteByIdUseCase {

    private final NoteRepositoryService noteRepositoryService;

    public DeleteNoteByIdUseCaseImpl(NoteRepositoryService noteRepositoryService) {
        this.noteRepositoryService = noteRepositoryService;
    }

    @Override
    public void execute(Long noteId) throws NoteNotFoundException {
        try {
            noteRepositoryService.deleteNoteById(noteId);
        } catch (Exception e) {
            throw new NoteNotFoundException();
        }
    }
}
