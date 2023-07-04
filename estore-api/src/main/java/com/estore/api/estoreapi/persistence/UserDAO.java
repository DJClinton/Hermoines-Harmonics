package com.estore.api.estoreapi.persistence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
  private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  private final List<UserDetails> APPLICATION_USERS = Arrays.asList(
      new User("admin@admin.com", encryptPassword("password"),
          Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
      new User("user@user.com", encryptPassword("password"),
          Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))));

  public UserDetails getUserDetails(String email) {
    return APPLICATION_USERS.stream()
        .filter(user -> user.getUsername().equals(email))
        .findFirst()
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  private String encryptPassword(String password) {
    // return password;
    return bCryptPasswordEncoder.encode(password);
  }
}
