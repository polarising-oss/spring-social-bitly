package org.springframework.social.bitly.api.impl;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.ApiBinding;
import org.springframework.social.bitly.api.BitlyModule;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author bramos
 *
 */
public class BitlyTemplate extends AbstractOAuth2ApiBinding implements ApiBinding {
	
	private ObjectMapper objectMapper;
	
	public BitlyTemplate( String accessToken ) {
		super( accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER );
		//TODO: config rest template to set access token
	}	
	
	@Override
	protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
		objectMapper = new ObjectMapper();				
		objectMapper.registerModule(new BitlyModule());
		converter.setObjectMapper( objectMapper );		
		return converter;
	}
}
