package org.springframework.social.bitly.api.impl.json.deserializers;

import java.io.IOException;
import java.util.List;

import org.springframework.social.bitly.api.BitlyModule;
import org.springframework.social.bitly.api.Link;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LinkExpandDeserializer extends JsonDeserializer<List<Link>> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Link> deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new BitlyModule());
		jp.setCodec(mapper);
		if(jp.hasCurrentToken()) {
			JsonNode dataNode = (JsonNode) jp.readValueAs(JsonNode.class).get("expand");
			return (List<Link>) mapper.reader(new TypeReference<List<Link>>() {}).readValue(dataNode);
		}
		return null;
	}
}
