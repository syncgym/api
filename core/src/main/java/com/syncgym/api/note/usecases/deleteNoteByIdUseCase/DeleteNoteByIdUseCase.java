package com.syncgym.api.note.usecases.deleteNoteByIdUseCase;

import com.syncgym.api.note.exceptions.NoteNotFoundException;

public interface DeleteNoteByIdUseCase {

    void execute(Long noteId) throws NoteNotFoundException;
}
