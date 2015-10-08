package org.springframework.social.bitly.api.impl.json;

import java.util.Date;

import org.springframework.social.bitly.api.impl.json.deserializers.EpochTimestampDeserializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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

	@JsonProperty( "created_at" )
	@JsonDeserialize(using=EpochTimestampDeserializer.class)
	private Date createdAt;
	
	@JsonProperty( "created_by" )
	private String createdBy;
	
	@JsonProperty( "title" )
	private String title;
	
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
