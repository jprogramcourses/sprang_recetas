package com.juan.springboot.recetas.controller;

import org.springframework.web.multipart.MultipartFile;

import com.juan.springboot.recetas.entity.Receta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Receta file controller",
		tags = "Receta file API",
		consumes = "application/json")
public interface RecetaFileController {
	
	@ApiOperation(value = "Upload image")
	public Receta uploadRecetaImage(MultipartFile file);

}
