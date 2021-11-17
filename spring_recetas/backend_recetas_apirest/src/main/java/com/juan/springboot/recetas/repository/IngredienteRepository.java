package com.juan.springboot.recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juan.springboot.recetas.entity.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
