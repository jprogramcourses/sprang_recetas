package com.juan.springboot.recetas.utils.jsonparse;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juan.springboot.recetas.dto.IngredienteDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JacksonUtils {
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * Java Object to JSON, using ObjectMapper writeValue().
	 * Print the result in a file.
	 * 
	 * 
	 * @param ingredienteDto
	 */
	public void writeValueInFileExample(IngredienteDto ingredienteDto) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File("target/ingredienteDto.json"), ingredienteDto);
		} catch (JsonGenerationException e) {
			log.error("JsonGStringException");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * JSON to Java Object, using ObjectMapper readValue.
	 * 
	 * 
	 * @param json
	 * @return Java Object
	 */
	public IngredienteDto jsonToJavaObjectExample(String json) {
		IngredienteDto ingredienteDto = IngredienteDto.builder().build();
		try {
			ingredienteDto = objectMapper.readValue(json, IngredienteDto.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ingredienteDto;
	}
	
	/**
	 * JSON to JacksonNode, using ObjectMapper readTree(String json).
	 * 
	 * @param json
	 * @param node
	 * @return String with the node content.
	 */
	public String jsonToJsonNodeExample(String json, String node) {
		JsonNode jsonNode = null;
		try {
			jsonNode = objectMapper.readTree(json);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = jsonNode.get(node).asText();
		return name;
	}
	
	/**
	 * JSON to Optional of the Java Object, using ObjectMapper readValue.
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public Optional<IngredienteDto> jsonToJavaObjectReadFromFile(String path) throws IOException {
		IngredienteDto ingredienteDto = null;
		try {
			// new URL("file:src/test/resources/file.json")
			// ingredienteDto = objectMapper.readValue(new URL(path), IngredienteDto.class);
			ingredienteDto = objectMapper.readValue(new File(path), IngredienteDto.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return Optional.ofNullable(ingredienteDto);
	}
	
	public JsonParser createParserJacksonExample(String content) {
		JsonFactory factory = new JsonFactory();
		JsonParser parser = null;
		try {
			parser = factory.createParser(content);
			log.info(parser.getText());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			log.info(content);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.info(content);
			e.printStackTrace();
		}
		return parser;
	}
	
	public List<String> iterateOnParser(String content) {
		JsonParser jsonParser = createParserJacksonExample(content);
		
		List<String> listTokens = new ArrayList<>();
		
		while(!jsonParser.isClosed()) {
			try {
				JsonToken token = jsonParser.nextToken();
				System.out.printf("token = %s%n", token);
				listTokens.add(token.asString());
				log.info(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.info(content);
				e.printStackTrace();
			}
		}
		return listTokens;
	}
	

}
