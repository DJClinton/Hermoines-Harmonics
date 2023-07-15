package com.estore.api.estoreapi.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;

import com.estore.api.estoreapi.persistence.UserFileDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationControllerTest {
  ObjectMapper mockObjectMapper;
  AuthenticationManager mockAuthenticationManager;
  UserFileDAO mockUserFileDAO;
  JwtUtil mockJwtUtil;

  AuthenticationController authenticationController;

  @BeforeEach
  public void setup() {
    mockObjectMapper = mock(ObjectMapper.class);
    mockAuthenticationManager = mock(AuthenticationManager.class);
    mockUserFileDAO = mock(UserFileDAO.class);
    mockJwtUtil = mock(JwtUtil.class);

    authenticationController = new AuthenticationController(mockAuthenticationManager,
        mockUserFileDAO, mockJwtUtil);
  }

  @Test
  public void testAuthenticate() {
    // Setup
    AuthenticationRequest mockAuthenticationRequest = mock(AuthenticationRequest.class);
    UserDetails mockUserDetails = mock(UserDetails.class);
    when(mockAuthenticationRequest.getEmail()).thenReturn("email");
    when(mockAuthenticationRequest.getPassword()).thenReturn("password");
    when(mockUserFileDAO.getUser("email")).thenReturn(mockUserDetails);
    when(mockJwtUtil.generateToken(mockUserDetails)).thenReturn("token");

    ResponseEntity<String> result = authenticationController.authenticate(mockAuthenticationRequest);
    String body = result.getBody();
    assertEquals("token", body, "authenticate did not return the expected token");

    when(mockUserFileDAO.getUser("email")).thenReturn(null);
    assertEquals("Invalid credentials", authenticationController.authenticate(mockAuthenticationRequest).getBody(),
        "authenticate should return null if user is null");

  }
}
