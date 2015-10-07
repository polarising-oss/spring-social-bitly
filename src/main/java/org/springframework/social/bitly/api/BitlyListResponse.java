package org.springframework.social.bitly.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitlyListResponse {

	@JsonProperty( "data"  )
	//TODO: Mapping data to list
	private Object data;
	
	@JsonProperty( "status_code" )
	private int statusCode;
	
	@JsonProperty( "status_txt" )
	private String statusTxt;
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusTxt() {
		return statusTxt;
	}
	public void setStatusTxt(String statusTxt) {
		this.statusTxt = statusTxt;
	}
}
