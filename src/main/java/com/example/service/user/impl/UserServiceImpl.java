package com.example.service.user.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dto.response.user.UsuarioResponse;
import com.example.persistence.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
	@Override
	public List<UsuarioResponse> getAllUsers() {
		   // Convierte el Iterable<User> en un Stream<User>
	    Stream<User> userStream = StreamSupport.stream(userRepository.findAll().spliterator(), false);

	    // Mapea y recolecta los usuarios en una lista de UsuarioResponse
	    List<UsuarioResponse> allUsers = userStream
	            .map(usuario -> new UsuarioResponse(usuario.getFirstName(), usuario.getLastName(), usuario.getEmail(), usuario.getRoles().toString()))
	            .collect(Collectors.toList());

	    return allUsers;
	}
}
