package com.estore.api.estoreapi.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AuthenticationRequestTest {
  @Test
  public void testConstructor() {
    // Exercise
    AuthenticationRequest actualAuthenticationRequest = new AuthenticationRequest("email", "password");

    // Verify
    assertEquals("email", actualAuthenticationRequest.getEmail());
    assertEquals("password", actualAuthenticationRequest.getPassword());

    // Exercise
    actualAuthenticationRequest.setEmail("newEmail");
    actualAuthenticationRequest.setPassword("newPassword");

    // Verify
    assertEquals("newEmail", actualAuthenticationRequest.getEmail());
    assertEquals("newPassword", actualAuthenticationRequest.getPassword());
  }
}
