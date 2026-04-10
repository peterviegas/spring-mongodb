package com.viegas.workshopmongo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.viegas.workshopmongo.dto.UserDTO;
import com.viegas.workshopmongo.resources.UserResource;
import com.viegas.workshopmongo.services.UserService;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserResource.class)
public class MeuControllerTest {
	
	@Autowired
	private MockMvc mocktest;
	
	@MockBean
	private UserService service;
	

	@Test
	void retornaOk() throws Exception {
		mocktest.perform(get("/users"))
		.andExpect(status().isOk());
	}
	
	@Test
    void deveRetornarUsuarioPorId() throws Exception {

        // Arrange
        UserDTO dto = new UserDTO("123", "Peter", "peter@mail.com", null);
        Mockito.when(service.findById("123")).thenReturn(dto);

        // Act + Assert
        mocktest.perform(get("/users/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.name").value("Peter"))
                .andExpect(jsonPath("$.email").value("peter@mail.com"));
    }
}
