package org.springframework.social.bitly.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewBitlyResponse<T> {
	@JsonProperty( "data"  )
	//TODO: Mapping data to list
	private T data;
	
	@JsonProperty( "status_code" )
	private int statusCode;
	
	@JsonProperty( "status_txt" )
	private String statusTxt;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
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
