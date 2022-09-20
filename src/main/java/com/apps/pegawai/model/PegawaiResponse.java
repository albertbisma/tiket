package com.apps.pegawai.model;

import com.apps.pegawai.entity.Pegawai;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({"GenericResponse", "pegawai"})
@JsonInclude(Include.NON_NULL)
public class PegawaiResponse extends BaseResponse{
	private Pegawai pegawai;

	public Pegawai getPegawai() {
		return pegawai;
	}

	public void setPegawai(Pegawai pegawai) {
		this.pegawai = pegawai;
	}
	
}
