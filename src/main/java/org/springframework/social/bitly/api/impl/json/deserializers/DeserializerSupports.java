package org.springframework.social.bitly.api.impl.json.deserializers;

import java.io.IOException;

import org.springframework.social.bitly.api.BitlyModule;
import org.springframework.social.bitly.api.impl.json.BitlyResponse;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class DeserializerSupports<T> extends JsonDeserializer<T>{
	
	private static final String DEFAULT_DATA_NODE_NAME = "data";
	
	protected DeserializerSupports(){ }
	
	protected BitlyResponse<?> parse( BitlyResponse<?> response, TypeReference<?> typeReference, JsonParser jp, DeserializationContext context, String nodeName  ) throws JsonProcessingException, IOException {
		return this.parse(response, typeReference, jp, context, DEFAULT_DATA_NODE_NAME, nodeName);
	}
	
	protected BitlyResponse<?> parse( BitlyResponse<?> response, TypeReference<?> typeReference, JsonParser jp, DeserializationContext context, String dataNodeName, String nodeName  ) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new BitlyModule());
		jp.setCodec(mapper);

		JsonNode node = jp.getCodec().readTree(jp);
		JsonNode dataNode = node.get(dataNodeName);
		response.setData( mapper.reader( typeReference ).readValue(dataNode.get( nodeName )) );
		return response;
	}
}
