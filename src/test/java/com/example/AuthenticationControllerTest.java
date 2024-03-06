package com.example;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.controller.user.AuthenticationController;
import com.example.dto.request.SigninRequest;
import com.example.dto.request.SignupRequest;
import com.example.dto.response.user.JwtAuthenticationResponse;
import com.example.service.user.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AuthenticationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
    }

    @Test
    void testSignup() throws Exception {
        SignupRequest request = new SignupRequest();
        
        JwtAuthenticationResponse response = new JwtAuthenticationResponse("token");
        doReturn(response).when(authenticationService).signup(any());
        
        mockMvc.perform(post("/auth/signup")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(request)))
            .andExpect(status().isOk());
    }

    @Test
    void testSignin() throws Exception {
        SigninRequest request = new SigninRequest();
        
        JwtAuthenticationResponse response = new JwtAuthenticationResponse("token");
        doReturn(response).when(authenticationService).signin(any());
        
        mockMvc.perform(post("/auth/signin")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(request)))
            .andExpect(status().isOk());
    }
}