package com.syncgym.api.note.usecases.updateNoteByIdUseCase;

import com.syncgym.api.note.Note;
import com.syncgym.api.note.exceptions.NoteNotFoundException;
import com.syncgym.api.note.ports.NoteRepositoryService;

public class UpdateNoteByIdUseCaseImpl implements UpdateNoteByIdUseCase {

    private final NoteRepositoryService noteRepositoryService;

    public UpdateNoteByIdUseCaseImpl(NoteRepositoryService noteRepositoryService) {
        this.noteRepositoryService = noteRepositoryService;
    }

    @Override
    public Note execute(Note note) throws NoteNotFoundException {
        try {
            return noteRepositoryService.updateNoteById(note);
        } catch (Exception e) {
            throw new NoteNotFoundException();
        }
    }
}
