package org.springframework.social.bitly;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;

@RunWith( BlockJUnit4ClassRunner.class )
public class OAuthTest {

	
	@Test
	public void oauth(){
		
		//Get an access token for app springsocial
		//client_id: f1acf1900a60d528d04fb8f4664537f25b64f6c9
		//client secret: ec133ac4d50d54d71ad841f2e3f2be30d42befe4
		OAuth2Template oAuth2Template = new OAuth2Template( "f1acf1900a60d528d04fb8f4664537f25b64f6c9", "ec133ac4d50d54d71ad841f2e3f2be30d42befe4",
				"https://api-ssl.bitly.com/oauth/access_token",
				"https://api-ssl.bitly.com/oauth/access_token");
		oAuth2Template.setUseParametersForClientAuthentication( false );
		AccessGrant ag =  oAuth2Template.exchangeCredentialsForAccess( "brunoramos", "bramos2015", null );
		System.out.println( ag.getAccessToken() );
	}
}