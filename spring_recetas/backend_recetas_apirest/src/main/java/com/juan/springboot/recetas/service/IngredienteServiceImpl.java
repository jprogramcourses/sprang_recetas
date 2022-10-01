package com.juan.springboot.recetas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.springboot.recetas.entity.Ingrediente;
import com.juan.springboot.recetas.repository.IngredienteRepository;

@Service
public class IngredienteServiceImpl implements IIngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;

	@Override
	public Ingrediente findById(Long id) {
		return ingredienteRepository.findById(id).orElse(null);
	}
	
	@Override
	public Ingrediente findByNombre(String nombre) {
		return ingredienteRepository.findByNombre(nombre);
	}

	@Override
	public List<Ingrediente> findAll() {
		return ingredienteRepository.findAll();
	}

	@Override
	public Ingrediente create(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}

}
