package org.springframework.social.bitly.api.impl;

import java.util.List;

import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.LinkOperations;
import org.springframework.social.bitly.api.impl.json.LinkExpandResponse;
import org.springframework.social.bitly.api.impl.json.LinkInfoResponse;
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
		
	
	@Override
	public List<Link> expand(List<String> shortUrl, List<String> hash) {	
		return invoke("expand", buildShortUrlHashMap(shortUrl, hash), LinkExpandResponse.class );
	}	
	
	@Override
	public List<Link> info(List<String> shortUrl, List<String> hash) {
		return invoke("info", buildShortUrlHashMap(shortUrl, hash), LinkInfoResponse.class );
	}
}
