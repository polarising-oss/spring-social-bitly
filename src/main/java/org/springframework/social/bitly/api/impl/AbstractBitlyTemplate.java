package org.springframework.social.bitly.api.impl;

import java.net.URI;

import org.springframework.social.bitly.api.impl.json.BitlyResponse;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractBitlyTemplate {

	private static final String BITLY_API_URL = "https://api-ssl.bitly.com";
	private static final  String BITLY_API_VERSION = "/v3/";
		
	private static final MultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<>();
	
	private RestTemplate restTemplate;
	
	protected AbstractBitlyTemplate( RestTemplate restTemplate ) {
		this.restTemplate = restTemplate;
	}
	
	protected URI buildUri( String path ){		
		return buildUri( path, EMPTY_PARAMETERS );
	}
	
	protected URI buildUri( String path, MultiValueMap<String, String> parameters ){		
		return URIBuilder.fromUri( BITLY_API_URL  + BITLY_API_VERSION + path ).queryParams( parameters ).build();
	}
		
	protected <T> BitlyResponse<T> invoke( String uri, MultiValueMap<String, String> parameters, Class<? extends BitlyResponse<T>> responseClass ){
		return (BitlyResponse<T>) restTemplate.getForObject( buildUri( uri, parameters ), responseClass );
	}
}
