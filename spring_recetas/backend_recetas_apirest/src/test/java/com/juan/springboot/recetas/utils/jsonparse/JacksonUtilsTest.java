package com.juan.springboot.recetas.utils.jsonparse;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import net.joshka.junit.json.params.JsonFileSource;
import net.joshka.junit.json.params.JsonSource;


class JacksonUtilsTest {
	
	@InjectMocks
	JacksonUtils jacksonUtils = new JacksonUtils();

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
