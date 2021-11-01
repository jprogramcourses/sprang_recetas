package com.juan.springboot.recetas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.springboot.recetas.entity.Cocinero;
import com.juan.springboot.recetas.repository.CocineroRepository;

@Service
public class CocineroServiceImpl implements ICocineroService {
	
	@Autowired
	private CocineroRepository cocineroRepository;

	@Override
	public Cocinero findById(Integer id) {
		return cocineroRepository.findById(id).orElse(null);
	}

	@Override
	public List<Cocinero> findAll() {
		return cocineroRepository.findAll();
	}

}
