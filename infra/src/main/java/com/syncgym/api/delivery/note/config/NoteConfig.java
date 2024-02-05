package com.syncgym.api.delivery.note.config;

import com.syncgym.api.commonUser.usecases.getByUsernameCommonUserUseCase.GetByUsernameCommonUserUseCaseImpl;
import com.syncgym.api.delivery.note.impl.NoteServiceImpl;
import com.syncgym.api.delivery.note.mappers.NoteRepositoryMapper;
import com.syncgym.api.delivery.note.mappers.NoteResponseRestMapper;
import com.syncgym.api.exercise.usecases.getExerciseByNameUseCase.GetExerciseByNameUseCaseImpl;
import com.syncgym.api.note.usecases.createNoteUseCase.CreateNoteUseCaseImpl;
import com.syncgym.api.note.usecases.deleteNoteByIdUseCase.DeleteNoteByIdUseCaseImpl;
import com.syncgym.api.note.usecases.getAllNotesByUserUsernameAndExerciseUseCase.GetAllNotesByUserUsernameAndExerciseUseCaseImpl;
import com.syncgym.api.note.usecases.getNoteByIdUseCase.GetNoteByIdUseCaseImpl;
import com.syncgym.api.note.usecases.updateNoteByIdUseCase.UpdateNoteByIdUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoteConfig {

    @Autowired
    private GetByUsernameCommonUserUseCaseImpl getByUsernameCommonUserUseCase;

    @Autowired
    private GetExerciseByNameUseCaseImpl getExerciseByNameUseCase;

    @Bean
    public NoteRepositoryMapper noteRepositoryMapper() {
        return new NoteRepositoryMapper();
    }

    @Bean
    public NoteResponseRestMapper noteResponseRestMapper() {
        return new NoteResponseRestMapper();
    }

    @Bean
    public NoteServiceImpl noteService() {
        return new NoteServiceImpl();
    }

    @Bean
    public GetNoteByIdUseCaseImpl getNoteById() {
        return new GetNoteByIdUseCaseImpl(noteService());
    }

    @Bean
    public GetAllNotesByUserUsernameAndExerciseUseCaseImpl getAllNotesByExercise() {
        return new GetAllNotesByUserUsernameAndExerciseUseCaseImpl(noteService());
    }

    @Bean
    public CreateNoteUseCaseImpl createNote() {
        return new CreateNoteUseCaseImpl(noteService(), getByUsernameCommonUserUseCase, getExerciseByNameUseCase);
    }

    @Bean
    public UpdateNoteByIdUseCaseImpl updateNoteById() {
        return new UpdateNoteByIdUseCaseImpl(noteService(), getNoteById());
    }

    @Bean
    public DeleteNoteByIdUseCaseImpl deleteNoteById() {
        return new DeleteNoteByIdUseCaseImpl(noteService());
    }
}
