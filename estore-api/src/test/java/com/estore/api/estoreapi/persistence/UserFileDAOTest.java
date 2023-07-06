package com.estore.api.estoreapi.persistence;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.estore.api.estoreapi.model.Product;
import com.estore.api.estoreapi.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Tag("Persistence-tier")
public class UserFileDAOTest {
  UserFileDAO userFileDAO;
  User[] testUsers;
  ObjectMapper mockObjectMapper;

  @BeforeEach
  public void setupUserFileDAO() throws IOException {
    mockObjectMapper = mock(ObjectMapper.class);

    testUsers = new User[3];
    testUsers[0] = new User(1, "admin@admin.com", "password",
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    testUsers[1] = new User(2, "user1@user1.com", "password",
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    testUsers[2] = new User(3, "user2@user2.com", "password",
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));

    when(mockObjectMapper
        .readValue(new File("doesnt_matter.txt"), User[].class))
        .thenReturn(testUsers);

    userFileDAO = new UserFileDAO("doesnt_matter.txt", mockObjectMapper);
  }

  @Test
  public void testConstructorException() throws IOException {
    // Setup
    ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
    doThrow(new IOException()).when(mockObjectMapper).readValue(new File("doesnt_matter.txt"), User[].class);

    // Invoke & Analyze
    assertThrows(IOException.class, () -> new UserFileDAO("doesnt_matter.txt", mockObjectMapper),
        "IOException not thrown");
  }

  @Test
  public void testGetUser() {
    // Setup
    User expected = testUsers[1];

    // Invoke
    User actual = (User) userFileDAO.getUser("user1@user1.com");

    // Analyze
    assertEquals(expected, actual, "User not found");
  }

  @Test
  public void testGetUsers() {
    // Setup
    User[] expected = testUsers;

    // Invoke
    User[] actual = userFileDAO.getUsers();

    // Analyze
    assertArrayEquals(expected, actual, "Users not found");
  }

  @Test
  public void testCreateUser() {
    // Setup
    User newUser = new User(4, "fakeadmin@admin.com", "password",
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    User[] expected = { testUsers[0], testUsers[1], testUsers[2], newUser };

    // Invoke
    try {
      userFileDAO.createUser(newUser);
    } catch (IOException e) {
      /* Squash */
    }

    User[] actual = userFileDAO.getUsers();

    // Analyze
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testUpdateUser() {
    // Setup
    int index0 = 0;
    int index1 = 1;
    User updatedUser = new User(3, "newuser2@user2.com", "securepassword",
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    User[] expected = { testUsers[index0], testUsers[index1], updatedUser };

    // Invoke
    try {
      userFileDAO.updateUser(updatedUser);
    } catch (IOException e) {
      /* Squash */}

    User[] actual = userFileDAO.getUsers();

    // Analyze
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testDeleteUser() {
    // Setup
    int index0 = 0;
    int index1 = 1;
    User[] expected = { testUsers[index0], testUsers[index1] };

    // Invoke
    try {
      userFileDAO.deleteUser(testUsers[2].getId());
    } catch (IOException e) {
      /* Squash */}

    User[] actual = userFileDAO.getUsers();

    // Analyze
    assertArrayEquals(expected, actual);
  }
}
