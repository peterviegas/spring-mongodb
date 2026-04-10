package com.viegas.workshopmongo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viegas.workshopmongo.dto.PostDTO;
import com.viegas.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	private final PostService postService;
	
	public PostResource(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id){
		System.out.println("chegou aqui");
		PostDTO dto = postService.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}

}
