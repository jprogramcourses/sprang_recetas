package com.juan.springboot.recetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.juan.springboot.recetas.entity.Ingrediente;
import com.juan.springboot.recetas.service.IIngredienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class IngredienteControllerImpl implements IngredienteController {
	
	@Autowired
	private IIngredienteService ingredienteService;
	
	@GetMapping(value = "/ingredientes", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<Ingrediente> getIngredientes(){
		return ingredienteService.findAll();
	}
	
	@GetMapping(value = "ingrediente/{nombre}")
	@Override
	public Ingrediente getIngredienteByNombre(@PathVariable String nombre) {
		return ingredienteService.findByNombre(nombre);
	}
	
	@PostMapping(value = "/ingredientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public Ingrediente newIngrediente(@RequestBody Ingrediente ingrediente) {
		if(ingrediente != null) {
			return ingredienteService.create(ingrediente);
		}else {
			return null;
		}
	}

}
