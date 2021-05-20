package com.cg.onlinenursery.exceptioncontolleradvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlinenursery.exception.AdminNotFoundException;

@ControllerAdvice
public class AdminNotFoundExceptionController {
	   @ExceptionHandler(value = AdminNotFoundException.class)
	   public ResponseEntity<Object> exception(AdminNotFoundException exception) {
	      return new ResponseEntity<>("Admin Not Found With AdminName", HttpStatus.NOT_FOUND);
	   }
}
