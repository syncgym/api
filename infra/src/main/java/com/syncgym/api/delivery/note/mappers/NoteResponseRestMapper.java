package com.syncgym.api.delivery.note.mappers;

import com.syncgym.api.delivery.exercise.mappers.ExerciseResponseRestMapper;
import com.syncgym.api.delivery.note.rest.NoteResponseRest;
import com.syncgym.api.note.Note;
import com.syncgym.api.shared.RestMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteResponseRestMapper implements RestMapper<NoteResponseRest, Note> {

    @Autowired
    private ExerciseResponseRestMapper exerciseResponseRestMapper;

    @Override
    public NoteResponseRest mapToRest(Note domain) {
        return new NoteResponseRest(
                domain.id(),
                exerciseResponseRestMapper.mapToRest(domain.exercise()),
                domain.description(),
                domain.date()
        );
    }
}
