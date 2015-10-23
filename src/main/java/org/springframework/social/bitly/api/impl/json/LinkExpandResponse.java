package org.springframework.social.bitly.api.impl.json;

import java.util.List;

import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.impl.json.deserializers.LinkExpandDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize( using=LinkExpandDeserializer.class)
public class LinkExpandResponse extends BitlyResponse<List<Link>>
{
	
}