package com.syncgym.api.delivery.note.impl;

import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.delivery.muscleGroup.responses.DeleteMuscleGroupResponse;
import com.syncgym.api.delivery.note.NoteController;
import com.syncgym.api.delivery.note.mappers.NoteResponseRestMapper;
import com.syncgym.api.delivery.note.responses.ListOfNotesResponse;
import com.syncgym.api.delivery.note.responses.NoteResponse;
import com.syncgym.api.delivery.note.rest.CreateNoteRest;
import com.syncgym.api.delivery.note.rest.NoteResponseRest;
import com.syncgym.api.delivery.note.rest.UpdateNoteRest;
import com.syncgym.api.exercise.exceptions.ExerciseNotFoundException;
import com.syncgym.api.note.exceptions.NoteNotFoundException;
import com.syncgym.api.note.usecases.createNoteUseCase.CreateNoteUseCase;
import com.syncgym.api.note.usecases.deleteNoteByIdUseCase.DeleteNoteByIdUseCase;
import com.syncgym.api.note.usecases.getAllNotesByUserUsernameAndExerciseUseCase.GetAllNotesByUserUsernameAndExerciseUseCase;
import com.syncgym.api.note.usecases.updateNoteByIdUseCase.UpdateNoteByIdUseCase;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.exceptions.handler.ExceptionResponse;
import com.syncgym.api.shared.responses.SyncgymResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@Tag(name = "Note", description = "Endpoint for note management")
public class NoteControllerImpl implements NoteController {

    @Autowired
    private GetAllNotesByUserUsernameAndExerciseUseCase getAllNotesByUserUsernameAndExerciseUseCase;

    @Autowired
    private CreateNoteUseCase createNoteUseCase;

    @Autowired
    private UpdateNoteByIdUseCase updateNoteByIdUseCase;

    @Autowired
    private DeleteNoteByIdUseCase deleteNoteByIdUseCase;

    @Autowired
    private NoteResponseRestMapper noteResponseRestMapper;

    @Override
    @GetMapping("/{username}/{exercise}")
    @Operation(summary = "Get all notes by user username and exercise", description = "Get all notes by user username and exercise name",
            tags = {"Note"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = ListOfNotesResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    public ResponseEntity<SyncgymResponse<List<NoteResponseRest>>> getAllNotesByExercise(
            @PathVariable("exercise") String exercise, @PathVariable("username") String username
    ) throws SyncgymException {
        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                getAllNotesByUserUsernameAndExerciseUseCase.execute(exercise, username)
                        .stream().map(noteResponseRestMapper::mapToRest).toList()
        );

        return ResponseEntity.ok(res);
    }

    @Override
    @PostMapping
    @Operation(summary = "Create a note", description = "Create a note",
            tags = {"Note"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    public ResponseEntity<SyncgymResponse<NoteResponseRest>> createNote(@Valid @RequestBody CreateNoteRest note) throws SyncgymException {
        try {
            var res = new SyncgymResponse<>(

                    CommonConstants.CREATED,
                    CommonConstants.CREATED_STATUS,
                    CommonConstants.SUCCESS_MESSAGE,
                    noteResponseRestMapper.mapToRest(createNoteUseCase.execute(
                            note.userUsername(),
                            note.exerciseName(),
                            note.noteContent()
                    ))
            );

            return ResponseEntity.status(CommonConstants.CREATED_STATUS).body(res);
        } catch (CommonUserNotFoundException | ExerciseNotFoundException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    @PutMapping("/{id}")
    @Operation(summary = "Update a note by id", description = "Update a note by id",
            tags = {"Note"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    public ResponseEntity<SyncgymResponse<NoteResponseRest>> updateNoteById(
            @PathVariable("id") Long id, @Valid @RequestBody UpdateNoteRest note
    ) throws SyncgymException {
        try {
            var res = new SyncgymResponse<>(
                    CommonConstants.OK,
                    CommonConstants.OK_STATUS,
                    CommonConstants.SUCCESS_MESSAGE,
                    noteResponseRestMapper.mapToRest(updateNoteByIdUseCase.execute(id, note.noteContent()))
            );

            return ResponseEntity.ok(res);
        } catch (NoteNotFoundException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a note by id", description = "Delete a note by id",
            tags = {"Note"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = DeleteMuscleGroupResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    public ResponseEntity<SyncgymResponse<Object>> deleteNoteById(@PathVariable("id") Long id) throws SyncgymException {
        try {
            deleteNoteByIdUseCase.execute(id);
        } catch (NoteNotFoundException e) {
            throw new BadRequestException(e.getMessage());
        }

        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE
        );

        return ResponseEntity.ok(res);
    }
}
