// package com.estore.api.estoreapi.auth;

// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.mockStatic;
// import static org.mockito.Mockito.when;

// import java.io.IOException;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.MockedStatic;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContext;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.estore.api.estoreapi.persistence.UserFileDAO;

// public class JwtAuthFilterTest {
//   UserFileDAO mockUserFileDAO;
//   JwtUtil mockJwtUtil;

//   JwtAuthFilter jwtAuthFilter;

//   @BeforeEach
//   void setUp() throws Exception {
//     mockUserFileDAO = mock(UserFileDAO.class);
//     mockJwtUtil = mock(JwtUtil.class);

//     jwtAuthFilter = new JwtAuthFilter(mockUserFileDAO, mockJwtUtil);
//   }

//   @Test
//   void doFilterInternalTest() throws IOException, ServletException {
//     HttpServletRequest mockRequest = mock(HttpServletRequest.class);
//     HttpServletResponse mockResponse = mock(HttpServletResponse.class);
//     FilterChain mockFilterChain = mock(FilterChain.class);
//     SecurityContext mockSecurityContext = mock(SecurityContext.class);
//     UserDetails mockUserDetails = mock(UserDetails.class);
//     Authentication mockAuthentication = mock(Authentication.class);

//     jwtAuthFilter.doFilterInternal(mockRequest, mockResponse, mockFilterChain);

//     when(mockRequest.getHeader("Authorization")).thenReturn("fake token");
//     jwtAuthFilter.doFilterInternal(mockRequest, mockResponse, mockFilterChain);

//     when(mockRequest.getHeader("Authorization")).thenReturn("Bearer token");
//     when(mockJwtUtil.extractUsername("token")).thenReturn(null);
//     jwtAuthFilter.doFilterInternal(mockRequest, mockResponse, mockFilterChain);

//     when(mockJwtUtil.extractUsername("token")).thenReturn("fake username");
//     when(mockJwtUtil.validateToken("token", null)).thenReturn(false);
//     when(mockSecurityContext.getAuthentication()).thenReturn(null);
//     when(mockUserFileDAO.getUser("fake username")).thenReturn(mockUserDetails);
//     when(mockJwtUtil.validateToken("token", mockUserDetails)).thenReturn(true);
//     try (MockedStatic<SecurityContextHolder> mockSecurityContextHolder = mockStatic(SecurityContextHolder.class)) {
//       mockSecurityContextHolder.when(SecurityContextHolder::getContext).thenReturn(mockSecurityContext);
//       when(mockSecurityContext.getAuthentication()).thenReturn(mockAuthentication);
//       jwtAuthFilter.doFilterInternal(mockRequest, mockResponse, mockFilterChain);

//       when(mockSecurityContext.getAuthentication()).thenReturn(null);
//       jwtAuthFilter.doFilterInternal(mockRequest, mockResponse, mockFilterChain);

//       when(mockJwtUtil.validateToken("token", mockUserDetails)).thenReturn(false);
//       jwtAuthFilter.doFilterInternal(mockRequest, mockResponse, mockFilterChain);
//     }
//   }
// }
