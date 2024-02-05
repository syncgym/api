package com.syncgym.api.delivery.note.responses;

import com.syncgym.api.shared.responses.SyncgymResponse;

public class DeleteNoteResponse extends SyncgymResponse<Object> {

    public DeleteNoteResponse(String status, int code, String message) {
        super(status, code, message);
    }
}
