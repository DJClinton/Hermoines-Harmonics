// package com.estore.api.estoreapi.auth;

// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.estore.api.estoreapi.persistence.UserFileDAO;

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("auth")
// @RequiredArgsConstructor
// public class AuthenticationController {

//   private final AuthenticationManager authenticationManager;
//   private final UserFileDAO userDao;
//   private final JwtUtil jwtUtil;

//   @PostMapping("/authenticate")
//   public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
//     authenticationManager
//         .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//     final UserDetails user = userDao.getUser(request.getEmail());
//     if (user != null) {
//       return ResponseEntity.ok(jwtUtil.generateToken(user));
//     }
//     return ResponseEntity.status(400).body("Invalid credentials");
//   }
// }
