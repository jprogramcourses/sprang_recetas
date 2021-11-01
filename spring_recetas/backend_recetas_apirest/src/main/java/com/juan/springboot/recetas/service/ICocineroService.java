package com.juan.springboot.recetas.service;

import java.util.List;

import com.juan.springboot.recetas.entity.Cocinero;

public interface ICocineroService {
	
	Cocinero findById(Integer id);
	
	List<Cocinero> findAll();

}
