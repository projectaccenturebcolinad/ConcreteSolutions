package com.evaluateApisBcolinad.restfulApis.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ExceptionsHandler {

    //
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomException> handleAllExceptions(Exception ex, WebRequest request) {
        CustomException resultException = new CustomException(ex.getMessage());
        return new ResponseEntity<>(resultException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
