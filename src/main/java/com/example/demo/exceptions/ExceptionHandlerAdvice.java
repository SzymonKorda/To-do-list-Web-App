package com.example.demo.exceptions;

import com.example.demo.payload.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity userExistsHandler(UserExistsException ex) {
        return new ResponseEntity(new ApiResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity roleNotFoundExceptionHandler(RoleNotFoundException ex) {
        return new ResponseEntity(new ApiResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNotFoundExceptionHandler(UserNotFoundException ex) {
        return new ResponseEntity(new ApiResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }



}
