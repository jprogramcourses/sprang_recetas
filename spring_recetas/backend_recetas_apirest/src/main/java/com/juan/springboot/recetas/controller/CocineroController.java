package com.juan.springboot.recetas.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.juan.springboot.recetas.entity.Cocinero;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Cocinero API")
public interface CocineroController {
	
	@ApiOperation(value = "${controller.cocinero.getcocineros}")
	public List<Cocinero> getCocineros();
	
	@ApiOperation(value = "List all cocineros by page")
	public Page<Cocinero> getCocineros(Integer page);
	
	@ApiOperation(value = "Retrieve cocinero select by id")
	public ResponseEntity<?> show(
			@ApiParam(value = "Cocinero id")
			Integer idCocinero);
	
	public ResponseEntity<?> create(Cocinero cocinero, BindingResult result);
	
	public ResponseEntity<?> update(Cocinero cocinero, BindingResult result, Integer idCocinero);

	public ResponseEntity<?> delete(Integer idCocinero);
	
}
