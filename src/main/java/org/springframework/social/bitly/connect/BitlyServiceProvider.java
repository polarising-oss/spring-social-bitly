package org.springframework.social.bitly.connect;

import org.springframework.social.bitly.api.Bitly;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class BitlyServiceProvider extends AbstractOAuth2ServiceProvider<Bitly> {

	public BitlyServiceProvider( String clientId, String secretId, String username, String password ) {
		super( getOAuth2Template( clientId, secretId, username, password ));
	}

	private static OAuth2Template getOAuth2Template( String clientId, String secretId, String username, String password ) {
		OAuth2Template oAuth2Template = new OAuth2Template( clientId, secretId,
				Bitly.BITLY_OAUTH_URL,
				Bitly.BITLY_OAUTH_ACCESS_TOKEN_URL );
		return oAuth2Template;
	}
	
	@Override
	public Bitly getApi(String accessToken) {
		return null;
	}

}
