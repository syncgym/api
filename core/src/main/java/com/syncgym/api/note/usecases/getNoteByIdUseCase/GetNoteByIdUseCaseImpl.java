package com.syncgym.api.note.usecases.getNoteByIdUseCase;

import com.syncgym.api.note.Note;
import com.syncgym.api.note.exceptions.NoteNotFoundException;
import com.syncgym.api.note.ports.NoteRepositoryService;

public class GetNoteByIdUseCaseImpl implements GetNoteByIdUseCase {

    private final NoteRepositoryService noteRepositoryService;

    public GetNoteByIdUseCaseImpl(NoteRepositoryService noteRepositoryService) {
        this.noteRepositoryService = noteRepositoryService;
    }

    @Override
    public Note execute(Long id) throws NoteNotFoundException {
        return noteRepositoryService.getNoteById(id)
                .orElseThrow(NoteNotFoundException::new);
    }
}
