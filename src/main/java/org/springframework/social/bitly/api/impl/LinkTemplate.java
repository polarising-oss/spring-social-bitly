package org.springframework.social.bitly.api.impl;

import java.util.List;

import org.springframework.social.bitly.api.LinkLookup;
import org.springframework.social.bitly.api.LinkOperations;
import org.springframework.social.bitly.api.impl.json.BitlyResponse;
import org.springframework.social.bitly.api.impl.json.LinkExpandResponse;
import org.springframework.social.bitly.api.impl.json.LinkInfoResponse;
import org.springframework.social.bitly.api.impl.json.LinkLookupResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class LinkTemplate extends AbstractBitlyTemplate implements LinkOperations {

	
	public LinkTemplate( RestTemplate restTemplate ) {
		super(restTemplate);
	}
	
	private MultiValueMap<String, String> buildShortUrlHashMap(List<String> shortUrl, List<String> hash){
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.put( "shortUrl", shortUrl );
		parameters.put( "hash", hash );
		return parameters;
	}
	
	private MultiValueMap<String, String> buildUrlHashMap( String name, List<String> property ){
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>( 1 );
		parameters.put( name, property );
		return parameters;
	}
	
	@Override
	public LinkExpandResponse expand(List<String> shortUrl, List<String> hash) {	
		return (LinkExpandResponse) invoke("expand", buildShortUrlHashMap(shortUrl, hash), LinkExpandResponse.class );
	}	
	
	@Override
	public LinkInfoResponse info(List<String> shortUrl, List<String> hash) {
		return (LinkInfoResponse) invoke("info", buildShortUrlHashMap(shortUrl, hash), LinkInfoResponse.class );
	}
	
	@Override
	public LinkLookupResponse lookup(List<String> urls) {
		return (LinkLookupResponse) invoke("link/lookup", buildUrlHashMap( "url", urls ), LinkLookupResponse.class );
	}
}