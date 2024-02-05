package com.syncgym.api.note.usecases.updateNoteByIdUseCase;

import com.syncgym.api.note.Note;
import com.syncgym.api.note.exceptions.NoteNotFoundException;

public interface UpdateNoteByIdUseCase {

    Note execute(Long id, String noteContent) throws NoteNotFoundException;
}
