package org.springframework.social.bitly;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;

@RunWith( BlockJUnit4ClassRunner.class )
public class OAuthTest {

	private final static String BITLY_CLIENT_ID = "CLIENT_ID";
	
	private final static String BITLY_CLIENT_SECRET = "CLIENT_SECRET";
	
	private final static String BITLY_USERNAME = "USERNAME";
	
	private final static String BITLY_PASSWORD = "PASSWORD";
	
	
	private final static String BITLY_OAUTH_URL = "https://api-ssl.bitly.com/";
	private final static String BITLY_OAUTH_ACCESS_TOKEN = "https://api-ssl.bitly.com/oauth/access_token";
	
	/**
	 * Testing Bitly Resource Owner Credentials Grants flow
	 * 
	 * http://tools.ietf.org/html/rfc6749#section-4.3
	 */
	@Test
	public void bitlyROPCG(){
		OAuth2Template oAuth2Template = new OAuth2Template( BITLY_CLIENT_ID, BITLY_CLIENT_SECRET, BITLY_OAUTH_URL, BITLY_OAUTH_ACCESS_TOKEN );
		AccessGrant ag =  oAuth2Template.exchangeCredentialsForAccess( BITLY_USERNAME, BITLY_PASSWORD, null );
		Assert.assertNotNull( ag.getAccessToken() ); 
	}	
}