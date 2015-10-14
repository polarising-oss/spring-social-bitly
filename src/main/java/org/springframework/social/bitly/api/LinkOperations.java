package org.springframework.social.bitly.api;

import java.util.List;

public interface LinkOperations {

	List<Link> expand( List<String> shortUrl, List<String> hash  );
	
	List<Link> info( List<String> shortUrl, List<String> hash );
	
	
	NewBitlyResponse<List<Link>> expand2( List<String> shortUrl, List<String> hash  );
}
