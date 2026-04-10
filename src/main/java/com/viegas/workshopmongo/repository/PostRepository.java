package com.viegas.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.viegas.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
