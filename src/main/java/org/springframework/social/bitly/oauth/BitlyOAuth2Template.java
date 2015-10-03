package org.springframework.social.bitly.oauth;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

public class BitlyOAuth2Template extends OAuth2Template {

	public BitlyOAuth2Template( String clientId, String clientSecret, String authorizeUrl ) {
		super(clientId, clientSecret, authorizeUrl, authorizeUrl);
	}
	
	@Override
	public AccessGrant exchangeCredentialsForAccess(String username, String password, MultiValueMap<String, String> additionalParameters) {
		setUseParametersForClientAuthentication( false );
		return super.exchangeCredentialsForAccess(username, password, additionalParameters);
	}
}
