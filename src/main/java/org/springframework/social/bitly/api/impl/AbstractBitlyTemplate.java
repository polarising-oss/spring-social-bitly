package org.springframework.social.bitly.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public abstract class AbstractBitlyTemplate {

	private static final String BITLY_API_URL = "https://api-ssl.bitly.com";
	private static final  String BITLY_API_VERSION = "/v3/";
		
	private static final MultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<>();
	
	protected AbstractBitlyTemplate() {
	}
	
	protected URI buildUri( String path ){		
		return buildUri( path, EMPTY_PARAMETERS );
	}
	
	protected URI buildUri( String path, MultiValueMap<String, String> parameters ){		
		return URIBuilder.fromUri( BITLY_API_URL  + BITLY_API_VERSION + path ).queryParams( parameters ).build();
	}
}
