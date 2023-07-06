package com.estore.api.estoreapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Due to user class extends Spring Security's User class, only the methods that
 * are not inherited from the User class are tested.
 */
@Tag("Model-tier")
public class UserTest {
  @Test
  public void testID() {
    // Setup
    int id = 4;
    String email = "user@email.com";
    String password = "password";
    Collection<SimpleGrantedAuthority> authorities = Collections
        .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    User user = new User(id, email, password, authorities);
    int expected = 4;

    // Invoke
    int actual = user.getId();

    // Analyze
    assertEquals(expected, actual);
  }

  @Test
  public void testSetID() {
    // Setup
    int id = 4;
    String email = "user@email.com";
    String password = "password";
    Collection<SimpleGrantedAuthority> authorities = Collections
        .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    User user = new User(id, email, password, authorities);
    int expected = 5;

    // Invoke
    user.setId(expected);

    // Analyze
    assertEquals(expected, user.getId());
  }

  /**
   * A method for serializing the authorities of a user is needed as the
   * authories is a class that extends GrantedAuthority and is not serializable to
   * a JSON file.
   */
  @Test
  public void testAuthorities() {
    int id = 4;
    String email = "user@email.com";
    String password = "password";
    Collection<SimpleGrantedAuthority> authorities = Collections
        .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    User user = new User(id, email, password, authorities);
    Collection<String> expected = Collections.singletonList("ROLE_ADMIN");

    // Invoke
    Collection<String> actual = user.getAuthoritiesAsString();

    // Analyze
    assertEquals(expected, actual);

  }
}
