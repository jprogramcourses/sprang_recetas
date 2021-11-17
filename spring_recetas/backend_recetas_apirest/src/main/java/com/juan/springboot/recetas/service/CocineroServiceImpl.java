package com.juan.springboot.recetas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.springboot.recetas.entity.Cocinero;
import com.juan.springboot.recetas.repository.CocineroRepository;

@Service
public class CocineroServiceImpl implements ICocineroService {
	
	@Autowired
	private CocineroRepository cocineroRepository;

	@Override
	@Transactional(readOnly = true)
	public Cocinero findById(Integer id) {
		return cocineroRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cocinero> findAll() {
		return cocineroRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Cocinero> findAll(Pageable pageable) {
		return cocineroRepository.findAll(pageable);
	}

	@Override
	public Cocinero create(Cocinero cocinero) {
		return cocineroRepository.save(cocinero);
	}

	@Override
	public void delete(Integer id) {
		cocineroRepository.deleteById(id);
	}

}
