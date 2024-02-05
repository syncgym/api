package com.syncgym.api.delivery.note.mappers;

import com.syncgym.api.delivery.commonUser.mappers.CommonUserRepositoryMapper;
import com.syncgym.api.delivery.exercise.mappers.ExerciseRepositoryMapper;
import com.syncgym.api.delivery.note.entities.NoteEntity;
import com.syncgym.api.note.Note;
import com.syncgym.api.shared.RepositoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteRepositoryMapper implements RepositoryMapper<NoteEntity, Note> {

    @Autowired
    private CommonUserRepositoryMapper commonUserRepositoryMapper;

    @Autowired
    private ExerciseRepositoryMapper exerciseRepositoryMapper;

    @Override
    public NoteEntity mapToEntity(Note domain) {
        return new NoteEntity(
                domain.id(),
                commonUserRepositoryMapper.mapToEntity(domain.commonUser()),
                exerciseRepositoryMapper.mapToEntity(domain.exercise()),
                domain.description(),
                domain.date()
        );
    }

    @Override
    public Note mapToDomain(NoteEntity entity) {
        return new Note(
                entity.getId(),
                commonUserRepositoryMapper.mapToDomain(entity.getCommonUser()),
                exerciseRepositoryMapper.mapToDomain(entity.getExercise()),
                entity.getDescription(),
                entity.getDate()
        );
    }
}
