package com.juan.springboot.recetas.utils.jsonparse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.juan.springboot.recetas.dto.IngredienteDto;

import net.joshka.junit.json.params.JsonFileSource;
import net.joshka.junit.json.params.JsonSource;


class JacksonUtilsTest {
	
	@InjectMocks
	JacksonUtils jacksonUtils = new JacksonUtils();
	
	@Test
	void writeValueInFileExampleTest() {
		IngredienteDto recetaDto = IngredienteDto.builder().id(UUID.randomUUID()).nombre("ing").calorias(100.00).build();
		jacksonUtils.writeValueInFileExample(recetaDto);
	}
	
	@Test
	void javaObjectToJsonString() {
		IngredienteDto ingredienteDto = new IngredienteDto();
		ingredienteDto.setId(UUID.randomUUID());
		ingredienteDto.setNombre("arroz");
		ingredienteDto.setCalorias(1.00);
		ingredienteDto.setDescripcion("Descripción");
		
		String ingredienteJsonString = jacksonUtils.javaObjectToJsonString(ingredienteDto);
		assertNotNull(ingredienteJsonString);
	}
	
	@Test
	void jsonToJavaObjectExampleTest() {
		String json = "{\"nombre\":\"ing\",\"descripcion\":null,\"calorias\":100.0,\"grasa\":null,\"proteina\":null,\"agua\":null,\"fibra\":null,\"carbohidratos\":null,\"acidosGrasosMonoinsaturados\":null,\"acidosGrasosPoliinsaturados\":null,\"acidosGrasosSaturados\":null,\"colesterol\":null,\"vitaminaA\":null,\"vitaminaB6\":null,\"vitaminaB12\":null,\"vitaminaC\":null,\"vitaminaD\":null,\"vitaminaE\":null,\"riboflavina\":null,\"tiamina\":null,\"niacina\":null,\"folato\":null,\"calcio\":null,\"hierro\":null,\"potasio\":null,\"sodio\":null,\"fosforo\":null,\"ioduro\":null,\"selenio\":null,\"zinc\":null,\"ingredienteId\":\"e2f503af-8170-46aa-8619-cba612e87f0e\"}";
		IngredienteDto ingredienteDto = jacksonUtils.jsonToJavaObjectExample(json);
		assertEquals(ingredienteDto.getNombre(), "ing");
	}
	
	@Test
	void jsonToJsonNodeExampleTest() {
		String json = "{\"nombre\":\"ing\",\"descripcion\":null,\"calorias\":100.0,\"grasa\":null,\"proteina\":null,\"agua\":null,\"fibra\":null,\"carbohidratos\":null,\"acidosGrasosMonoinsaturados\":null,\"acidosGrasosPoliinsaturados\":null,\"acidosGrasosSaturados\":null,\"colesterol\":null,\"vitaminaA\":null,\"vitaminaB6\":null,\"vitaminaB12\":null,\"vitaminaC\":null,\"vitaminaD\":null,\"vitaminaE\":null,\"riboflavina\":null,\"tiamina\":null,\"niacina\":null,\"folato\":null,\"calcio\":null,\"hierro\":null,\"potasio\":null,\"sodio\":null,\"fosforo\":null,\"ioduro\":null,\"selenio\":null,\"zinc\":null,\"ingredienteId\":\"e2f503af-8170-46aa-8619-cba612e87f0e\"}";
		String node = "nombre";
		String jsonNodeValue = jacksonUtils.jsonToJsonNodeExample(json, node);
		assertEquals(jsonNodeValue, "ing");
	}

	@Test
	void jsonToJavaObjectReadFromFileTest() {
		String path = "src/test/resources/ingredienteDto.json";
		Optional<IngredienteDto> optIngredienteDto = Optional.empty();
		try {
			optIngredienteDto = jacksonUtils.jsonToJavaObjectReadFromFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(optIngredienteDto.isEmpty()) {
			assertNull(optIngredienteDto.get());
		}else {
			assertEquals(optIngredienteDto.get().getNombre(), "ing");
		}
	}
	
	
	@Test
	void createParserJacksonExampleTest() {
		
		String receta1 = "{\"id\":\"rec1\", \"nombre\": \"Receta 1\"}";
		assertNotNull(jacksonUtils.createParserJacksonExample(receta1));
	}
	
//	@Test
//	void createParserJacksonExampleExceptionTest() {
//		String receta1 = "ssss\\ dfsdfsdfsd";
//		JsonParseException jsonException = Assertions.assertThrows(JsonParseException.class, () -> {
//			jacksonUtils.createParserJacksonExample(receta1);
//		}, "JsonParserException was expected");
//		
//		assertTrue(jsonException.getMessage().contains("json"));
//	}
	
	@Test
	void iterateOnParserTest() {
		String receta1 = "{\"id\":\"rec1\", \"nombre\":\"Receta 1\"}";
		
		assertTrue(jacksonUtils.iterateOnParser(receta1).size() > 0);
	}
	
	@Test
	@JsonSource("\"{\\\"key\\\":\\\"value\\\"}\"")
	void testJsonSourceAnnotation() {
		
	}
	
	@Test
	@JsonFileSource(resources = "/json_test.json")
	void jacksonDemoTest() {
		
	}

}
