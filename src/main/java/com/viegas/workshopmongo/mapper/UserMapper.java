package com.viegas.workshopmongo.mapper;

import com.viegas.workshopmongo.domain.User;
import com.viegas.workshopmongo.dto.UserDTO;

public class UserMapper {
	
	public static UserDTO toDTO (User user) {
		return new UserDTO (
				user.getId(),
				user.getName(),
				user.getEmail()
			);
	}
	
	public static User toEntity (UserDTO dto) {
		return new User (
				dto.getId(),
				dto.getName(),
				dto.getEmail()
			);
	}
}
