package com.juan.springboot.recetas.service;

import java.util.List;

import com.juan.springboot.recetas.entity.Ingrediente;

public interface IIngredienteService {
	
	Ingrediente findById(Long id);
	
	Ingrediente findByNombre(String nombre);
	
	List<Ingrediente> findAll();
	
	Ingrediente create(Ingrediente ingrediente);

}
