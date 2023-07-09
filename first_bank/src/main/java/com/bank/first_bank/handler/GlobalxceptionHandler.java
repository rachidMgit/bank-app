package com.bank.first_bank.handler;

import com.bank.first_bank.exceptions.ObjectValidationException;
import com.bank.first_bank.exceptions.OperationNonPermittedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalxceptionHandler {
    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage("Object not valid exception has occured")
                .errorSource(exception.getViolationSource())
                .validationEerrors(exception.getViolatons())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionRepresentation);

    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(EntityNotFoundException exception){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionRepresentation);

    }

    @ExceptionHandler(OperationNonPermittedException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(OperationNonPermittedException exception){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage(exception.getErrorMsg())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(exceptionRepresentation);

    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage("Le mail est déjà utilisé")
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionRepresentation);

    }

}
