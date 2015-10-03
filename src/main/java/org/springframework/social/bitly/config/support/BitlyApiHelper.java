package org.springframework.social.bitly.config.support;

import org.springframework.social.bitly.api.Bitly;
import org.springframework.social.config.xml.ApiHelper;

public class BitlyApiHelper implements ApiHelper<Bitly>{

	public BitlyApiHelper() {
		
	}
	
	@Override
	public Bitly getApi() {
		return null;
	}
}