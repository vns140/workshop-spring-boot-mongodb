package com.viniciussaraiva.workshopmongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.viniciussaraiva.workshopmongo.services.exception.ObjectNotFoundException;



@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,HttpServletRequest request ){

		String status = Integer.toString(HttpStatus.NOT_FOUND.value());
		String timestamp = Long.toString(System.currentTimeMillis());		
		StandardError err = new StandardError(timestamp, status, "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
