package org.springframework.social.bitly.connect;

import org.springframework.social.bitly.api.Bitly;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class BitlyServiceProvider extends AbstractOAuth2ServiceProvider<Bitly> {

	public BitlyServiceProvider( String clientId, String secretId ) {
		super( getOAuth2Template( clientId, secretId ));
	}

	private static OAuth2Template getOAuth2Template(  String clientId, String secretId ) {
		OAuth2Template oAuth2Template = new OAuth2Template( clientId, secretId,
				"https://api-ssl.bitly.com/oauth/access_token",
				"https://api-ssl.bitly.com/oauth/access_token");
		oAuth2Template.setUseParametersForClientAuthentication( Boolean.FALSE );
		return oAuth2Template;
	}
	
	@Override
	public Bitly getApi(String accessToken) {
		// TODO Auto-generated method stub
		return null;
	}

}
