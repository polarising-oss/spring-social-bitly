package org.springframework.social.bitly.connect;

import org.springframework.social.bitly.api.Bitly;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class BitlyAdapter implements ApiAdapter<Bitly>{

	public BitlyAdapter() {
		
	}

	@Override
	public boolean test(Bitly api) {
		return false;
	}

	@Override
	public void setConnectionValues(Bitly api, ConnectionValues values) {
		
	}

	@Override
	public UserProfile fetchUserProfile(Bitly api) {
		return null;
	}

	@Override
	public void updateStatus(Bitly api, String message) {
	}	
}