package org.springframework.social.bitly.api.impl.json.deserializers;

import java.io.IOException;
import java.util.List;

import org.springframework.social.bitly.api.BitlyModule;
import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.impl.json.LinkInfoResponse2;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LinkInfoDeserializer extends JsonDeserializer<LinkInfoResponse2> {

	@SuppressWarnings("unchecked")
	@Override
	public LinkInfoResponse2 deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new BitlyModule());
		jp.setCodec(mapper);

		JsonNode node = jp.getCodec().readTree(jp);
		JsonNode jsonNode = node.get("data");
		List<Link> readValue = mapper.reader(new TypeReference<List<Link>>() {}).readValue(jsonNode.get("info"));
		//LinkInfoResponse2 readValue = (LinkInfoResponse2) mapper.reader(new TypeReference<LinkInfoResponse2>() {}).readValue(node);
		LinkInfoResponse2 response = new LinkInfoResponse2();
		response.setData(readValue);
		
		return response;
		
//		jp.nextToken();
//		
//		JsonNode jsonNode = node.get("info");
//
//		
//		if(jp.hasCurrentToken()) {
//			JsonNode dataNode = (JsonNode) jp.readValueAs(JsonNode.class).get("info");
//		}
//		return null;
	}
}
