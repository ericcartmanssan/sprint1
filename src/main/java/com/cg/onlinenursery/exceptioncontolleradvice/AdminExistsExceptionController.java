package com.cg.onlinenursery.exceptioncontolleradvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlinenursery.exception.AdminExistsException;

@ControllerAdvice
public class AdminExistsExceptionController {
	   @ExceptionHandler(value = AdminExistsException.class)
	   public ResponseEntity<Object> exception(AdminExistsException exception) {
	      return new ResponseEntity<>("Admin Already Exists", HttpStatus.NOT_FOUND);
	   }
}
