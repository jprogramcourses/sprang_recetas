package com.juan.springboot.recetas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.springboot.recetas.entity.Receta;
import com.juan.springboot.recetas.repository.RecetaRepository;

@Service
public class RecetaServiceImpl implements IRecetaService {
	
	@Autowired
	RecetaRepository recetaRepository;

	@Override
	public Receta findRecetaById(Integer id) {
		return recetaRepository.getById(id);
	}

	@Override
	public List<Receta> findAllRecetas() {
		return recetaRepository.findAll();
	}

}
