package com.viegas.workshopmongo.services;


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
	
	
}
