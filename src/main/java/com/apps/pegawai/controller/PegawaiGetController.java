package com.apps.pegawai.controller;

import java.math.BigInteger;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.apps.pegawai.entity.Pegawai;
import com.apps.pegawai.model.GenericResponse;
import com.apps.pegawai.model.PegawaiResponse;
import com.apps.pegawai.service.PegawaiService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Get Data Pegawai By Id", tags = "Get Data Pegawai By Id")
@RequestMapping("pegawai")
public class PegawaiGetController {
	
	@Autowired
	private PegawaiService pegawaiService;
	
	@GetMapping("")
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<PegawaiResponse> getById(@RequestParam(required = false) BigInteger userId){
		Pegawai pegawai = new Pegawai();
		PegawaiResponse response = new PegawaiResponse();
		
		if(userId == null || StringUtils.isEmpty(userId)) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field userId is mandatory."));
		}
		
		try {
			pegawai = pegawaiService.findById(userId);
			
			response.setGenericResponse(null);
			response.setPegawai(pegawai);
		} catch (NoSuchElementException e) {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Data is not found."));
		}	
		
		return ResponseEntity.ok().body(response);
	}


	private PegawaiResponse  generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		PegawaiResponse response = new PegawaiResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
	}			
}
