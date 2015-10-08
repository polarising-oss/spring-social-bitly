package org.springframework.social.bitly.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.bitly.api.impl.json.BitlyResponse;
import org.springframework.social.bitly.api.impl.json.ListResponse;
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
	
	@SuppressWarnings("unchecked")
	protected <T> List<T> parseListResponse( BitlyResponse response ){
		if( !response.ok() ){
			//TODO: review this Exception
			throw new RuntimeException( "Invalid request with code [" + response.getStatusCode() + "] and text [" + response.getStatusTxt() + "]" );	
		}
		return ((ListResponse<T>)response).getData();
	}
	
	protected <T> List<T> invoke( String uri, MultiValueMap<String, String> parameters, Class<? extends BitlyResponse > responseClass ){
		BitlyResponse response = (BitlyResponse) restTemplate.getForObject( buildUri( uri, parameters ), responseClass );
		return parseListResponse(response);
	}
}
