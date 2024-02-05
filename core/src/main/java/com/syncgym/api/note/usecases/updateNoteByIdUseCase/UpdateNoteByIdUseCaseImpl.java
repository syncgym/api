package com.syncgym.api.note.usecases.updateNoteByIdUseCase;

import com.syncgym.api.note.Note;
import com.syncgym.api.note.exceptions.NoteNotFoundException;
import com.syncgym.api.note.ports.NoteRepositoryService;
import com.syncgym.api.note.usecases.getNoteByIdUseCase.GetNoteByIdUseCase;

import java.util.Date;

public class UpdateNoteByIdUseCaseImpl implements UpdateNoteByIdUseCase {

    private final NoteRepositoryService noteRepositoryService;

    private final GetNoteByIdUseCase getNoteByIdUseCase;

    public UpdateNoteByIdUseCaseImpl(NoteRepositoryService noteRepositoryService, GetNoteByIdUseCase getNoteByIdUseCase) {
        this.noteRepositoryService = noteRepositoryService;
        this.getNoteByIdUseCase = getNoteByIdUseCase;
    }

    @Override
    public Note execute(Long id, String noteContent) throws NoteNotFoundException {
        var note = getNoteByIdUseCase.execute(id);

        return noteRepositoryService.updateNoteById(new Note(
                note.id(),
                note.commonUser(),
                note.exercise(),
                noteContent,
                new Date()
        ));
    }
}
