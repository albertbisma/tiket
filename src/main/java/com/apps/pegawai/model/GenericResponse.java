package com.apps.pegawai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "responseCode", "responseDesc" })
public class GenericResponse {
	@JsonProperty("responseDesc")
	private String responseDesc;

	@JsonProperty("responseCode")
	private String responseCode;

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
}
