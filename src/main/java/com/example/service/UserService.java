package com.example.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.dto.response.user.UsuarioResponse;

public interface UserService {
    UserDetailsService userDetailsService();
    List<UsuarioResponse> getAllUsers();
}
