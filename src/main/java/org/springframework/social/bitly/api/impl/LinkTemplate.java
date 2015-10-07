package org.springframework.social.bitly.api.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.social.bitly.api.BitlyListResponse;
import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.LinkOperations;
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
//		{
//			  "data": {
//			    "link_lookup": [
//			      {
//			        "aggregate_link": "http://bit.ly/2V6CFi", 
//			        "url": "http://www.google.com/"
//			      }
//			    ]
//			  }, 
//			  "status_code": 200, 
//			  "status_txt": "OK"
//			}
		//TODO: Create generic response object
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.put( "shortUrl", shortUrl );
		parameters.put( "hash", hash );
		BitlyListResponse response = restTemplate.getForObject( buildUri( "expand", parameters ), BitlyListResponse.class );
		System.out.println( response.getStatusCode() );
		System.out.println( response.getStatusTxt() );
		System.out.println( response.getData() );
		
		return Collections.EMPTY_LIST;
		
	}
	
	@SuppressWarnings("serial")
	private static class LinkList extends ArrayList<Link> {}
}
