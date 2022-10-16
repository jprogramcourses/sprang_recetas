package com.juan.springboot.recetas.dto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles("snake")
@JsonTest
public class IngredienteDtoSnakeCaseTest extends BaseTest {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void serializeIngredienteDtoSnakeCaseTest() throws JsonProcessingException {
		IngredienteDto ingredienteDto = getIngredienteDto();
		String json = objectMapper.writeValueAsString(ingredienteDto);
		
		System.out.println(json);
		
	}

}
