package com.juan.springboot.recetas.exceptions;

import java.util.List;

import lombok.Data;

@Data
public class CustomRecetasError {
	
	private String errorCode;
	private String errorMessage;
	private List<ErrorDetails> errorDetails;

}
