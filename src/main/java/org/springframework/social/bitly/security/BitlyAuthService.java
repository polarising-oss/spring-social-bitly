package org.springframework.social.bitly.security;

import org.springframework.social.bitly.api.Bitly;
import org.springframework.social.bitly.connect.BitlyConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class BitlyAuthService extends OAuth2AuthenticationService<Bitly> {

	public BitlyAuthService(  String clientId, String secretId, String username, String password  ) {
		super( new BitlyConnectionFactory( clientId, secretId, username, password ) );
	}
}
