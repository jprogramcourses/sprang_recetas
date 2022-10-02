package com.juan.springboot.recetas.controller;

import java.util.List;

import com.juan.springboot.recetas.entity.Ingrediente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ExampleProperty;

@Api(value = "Example value attribute", 
	tags = "Ingrediente API",
	consumes = "application/json")
public interface IngredienteController {
	
	public List<Ingrediente> getIngredientes();
	
	@ApiOperation(value = "Find ingredient by name")
	public Ingrediente getIngredienteByNombre(
			@ApiParam(value = "Ingredients name")  
			String nombre
	);
	
	@ApiOperation(value = "Create new ingredient")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created", response = Ingrediente.class),
			@ApiResponse(code = 400, message = "Failed")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(
				name = "Ingredientessss",
				dataType = "com.juan.springboot.recetas.entity.Ingrediente",
//				examples = @io.swagger.annotations.Example(
//						value = {
//								@ExampleProperty(value = "'ingrediente: {'sss': 'sss'}", mediaType = "application/json")
//						}
//						)
				paramType = "body"
				)
	})
	public Ingrediente newIngrediente(Ingrediente ingrediente);

}
