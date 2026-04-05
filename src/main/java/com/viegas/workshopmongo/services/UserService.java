package com.viegas.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.viegas.workshopmongo.domain.User;
import com.viegas.workshopmongo.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
	
	private final UserRepository repo;
	
	@Autowired
	MongoTemplate mongoTemplate;

	public void test() {
	    System.out.println("DB conectado: " + mongoTemplate.getDb().getName());
	}
	
	@Value("${teste.config}")
	private String teste;

	
	@Autowired
	Environment env;

	@PostConstruct
	public void debugConfig() {
	    System.out.println("URI carregada: " + env.getProperty("spring.data.mongodb.uri"));
	}

	
	
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> findAll(){
		System.out.println("Chegou na chamanda ....................................");
		
		debugConfig();
		
		System.out.println("CONFIG: " + teste);
		
		System.out.println("DB conectado: " + mongoTemplate.getDb().getName());
		
		System.out.println("Count: " + repo.count());
		
		List<User> users = repo.findAll();
		
		for(User u: users) {
			System.out.println(u.getEmail());
		}
		return repo.findAll();
	}
}
