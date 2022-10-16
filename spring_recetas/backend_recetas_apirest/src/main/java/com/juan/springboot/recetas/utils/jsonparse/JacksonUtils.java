package com.juan.springboot.recetas.utils.jsonparse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JacksonUtils {
	
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
