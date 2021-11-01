package com.juan.springboot.recetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.springboot.recetas.entity.Cocinero;
import com.juan.springboot.recetas.service.ICocineroService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class CocineroController {
	
	@Autowired
	private ICocineroService cocineroService;
	
	@GetMapping(value = "/cocineros", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cocinero> getConcineros(){
		return cocineroService.findAll();
	}

}
