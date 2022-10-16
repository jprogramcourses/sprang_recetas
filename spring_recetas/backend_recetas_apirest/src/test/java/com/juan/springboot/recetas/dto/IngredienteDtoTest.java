package com.juan.springboot.recetas.dto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTest
class IngredienteDtoTest extends BaseTest {
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	void serializeDtoTest() throws JsonProcessingException {
		 IngredienteDto ingredienteDto = getIngredienteDto();
		 
		 String jsonString = objectMapper.writeValueAsString(ingredienteDto);
		 
		 System.out.println(jsonString);
	}
	
	@Test
	void serializeDtoExceptionTest() throws JsonProcessingException {
		IngredienteDto ingredienteDto = getIngredienteDtoException();
		String jsonString = objectMapper.writeValueAsString(ingredienteDto);
		
		System.out.println(jsonString);
	}
	
	@Test
	void deserializeDtoTest() throws JsonMappingException, JsonProcessingException {
		String ingrediente = "{\"ingredienteId\":\"b9757f21-7242-4b06-b449-19a8049216a1\",\"nombre\":\"IngredienteDto test\",\"descripcion\":\"Descripción ingrediente 1\",\"calorias\":12.3,\"grasa\":null,\"proteina\":null,\"agua\":null,\"fibra\":null,\"carbohidratos\":null,\"acidosGrasosMonoinsaturados\":null,\"acidosGrasosPoliinsaturados\":null,\"acidosGrasosSaturados\":null,\"colesterol\":null,\"vitaminaA\":null,\"vitaminaB6\":null,\"vitaminaB12\":null,\"vitaminaC\":null,\"vitaminaD\":null,\"vitaminaE\":null,\"riboflavina\":null,\"tiamina\":null,\"niacina\":null,\"folato\":null,\"calcio\":null,\"hierro\":null,\"potasio\":null,\"sodio\":null,\"fosforo\":null,\"ioduro\":null,\"selenio\":null,\"zinc\":null}";
		
		IngredienteDto ingredienteDto = objectMapper.readValue(ingrediente, IngredienteDto.class);
		
		System.out.println(ingredienteDto);
	}
	
	@Test
	void deserializeDtoExceptionTest() throws JsonMappingException, JsonProcessingException {
		String ingredienteString = "{\"id\":null,\"nombre\":null,\"descripcion\":\"Descripción ingrediente 1\",\"calorias\":12.3,\"grasa\":null,\"proteina\":null,\"agua\":null,\"fibra\":null,\"carbohidratos\":null,\"acidosGrasosMonoinsaturados\":null,\"acidosGrasosPoliinsaturados\":null,\"acidosGrasosSaturados\":null,\"colesterol\":null,\"vitaminaA\":null,\"vitaminaB6\":null,\"vitaminaB12\":null,\"vitaminaC\":null,\"vitaminaD\":null,\"vitaminaE\":null,\"riboflavina\":null,\"tiamina\":null,\"niacina\":null,\"folato\":null,\"calcio\":null,\"hierro\":null,\"potasio\":null,\"sodio\":null,\"fosforo\":null,\"ioduro\":null,\"selenio\":null,\"zinc\":null}";
		IngredienteDto ingredienteDto = objectMapper.readValue(ingredienteString, IngredienteDto.class);
		System.out.println(ingredienteDto);
	}

}
