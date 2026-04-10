package com.viegas.workshopmongo.services;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.viegas.workshopmongo.domain.Post;
import com.viegas.workshopmongo.dto.PostDTO;
import com.viegas.workshopmongo.mapper.PostMapper;
import com.viegas.workshopmongo.repository.PostRepository;
import com.viegas.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class PostService {
	
	private final PostRepository repo;
	
	public PostService(PostRepository repo) {
		this.repo = repo;
	}
	
	
	public PostDTO findById(String id) {
		Post post = repo.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		return PostMapper.toDTO(post);
	}
	
	public List<PostDTO> findByTitle(String text){
		List<Post> posts = repo.findByTitleContainingIgnoreCase(text);
		return posts.stream()
				.map(PostMapper::toDTO)
				.toList();
	}
	
	public List<PostDTO> titleSearc(String text){
		List<Post> posts = repo.findByTitle(text);
		return posts.stream()
				.map(PostMapper::toDTO)
				.toList();
	}
	
	public List<PostDTO> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
		
		maxDate = maxDate.plusDays(1);
		
		List<Post> posts = repo.fullSearch(text, minDate, maxDate);
	    
	    return posts.stream()
	            .map(PostMapper::toDTO)
	            .toList();
	}
}
