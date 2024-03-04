package com.example.service.user;

import com.example.dto.request.SigninRequest;
import com.example.dto.request.SignupRequest;
import com.example.dto.response.user.JwtAuthenticationResponse;

public interface AuthenticationService {
	/** REGISTRO */
    JwtAuthenticationResponse signup(SignupRequest request);
    /** ACCESO a Token JWT */
    JwtAuthenticationResponse signin(SigninRequest request);
}
