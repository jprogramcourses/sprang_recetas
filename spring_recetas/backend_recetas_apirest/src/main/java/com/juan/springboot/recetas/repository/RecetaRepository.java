package com.juan.springboot.recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juan.springboot.recetas.entity.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {

}
