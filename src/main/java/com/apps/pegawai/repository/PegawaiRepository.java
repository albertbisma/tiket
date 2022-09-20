package com.apps.pegawai.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apps.pegawai.entity.Pegawai;

@Transactional
@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai, BigInteger> {

}
