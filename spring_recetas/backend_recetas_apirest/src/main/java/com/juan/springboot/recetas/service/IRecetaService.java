package com.juan.springboot.recetas.service;

import java.util.List;

import com.juan.springboot.recetas.entity.Receta;

public interface IRecetaService {
	
	Receta findRecetaById(Integer id);
	
	List<Receta> findAllRecetas();

}
