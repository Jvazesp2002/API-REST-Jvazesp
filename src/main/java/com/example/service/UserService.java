package com.example.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.persistence.User;

public interface UserService {
UserDetailsService userDetailsService();
	
    List<User> getAllUsers();

    User getUserById(Long id);

    User addUser(User usuario);

    User updateUser(Long id, User usuario);

    void deleteUser(Long id);
}
