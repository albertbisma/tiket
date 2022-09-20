package com.apps.pegawai.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pegawai")
public class Pegawai {
	public Pegawai() {
		
	}
	
	public Pegawai (String nama, String alamat) {
		this.nama = nama;
		this.alamat = alamat;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private BigInteger userId;
	
	@Column(name = "nama")	
	private String nama;
	
	@Column(name="alamat")
	private String alamat;

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
}
