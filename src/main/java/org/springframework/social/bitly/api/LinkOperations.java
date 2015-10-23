package org.springframework.social.bitly.api;

import java.util.List;

import org.springframework.social.bitly.api.impl.json.BitlyResponse;

public interface LinkOperations {

	BitlyResponse<List<Link>> expand( List<String> shortUrl, List<String> hash  );
	
	BitlyResponse<List<Link>> info( List<String> shortUrl, List<String> hash  );
}
