package com.juan.springboot.recetas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class CocineroException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	 	
	public CocineroException(String message) {
		super(message);
	}

}
