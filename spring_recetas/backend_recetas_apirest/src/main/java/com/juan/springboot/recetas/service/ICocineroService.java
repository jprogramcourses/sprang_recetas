package com.juan.springboot.recetas.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juan.springboot.recetas.entity.Cocinero;

public interface ICocineroService {
	
	Cocinero findById(Integer id);
	
	List<Cocinero> findAll();
	
	Page<Cocinero> findAll(Pageable pageable);
	
	Cocinero create(Cocinero cocinero);
	
	void delete(Integer id);

}
