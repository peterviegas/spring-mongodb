package com.viegas.workshopmongo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

//@DataJpaTest
@DataMongoTest
public class MeuRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void deveBuscarDados() {
		userRepository.findAll();
	}

	@Test
	void deveBuscarDadosId() {
		userRepository.findById("123");
	}
}
