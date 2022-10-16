package com.juan.springboot.recetas.dto;

import java.util.UUID;

public class BaseTest {
	
	IngredienteDto getIngredienteDto() {
		return IngredienteDto.builder()
				.id(UUID.randomUUID())
				.nombre("IngredienteDto test")
				.descripcion("Descripción ingrediente 1")
				.calorias(12.3)
				.build();
	}
	
	IngredienteDto getIngredienteDtoException() {
		return IngredienteDto.builder()
				.descripcion("Descripción ingrediente 1")
				.calorias(12.3)
				.build();
	}

}
