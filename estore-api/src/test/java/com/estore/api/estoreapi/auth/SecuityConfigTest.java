// package com.estore.api.estoreapi.auth;

// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.security.core.userdetails.UserDetailsService;

// import com.estore.api.estoreapi.persistence.UserFileDAO;
// import com.fasterxml.jackson.databind.ObjectMapper;

// public class SecuityConfigTest {
//   SecurityConfig securityConfig;
//   UserFileDAO mockUserFileDAO;
//   JwtAuthFilter mockJwtAuthFilter;
//   ObjectMapper mockObjectMapper;

//   @BeforeEach
//   public void setup() {
//     mockObjectMapper = mock(ObjectMapper.class);
//     mockJwtAuthFilter = mock(JwtAuthFilter.class);
//     mockUserFileDAO = mock(UserFileDAO.class);

//     securityConfig = new SecurityConfig(mockJwtAuthFilter, mockUserFileDAO);
//   }

//   @Test
//   public void testUserDetailsService() {
//     when(mockUserFileDAO.getUser(anyString())).thenReturn(null);
//     // Invoke & Analyze
//     UserDetailsService res = securityConfig.userDetailsService();

//     // Assert
//     assertNull(res.loadUserByUsername("userEmail"), "UserDetailsService should return UserDAO's getUser result");
//   }
// }
