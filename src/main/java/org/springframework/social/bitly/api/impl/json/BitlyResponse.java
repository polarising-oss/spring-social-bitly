package org.springframework.social.bitly.api.impl.json;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "status_code", "status_txt" })
public abstract class BitlyResponse {

	@JsonProperty("status_code")
	private int statusCode;

	@JsonProperty("status_txt")
	private String statusTxt;

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

	public boolean ok() {
		return HttpStatus.OK.value() == statusCode;
	}
}
