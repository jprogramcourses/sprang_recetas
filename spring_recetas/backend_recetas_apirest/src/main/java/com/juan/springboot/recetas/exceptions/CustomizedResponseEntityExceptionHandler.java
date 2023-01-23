package com.juan.springboot.recetas.exceptions;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Implementing Generic Exception Handling for all Resources
 * 
 * @author juand
 *
 */
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private final MessageSource messageSource;
	
	@Autowired
	public CustomizedResponseEntityExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request, Locale locale) throws Exception{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CocineroException.class)
	public final ResponseEntity<ErrorDetails> handleNotFoundException(Exception ex, WebRequest request, Locale locale) throws Exception{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		CustomRecetasError customError = new CustomRecetasError();
		customError.setErrorMessage(messageSource.getMessage(ex.getMessage(), ex.getStackTrace(), locale));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
