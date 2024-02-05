package com.syncgym.api.note.exceptions;

public class NoteNotFoundException extends Exception {

    public NoteNotFoundException() {
        super("Note not found");
    }
}
