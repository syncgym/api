package com.syncgym.api.delivery.commonUser.impl;

import com.syncgym.api.commonUser.exceptions.CommonUserAlreadyExistsException;
import com.syncgym.api.commonUser.exceptions.CommonUserInternalException;
import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.commonUser.usecases.createCommonUserUseCase.CreateCommonUserUseCase;
import com.syncgym.api.commonUser.usecases.getCommonUserByUsernameUseCase.GetCommonUserByUsernameUseCase;
import com.syncgym.api.delivery.commonUser.CommonUserController;
import com.syncgym.api.delivery.commonUser.mappers.CommonUserResponseRestMapper;
import com.syncgym.api.delivery.commonUser.mappers.CommonUserRestMapper;
import com.syncgym.api.delivery.commonUser.responses.CommonUserResponse;
import com.syncgym.api.delivery.commonUser.rest.CommonUserResponseRest;
import com.syncgym.api.delivery.commonUser.rest.CommonUserRest;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.InternalErrorException;
import com.syncgym.api.shared.exceptions.NotFoundException;
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

@RestController
@RequestMapping("/api/v1/common-user")
@Tag(name = "Common User", description = "Endpoint for common user management")
public class CommonUserControllerImpl implements CommonUserController {

    @Autowired
    private GetCommonUserByUsernameUseCase getCommonUserByUsernameUseCase;

    @Autowired
    private CreateCommonUserUseCase createCommonUserUseCase;

    @Autowired
    private CommonUserResponseRestMapper responseMapper;

    @Autowired
    private CommonUserRestMapper reqMapper;

    @Override
    @GetMapping("/{username}")
    @Operation(summary = "Find by username", description = "Find a common user by username",
            tags = {"Common User"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = CommonUserResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    public ResponseEntity<SyncgymResponse<CommonUserResponseRest>> getCommonUserByUsername(@PathVariable("username") String username) throws SyncgymException {
        try {
            var commonUser = getCommonUserByUsernameUseCase.execute(username);

            var res = new SyncgymResponse<>(
                    CommonConstants.OK,
                    CommonConstants.OK_STATUS,
                    CommonConstants.SUCCESS_MESSAGE,
                    responseMapper.mapToRest(commonUser)
            );

            return ResponseEntity.ok(res);
        } catch (CommonUserNotFoundException e) {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    @PostMapping
    @Operation(summary = "Create common user", description = "Create a common user",
            tags = {"Common User"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(schema = @Schema(implementation = CommonUserResponse.class))),
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
    public ResponseEntity<SyncgymResponse<CommonUserResponseRest>> createCommonUser(@Valid @RequestBody CommonUserRest commonUserRest) throws SyncgymException {
        try {
            var commonUser = createCommonUserUseCase.execute(
                    commonUserRest.username(),
                    commonUserRest.password(),
                    reqMapper.mapToDomain(commonUserRest)
            );

            var res = new SyncgymResponse<>(
                    CommonConstants.CREATED,
                    CommonConstants.CREATED_STATUS,
                    CommonConstants.SUCCESS_MESSAGE,
                    responseMapper.mapToRest(commonUser)
            );

            return ResponseEntity.status(CommonConstants.CREATED_STATUS).body(res);
        } catch (CommonUserAlreadyExistsException e) {
            throw new BadRequestException("User already exists");
        } catch (CommonUserInternalException e) {
            throw new InternalErrorException("Internal error");
        }
    }
}
