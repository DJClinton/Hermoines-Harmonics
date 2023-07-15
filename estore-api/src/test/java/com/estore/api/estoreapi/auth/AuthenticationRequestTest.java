package com.estore.api.estoreapi.auth;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AuthenticationRequestTest {
  @Test
  public void testConstructor() {
    // Setup
    String email = "username";
    String password = "password";

    // Invoke
    AuthenticationRequest authenticationRequest = new AuthenticationRequest();

    // Analyze
    assertDoesNotThrow(() -> authenticationRequest.setEmail(email),
        "AuthenticationRequest should have setEmail method");
    assertDoesNotThrow(() -> authenticationRequest.setPassword(password),
        "AuthenticationRequest should have setPassword method");
    assertDoesNotThrow(() -> authenticationRequest.getEmail(), "AuthenticationRequest should have getEmail method");
    assertDoesNotThrow(() -> authenticationRequest.getPassword(),
        "AuthenticationRequest should have getPassword method");
  }

  @Test
  public void testSet() {
    // Setup
    String email = "username";
    String password = "password";
    AuthenticationRequest authenticationRequest = new AuthenticationRequest();

    // Invoke
    authenticationRequest.setEmail(email);
    authenticationRequest.setPassword(password);

    // Analyze
    assertEquals(email, authenticationRequest.getEmail(), "AuthenticationRequest did not return a correct email");
    assertEquals(password, authenticationRequest.getPassword(),
        "AuthenticationRequest did not return a correct password");
  }
}
