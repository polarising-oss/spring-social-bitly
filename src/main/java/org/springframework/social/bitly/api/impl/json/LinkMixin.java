package org.springframework.social.bitly.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkMixin {
	
	@JsonProperty( "short_url" )
	private String shortUrl;
	
	@JsonProperty( "hash" )	
	private String hash;
	
	@JsonProperty( "user_hash" )
	private String userHash;
	
	@JsonProperty( "global_hash" )
	private String globalHash;
	
	@JsonProperty( "error" )
	private String error;
	
	@JsonProperty( "long_url" )
	private String longUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getUserHash() {
		return userHash;
	}

	public void setUserHash(String userHash) {
		this.userHash = userHash;
	}

	public String getGlobalHash() {
		return globalHash;
	}

	public void setGlobalHash(String globalHash) {
		this.globalHash = globalHash;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
}
