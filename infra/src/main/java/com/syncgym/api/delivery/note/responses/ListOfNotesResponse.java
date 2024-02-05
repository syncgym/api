package com.syncgym.api.delivery.note.responses;

import com.syncgym.api.delivery.note.rest.NoteResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.List;

public class ListOfNotesResponse extends SyncgymResponse<List<NoteResponseRest>> {

    public ListOfNotesResponse(String status, int code, String message, List<NoteResponseRest> data) {
        super(status, code, message, data);
    }
}
