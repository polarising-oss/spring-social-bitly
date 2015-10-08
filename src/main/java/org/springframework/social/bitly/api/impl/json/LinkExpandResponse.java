package org.springframework.social.bitly.api.impl.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.impl.json.deserializers.LinkExpandDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonPropertyOrder({ "data" })
public class LinkExpandResponse extends BitlyResponse
{
	@JsonProperty("data")
	@JsonDeserialize( using=LinkExpandDeserializer.class )
	private List<Link> expand = new ArrayList<Link>();

	public List<Link> getExpand() {
		return expand;
	}
	
	public void setExpand(List<Link> expand) {
		this.expand = expand;
	}
}