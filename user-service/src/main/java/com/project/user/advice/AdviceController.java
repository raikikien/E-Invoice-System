package com.project.user.advice;

import com.project.user.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<User> handleException() {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  /*  @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> handleException(CustomException ex) {
        ex.get
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/


}
