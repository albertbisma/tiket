package com.apps.pegawai.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponse {	
	
	@JsonProperty("GenericResponse")
	private GenericResponse genericResponse;
	
	public void setGenericResponse(GenericResponse genericResponse) {
		this.genericResponse = genericResponse;
	}
	
	public GenericResponse getGenericResponse() {
		return genericResponse;
	}
}
