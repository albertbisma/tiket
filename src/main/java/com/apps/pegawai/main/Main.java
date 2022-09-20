package com.apps.pegawai.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication (scanBasePackages = {"com.apps.pegawai"})
@EnableAutoConfiguration
@EnableJpaRepositories("com.apps.pegawai.repository")
@EnableTransactionManagement
@ComponentScan("com.apps.pegawai")
@EntityScan(basePackages = "com.apps.pegawai.entity")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
