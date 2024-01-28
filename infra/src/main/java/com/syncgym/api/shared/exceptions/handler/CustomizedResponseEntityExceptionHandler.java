package com.syncgym.api.shared.exceptions.handler;

import com.syncgym.api.shared.constants.CommonConstants;
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
                ex.getResponse().status(), ex.getResponse().code(), ex.getMessage(), req.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
