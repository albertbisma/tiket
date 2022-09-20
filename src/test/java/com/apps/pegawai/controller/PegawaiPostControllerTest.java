package com.apps.pegawai.controller;

import java.math.BigInteger;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.apps.pegawai.entity.Pegawai;
import com.apps.pegawai.model.PegawaiRequest;
import com.apps.pegawai.service.PegawaiService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@AutoConfigureMockMvc
public class PegawaiPostControllerTest {
	@MockBean
	private PegawaiService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void whenInsertWithValidRequest_expect200() throws Exception {
		Mockito.when(service.insert(generateRequest("Mario Waringin", "JL. Apel No.20"))).thenReturn(new Pegawai());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/pegawai")
				   .contentType(MediaType.APPLICATION_JSON_UTF8)
				   .content(new ObjectMapper().writeValueAsString(generateRequest("Mario Waringin", "JL. Apel No.20"))))
			   .andExpect(MockMvcResultMatchers.status().isCreated())
			   .andExpect(MockMvcResultMatchers.content().json("{\r\n" + 
			   		"  \"GenericResponse\": {\r\n" + 
			   		"    \"responseCode\": \"Created\",\r\n" + 
			   		"    \"responseDesc\": \"Data has been saved successfully\"\r\n" + 
			   		"  }\r\n" + 
			   		"}"));
	}
	
	@Test
	public void whenInsertWithNamaIsEmpty_expect400() throws Exception {
		Mockito.when(service.insert(generateRequest("", "JL. Apel No.20"))).thenReturn(new Pegawai());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/pegawai")
				   .contentType(MediaType.APPLICATION_JSON_UTF8)
				   .content(new ObjectMapper().writeValueAsString(generateRequest("", "JL. Apel No.20"))))
			   .andExpect(MockMvcResultMatchers.status().isBadRequest())
			   .andExpect(MockMvcResultMatchers.content().json("{\r\n" + 
			   		"  \"GenericResponse\": {\r\n" + 
			   		"    \"responseCode\": \"Bad Request\",\r\n" + 
			   		"    \"responseDesc\": \"Field nama is mandatory.\"\r\n" + 
			   		"  }\r\n" + 
			   		"}"));
	}
	
	@Test
	public void whenInsertWithAlamatIsEmpty_expect400() throws Exception {
		Mockito.when(service.insert(generateRequest("Mario Waringin", ""))).thenReturn(new Pegawai());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/pegawai")
				   .contentType(MediaType.APPLICATION_JSON_UTF8)
				   .content(new ObjectMapper().writeValueAsString(generateRequest("Mario Waringin", ""))))
			   .andExpect(MockMvcResultMatchers.status().isBadRequest())
			   .andExpect(MockMvcResultMatchers.content().json("{\r\n" + 
			   		"  \"GenericResponse\": {\r\n" + 
			   		"    \"responseCode\": \"Bad Request\",\r\n" + 
			   		"    \"responseDesc\": \"Field alamat is mandatory.\"\r\n" + 
			   		"  }\r\n" + 
			   		"}"));
	}
	
	private PegawaiRequest generateRequest(String nama, String alamat) {
		PegawaiRequest request = new PegawaiRequest();		
		request.setNama(nama);
		request.setAlamat(alamat);
		return request;
	}

}
