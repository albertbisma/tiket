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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.apps.pegawai.entity.Pegawai;
import com.apps.pegawai.service.PegawaiService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@AutoConfigureMockMvc
public class PegawaiGetControllerTest {
	@MockBean
	private PegawaiService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void whenFindByIdIsFound_expect200() throws Exception {
		Mockito.when(service.findById(Mockito.any(BigInteger.class))).thenReturn(generateResponse());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/pegawai?userId=1"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andExpect(MockMvcResultMatchers.content().json("{\r\n" + 
			   		"  \"pegawai\": {\r\n" + 
			   		"    \"userId\": 1,\r\n" + 
			   		"    \"nama\": \"User for Testing\",\r\n" + 
			   		"    \"alamat\": \"JL. Alamat Testing 123\"\r\n" + 
			   		"  }\r\n" + 
			   		"}"));
	}
	
	@Test
	public void whenFindByIdIsNotFound_expect404() throws Exception {
		Mockito.when(service.findById(Mockito.any(BigInteger.class))).thenThrow(NoSuchElementException.class);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/pegawai?userId=3"))
			   .andExpect(MockMvcResultMatchers.status().isNotFound())
			   .andExpect(MockMvcResultMatchers.content().json("{\r\n" + 
			   		"  \"GenericResponse\": {\r\n" + 
			   		"    \"responseCode\": \"Not Found\",\r\n" + 
			   		"    \"responseDesc\": \"Data is not found.\"\r\n" + 
			   		"  }\r\n" + 
			   		"}"));
	}
	
	@Test
	public void whenFindByIdIsEmpty_expect400() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pegawai?userId="))
			   .andExpect(MockMvcResultMatchers.status().isBadRequest())
			   .andExpect(MockMvcResultMatchers.content().json("{\r\n" + 
			   		"  \"GenericResponse\": {\r\n" + 
			   		"    \"responseCode\": \"Bad Request\",\r\n" + 
			   		"    \"responseDesc\": \"Field userId is mandatory.\"\r\n" + 
			   		"  }\r\n" + 
			   		"}"));
	}
	
	@Test
	public void whenFindByIdIsNull_expect400() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pegawai"))
			   .andExpect(MockMvcResultMatchers.status().isBadRequest())
			   .andExpect(MockMvcResultMatchers.content().json("{\r\n" + 
			   		"  \"GenericResponse\": {\r\n" + 
			   		"    \"responseCode\": \"Bad Request\",\r\n" + 
			   		"    \"responseDesc\": \"Field userId is mandatory.\"\r\n" + 
			   		"  }\r\n" + 
			   		"}"));
	}
	
	private Pegawai generateResponse() {
		Pegawai pegawai = new Pegawai();
		pegawai.setUserId(BigInteger.ONE);
		pegawai.setNama("User for Testing");
		pegawai.setAlamat("JL. Alamat Testing 123");
		return pegawai;
	}

}
