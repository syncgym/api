package com.syncgym.api.note.usecases.getNoteByIdUseCase;

import com.syncgym.api.note.Note;
import com.syncgym.api.note.exceptions.NoteNotFoundException;

public interface GetNoteByIdUseCase {

    Note execute(Long id) throws NoteNotFoundException;
}
