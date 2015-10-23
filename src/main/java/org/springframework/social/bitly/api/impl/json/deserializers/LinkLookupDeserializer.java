package org.springframework.social.bitly.api.impl.json.deserializers;

import java.io.IOException;
import java.util.List;

import org.springframework.social.bitly.api.LinkLookup;
import org.springframework.social.bitly.api.impl.json.LinkLookupResponse;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;

public class LinkLookupDeserializer extends DeserializerSupports<LinkLookupResponse> {

	@Override
	public LinkLookupResponse deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
		return (LinkLookupResponse) parse(new LinkLookupResponse(), new TypeReference<List<LinkLookup>>() {}, jp, context, "link_lookup" );
	}
}
