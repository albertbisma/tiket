package com.apps.pegawai.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.pegawai.entity.Pegawai;
import com.apps.pegawai.model.PegawaiRequest;
import com.apps.pegawai.repository.PegawaiRepository;

@Service
public class PegawaiService {
	
	@Autowired
	private PegawaiRepository pegawaiRepository;
	
	public Pegawai findById(BigInteger userId) {
		return pegawaiRepository.findById(userId).get();
	}		
	
	public Pegawai insert(PegawaiRequest request) {
		System.out.println("");
		return pegawaiRepository.save(new Pegawai(request.getNama(), request.getAlamat()));
	}
}
