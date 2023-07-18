// package com.estore.api.estoreapi.model;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotEquals;

// import java.util.Collection;
// import java.util.Collections;

// import org.junit.jupiter.api.Tag;
// import org.junit.jupiter.api.Test;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;

// /**
//  * Due to user class extends Spring Security's User class, only the methods that
//  * are not inherited from the User class are tested.
//  */
// @Tag("Model-tier")
// public class UserTest {
//   @Test
//   public void testID() {
//     // Setup
//     int id = 4;
//     String email = "user@email.com";
//     String password = "password";
//     Collection<SimpleGrantedAuthority> authorities = Collections
//         .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//     User user = new User(id, email, password, authorities);
//     int expected = 4;

//     // Invoke
//     int actual = user.getId();

//     // Analyze
//     assertEquals(expected, actual);
//   }

//   @Test
//   public void testSetID() {
//     // Setup
//     int id = 4;
//     String email = "user@email.com";
//     String password = "password";
//     Collection<SimpleGrantedAuthority> authorities = Collections
//         .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//     User user = new User(id, email, password, authorities);
//     int expected = 5;

//     // Invoke
//     user.setId(expected);

//     // Analyze
//     assertEquals(expected, user.getId());
//   }

//   /**
//    * A method for serializing the authorities of a user is needed as the
//    * authories is a class that extends GrantedAuthority and is not serializable to
//    * a JSON file.
//    */
//   @Test
//   public void testAuthorities() {
//     int id = 4;
//     String email = "user@email.com";
//     String password = "password";
//     Collection<SimpleGrantedAuthority> authorities = Collections
//         .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//     User user = new User(id, email, password, authorities);
//     Collection<String> expected = Collections.singletonList("ROLE_ADMIN");

//     // Invoke
//     Collection<String> actual = user.getAuthoritiesAsString();

//     // Analyze
//     assertEquals(expected, actual);

//   }

//   @Test
//   public void testEquals() {
//     int id1 = 4;
//     int id2 = 3;
//     String email1 = "user@email.com";
//     String email2 = "user2@email.com";
//     String password = "password";
//     Collection<SimpleGrantedAuthority> authorities = Collections
//         .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//     User user1 = new User(id1, email1, password, authorities);
//     User user2 = new User(id1, email2, password, authorities);
//     User user3 = new User(id2, email1, password, authorities);

//     // Invoke & Analyze
//     assertEquals(user1, user1, "User is not equal to itself");
//     assertEquals(user1, user2, "Users are not equal");
//     assertNotEquals(user1, user3, "Users are equal");
//     assertNotEquals(user1, "Bobby", "User is equal to a string");
//   }
// }
