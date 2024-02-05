package com.syncgym.api.delivery.note.repositories;

import com.syncgym.api.delivery.note.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    Collection<NoteEntity> findAllByCommonUserUserUsernameAndExerciseName(String userUsername, String exerciseName);
}
