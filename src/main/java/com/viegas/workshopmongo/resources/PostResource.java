package com.viegas.workshopmongo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viegas.workshopmongo.dto.PostDTO;
import com.viegas.workshopmongo.services.PostService;
import com.viegas.workshopmongo.util.URL;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	private final PostService postService;
	
	public PostResource(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id){
		PostDTO dto = postService.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<PostDTO>> findByTitle(
			@RequestParam(value="text", defaultValue ="") String text
			){
		
		text = URL.decodeParam(text);
		
		List<PostDTO> list = postService.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
	}

}
