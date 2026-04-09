package com.viegas.workshopmongo.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
			HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		//StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado", e.getMessage());
		
		return null;
	}
}
