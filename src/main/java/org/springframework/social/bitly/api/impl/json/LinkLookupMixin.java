package org.springframework.social.bitly.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkLookupMixin {
	
	@JsonProperty( "url" )
	private String url;
	
	@JsonProperty( "aggregate_link" )	
	private String shortUrl;
}