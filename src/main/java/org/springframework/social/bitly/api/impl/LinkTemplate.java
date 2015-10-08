package org.springframework.social.bitly.api.impl;

import java.util.List;

import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.LinkOperations;
import org.springframework.social.bitly.api.impl.json.LinkExpandResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class LinkTemplate extends AbstractBitlyTemplate implements LinkOperations {

	private RestTemplate restTemplate;

	
	public LinkTemplate( RestTemplate restTemplate ) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<Link> expand(List<String> shortUrl, List<String> hash) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.put( "shortUrl", shortUrl );
		parameters.put( "hash", hash );
		LinkExpandResponse response = restTemplate.getForObject( buildUri( "expand", parameters ), LinkExpandResponse.class );
		if( !response.ok() ){
			//TODO: review this Exception
			throw new RuntimeException( "Invalid request with code [" + response.getStatusCode() + "] and text [" + response.getStatusTxt() + "]" );	
		}
		return response.getExpand();
	}	
}
