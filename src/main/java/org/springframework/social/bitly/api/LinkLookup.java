package org.springframework.social.bitly.api;

public class LinkLookup {
	
	private String url;
	
	private String shortUrl;
	
	public LinkLookup() {
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
