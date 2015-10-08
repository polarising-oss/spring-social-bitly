package org.springframework.social.bitly.api.impl.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.impl.json.deserializers.LinkInfoDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonPropertyOrder({ "data" })
public class LinkInfoResponse extends BitlyResponse implements ListResponse<Link> 
{
	@JsonProperty("data")
	@JsonDeserialize( using=LinkInfoDeserializer.class )
	private List<Link> info = new ArrayList<Link>();

	@Override
	public List<Link> getData() {
		return info;
	}
}