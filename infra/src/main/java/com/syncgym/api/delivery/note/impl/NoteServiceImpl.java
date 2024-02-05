package com.syncgym.api.delivery.note.impl;

import com.syncgym.api.delivery.commonUser.entities.CommonUserEntity;
import com.syncgym.api.delivery.exercise.entities.ExerciseEntity;
import com.syncgym.api.delivery.note.entities.NoteEntity;
import com.syncgym.api.delivery.note.mappers.NoteRepositoryMapper;
import com.syncgym.api.delivery.note.repositories.NoteRepository;
import com.syncgym.api.note.Note;
import com.syncgym.api.note.ports.NoteRepositoryService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class NoteServiceImpl implements NoteRepositoryService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteRepositoryMapper noteRepositoryMapper;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Collection<Note> getAllNotesByUserUsernameAndExercise(String exerciseName, String userUsername) {
        return noteRepository.findAllByCommonUserUserUsernameAndExerciseName(userUsername, exerciseName)
                .stream().map(noteRepositoryMapper::mapToDomain).toList();
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id).map(noteRepositoryMapper::mapToDomain);
    }

    @Override
    @Transactional
    public Note createNote(Note note) {
        var user = entityManager.find(CommonUserEntity.class, note.commonUser().id());
        var exercise = entityManager.find(ExerciseEntity.class, note.exercise().id());

        var entity = noteRepository.save(new NoteEntity(null, user, exercise, note.description(), note.date()));

        return noteRepositoryMapper.mapToDomain(entity);
    }

    @Override
    @Transactional
    public Note updateNoteById(Note note) {
        var noteEntity = entityManager.find(NoteEntity.class, note.id());
        noteEntity.setDescription(note.description());

        var entity = noteRepository.save(noteEntity);

        return noteRepositoryMapper.mapToDomain(entity);
    }

    @Override
    public void deleteNoteById(Long id) {
        System.out.println("Deleting note with id: " + id);
        noteRepository.deleteById(id);
    }
}
