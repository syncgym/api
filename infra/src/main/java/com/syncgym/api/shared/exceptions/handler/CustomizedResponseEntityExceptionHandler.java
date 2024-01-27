package com.syncgym.api.shared.exceptions.handler;

import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.SyncgymException;
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
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(SyncgymException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage(), request.getDescription(false), ex.getCode()
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> badRequestException(SyncgymException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage(), request.getDescription(false), ex.getCode()
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
