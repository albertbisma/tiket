package com.apps.pegawai;

import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication (scanBasePackages = {"com.apps.pegawai"})
//@EnableJpaRepositories("com.apps.pegawai.repository")
@ComponentScan("com.apps.pegawai")
@EntityScan("com.apps.pegawai.entity")
public class PegawaiApplicationTests {
	
	public PegawaiApplicationTests() {
		
	}
	
	@Test
	public void contextLoads() {
	}

}
