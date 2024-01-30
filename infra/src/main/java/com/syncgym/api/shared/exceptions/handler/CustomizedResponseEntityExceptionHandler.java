package com.syncgym.api.shared.exceptions.handler;

import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SyncgymException.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(SyncgymException ex, WebRequest req) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                CommonConstants.INTERNAL_SERVER_ERROR,
                CommonConstants.INTERNAL_SERVER_ERROR_STATUS,
                ex.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> badRequestException(SyncgymException ex, WebRequest req) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getResponse().getStatus(), ex.getResponse().getCode(), ex.getMessage(), req.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenException.class)
    public final ResponseEntity<ExceptionResponse> forbiddenException(SyncgymException ex, WebRequest req) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getResponse().getStatus(), ex.getResponse().getCode(), ex.getMessage(), req.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InternalErrorException.class)
    public final ResponseEntity<ExceptionResponse> internalErrorException(SyncgymException ex, WebRequest req) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getResponse().getStatus(), ex.getResponse().getCode(), ex.getMessage(), req.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> notFoundException(SyncgymException ex, WebRequest req) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getResponse().getStatus(), ex.getResponse().getCode(), ex.getMessage(), req.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
