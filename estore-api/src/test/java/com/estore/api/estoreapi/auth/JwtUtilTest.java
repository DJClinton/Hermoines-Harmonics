// package com.estore.api.estoreapi.auth;

// import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.Test;
// import org.springframework.security.core.userdetails.UserDetails;

// public class JwtUtilTest {
//   JwtUtil jwtUtil = new JwtUtil();

//   @Test
//   void tokenTest() {
//     UserDetails mockUserDetails = mock(UserDetails.class);
//     when(mockUserDetails.getUsername()).thenReturn("username");
//     when(mockUserDetails.getPassword()).thenReturn("password");

//     assertDoesNotThrow(() -> jwtUtil.generateToken(mockUserDetails));

//     String token = jwtUtil.generateToken(mockUserDetails);
//     assertEquals("username", jwtUtil.extractUsername(token));
//     assertTrue(jwtUtil.validateToken(token, mockUserDetails));

//     when(mockUserDetails.getUsername()).thenReturn("fake username");
//     assertFalse(jwtUtil.validateToken(token, mockUserDetails));

//   }
// }
