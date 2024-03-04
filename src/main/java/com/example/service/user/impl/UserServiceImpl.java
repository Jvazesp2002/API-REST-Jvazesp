package com.example.service.user.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.persistence.User;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private com.example.repository.UserRepository UserRepository;

    @Override
    public List<User> getAllUsers() {
        // Convierte el Iterable a List usando el constructor de ArrayList
        return StreamSupport.stream(UserRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        return UserRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return UserRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User User) {
        User existingUser = UserRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Verifica si los campos no son nulos antes de actualizar
            if (User.getFirstName() != null) {
                existingUser.setFirstName(User.getFirstName());
            }
            if (User.getLastName() != null) {
                existingUser.setLastName(User.getLastName());
            }
            if (User.getPassword() != null) {
                existingUser.setPassword(User.getPassword());
            }
            if (User.getEmail() != null) {
                existingUser.setEmail(User.getEmail());
            }
            if (User.getRoles() != null) {
                existingUser.setRoles(User.getRoles());
            }

            // Guarda el User actualizado en el repositorio
            return UserRepository.save(existingUser);
        } else {
            // Manejar el caso en que el User no exista
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return UserRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
