package org.springframework.social.bitly.api.impl.json;

import java.util.List;

import org.springframework.social.bitly.api.LinkLookup;
import org.springframework.social.bitly.api.impl.json.deserializers.LinkLookupDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize( using=LinkLookupDeserializer.class)
public class LinkLookupResponse extends BitlyResponse<List<LinkLookup>> {
}