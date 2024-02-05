package com.syncgym.api.delivery.note.responses;

import com.syncgym.api.delivery.note.rest.NoteResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class NoteResponse extends SyncgymResponse<NoteResponseRest> {

    public NoteResponse(String status, int code, String message, NoteResponseRest data) {
        super(status, code, message, data);
    }
}
