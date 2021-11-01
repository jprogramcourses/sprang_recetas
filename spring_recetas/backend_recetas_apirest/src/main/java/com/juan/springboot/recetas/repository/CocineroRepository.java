package com.juan.springboot.recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juan.springboot.recetas.entity.Cocinero;

public interface CocineroRepository extends JpaRepository<Cocinero, Integer> {

}
