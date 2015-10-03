package org.springframework.social.bitly.connect;

import org.springframework.social.bitly.api.Bitly;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

public class BitlyConnectionFactory extends OAuth2ConnectionFactory<Bitly>   {

	public BitlyConnectionFactory( String clientId, String secretId ) {
		super( "bitly", new BitlyServiceProvider( clientId, secretId ), new BitlyAdapter() );
	}

	
}
