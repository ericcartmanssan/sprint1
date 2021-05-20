package com.cg.onlinenursery.exceptioncontolleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlinenursery.exception.InvalidDataException;

@ControllerAdvice
public class InvalidDataExceptionController {
	   @ExceptionHandler(value = InvalidDataException.class)
	   public ResponseEntity<Object> exception(InvalidDataException exception) {
	      return new ResponseEntity<>("Login Failed! - Enter Correct Details", HttpStatus.NOT_FOUND);
	   }
}