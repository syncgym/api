package com.syncgym.api.delivery.note;

import com.syncgym.api.delivery.note.rest.CreateNoteRest;
import com.syncgym.api.delivery.note.rest.NoteResponseRest;
import com.syncgym.api.delivery.note.rest.UpdateNoteRest;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NoteController {

    ResponseEntity<SyncgymResponse<List<NoteResponseRest>>> getAllNotesByExercise(String exercise, String username) throws SyncgymException;

    ResponseEntity<SyncgymResponse<NoteResponseRest>> createNote(CreateNoteRest note) throws SyncgymException;

    ResponseEntity<SyncgymResponse<NoteResponseRest>> updateNoteById(Long id, UpdateNoteRest note) throws SyncgymException;

    ResponseEntity<SyncgymResponse<Object>> deleteNoteById(Long id) throws SyncgymException;
}
