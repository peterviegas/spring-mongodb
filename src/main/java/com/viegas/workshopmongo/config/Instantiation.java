package com.viegas.workshopmongo.config;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viegas.workshopmongo.domain.Post;
import com.viegas.workshopmongo.domain.User;
import com.viegas.workshopmongo.dto.AuthorDTO;
import com.viegas.workshopmongo.repository.PostRepository;
import com.viegas.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final PostRepository postRepository;
	
	public Instantiation ( UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		LocalDate d1 = LocalDate.now();
		
		Post post1 = new Post(null, d1 , "go travel", "I am going to France, bye!", new AuthorDTO( maria));
		Post post2 = new Post(null, d1 , "Good morning", "I woke up happy!", new AuthorDTO( maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
