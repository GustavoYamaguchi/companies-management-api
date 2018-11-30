package com.companiesmanagementapi.companiesmanagementapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String DOCUMENTATION_URI = "";

    @ExceptionHandler({ ResourceNotFoundException.class, CouldNotRetrieveSeedInformationException.class })
    protected ResponseEntity<Object> handleWrongDataException(WrongDataException ex,
                                                                          WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ InvalidDataRequestException.class })
    protected ResponseEntity<Object> handleMissingDataAccessException(InvalidDataRequestException ex,
                                                                          WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
