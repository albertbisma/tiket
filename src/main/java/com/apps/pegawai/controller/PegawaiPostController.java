package com.apps.pegawai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.pegawai.model.GenericResponse;
import com.apps.pegawai.model.PegawaiRequest;
import com.apps.pegawai.model.PegawaiResponse;
import com.apps.pegawai.service.PegawaiService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Insert Data Pegawai With Method POST", tags = "Insert Data Pegawai With Method POST")
@RequestMapping("pegawai")
public class PegawaiPostController {
	
	@Autowired
	private PegawaiService pegawaiService;
	
	@PostMapping("")
	public ResponseEntity<PegawaiResponse> insert(@RequestBody PegawaiRequest request){
		
		if(request.getNama().isEmpty()) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field nama is mandatory."));
		}
		
		if (request.getAlamat().isEmpty()) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field alamat is mandatory."));
		}
		
		try {
			pegawaiService.insert(request);
		} catch (Exception e) {			
			throw e;
		}			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generateResponse(HttpStatus.CREATED.getReasonPhrase(), "Data has been saved successfully"));
	}

	private PegawaiResponse generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		PegawaiResponse response = new PegawaiResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
		
	}
}
