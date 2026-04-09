package com.viegas.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.viegas.workshopmongo.domain.User;
import com.viegas.workshopmongo.dto.UserDTO;
import com.viegas.workshopmongo.mapper.UserMapper;
import com.viegas.workshopmongo.repository.UserRepository;
import com.viegas.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class UserService {
	
	private final UserRepository repo;
	
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<UserDTO> findAll() {
		List<User> users = repo.findAll();
		return users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	public UserDTO findById(String id) {
		User user = repo.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		return new UserDTO(user);
	}
	
	public UserDTO create(UserDTO dto) {
		
		User user = repo.insert(UserMapper.toEntity(dto));
		
		return new UserDTO(user);
	}
}
