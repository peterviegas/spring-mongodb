package com.viegas.workshopmongo.mapper;

import com.viegas.workshopmongo.domain.Post;
import com.viegas.workshopmongo.dto.PostDTO;

public class PostMapper {
	
	public static PostDTO toDTO (Post post) {
		return new PostDTO (
				post.getId(),
				post.getDate(),
				post.getTitle(),
				post.getBody(),
				post.getAuthor(),
				post.getComments()
			);
				
	}
	
	public static Post toEntity (PostDTO dto) {
		return new Post (
				dto.getId(),
				dto.getDate(),
				dto.getTitle(),
				dto.getBody(),
				dto.getAuthor()
			);
				
	}

}
