package com.viegas.workshopmongo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viegas.workshopmongo.domain.User;
import com.viegas.workshopmongo.dto.UserDTO;
import com.viegas.workshopmongo.repository.UserRepository;
import com.viegas.workshopmongo.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    private User user;
    
    @BeforeEach
    void setup() {
        user = new User("123", "Peter", "peter@mail.com");
    }
    
    @Test
    void deveRetornarUsuarioPorId() {
        // Arrange
        when(repository.findById("123"))
                .thenReturn(Optional.of(user));

        // Act
        UserDTO resultado = service.findById("123");

        // Assert
        assertEquals("123", resultado.getId());
        assertEquals("Peter", resultado.getName());
        assertEquals("peter@mail.com", resultado.getEmail());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoEncontrado() {
        // Arrange
        when(repository.findById("999"))
                .thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(RuntimeException.class, () -> {
            service.findById("999");
        });
    }

}
