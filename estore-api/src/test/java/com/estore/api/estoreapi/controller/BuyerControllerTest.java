package com.estore.api.estoreapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.estore.api.estoreapi.model.Buyer;
import com.estore.api.estoreapi.model.User;
import com.estore.api.estoreapi.persistence.BuyerFileDAO;
import com.estore.api.estoreapi.persistence.UserFileDAO;

public class BuyerControllerTest {
  BuyerController buyerController;
  BuyerFileDAO mockBuyerDAO;
  UserFileDAO mockUserDAO;
  HttpServletRequest mockRequest;
  User mockUser;
  Buyer mockBuyer;

  @BeforeEach
  public void setUp() throws Exception {
    mockBuyerDAO = mock(BuyerFileDAO.class);
    mockUserDAO = mock(UserFileDAO.class);
    buyerController = new BuyerController(mockBuyerDAO, mockUserDAO);
    mockRequest = mock(HttpServletRequest.class);
    mockUser = mock(User.class);
    mockBuyer = mock(Buyer.class);
    when(mockUserDAO.getUserByEmailPassword("admin", "admin")).thenReturn(mockUser);
    when(mockRequest.getHeader("Authorization")).thenReturn("admin:admin");
  }

  @Test
  public void testGetBuyer() throws IOException {
    // Setup
    when(mockBuyerDAO.getBuyer(1)).thenReturn(mockBuyer);
    when(mockBuyerDAO.getBuyer(2)).thenReturn(null);
    when(mockBuyerDAO.getBuyer(3)).thenThrow(new IOException());

    // Exercise
    ResponseEntity<Buyer> res1 = buyerController.getBuyer(1);
    ResponseEntity<Buyer> res2 = buyerController.getBuyer(2);
    ResponseEntity<Buyer> res3 = buyerController.getBuyer(3);

    // Assert
    assertTrue(res1.getStatusCodeValue() == 200);
    assertTrue(res2.getStatusCodeValue() == 404);
    assertTrue(res3.getStatusCodeValue() == 500);
  }

  @Test
  public void testGetBuyers() throws Exception {
    // Setup
    Buyer[] buyers = { mockBuyer };
    when(mockBuyerDAO.getBuyers()).thenReturn(buyers);
    when(mockUser.getAuthorities()).thenReturn("ADMIN");
    // Exercise
    ResponseEntity<Buyer[]> res1 = buyerController.getBuyers(mockRequest);
    when(mockUser.getAuthorities()).thenReturn("USER");
    ResponseEntity<Buyer[]> res2 = buyerController.getBuyers(mockRequest);
    when(mockUser.getAuthorities()).thenReturn("ADMIN");
    when(mockBuyerDAO.getBuyers()).thenThrow(new IOException());
    ResponseEntity<Buyer[]> res3 = buyerController.getBuyers(mockRequest);
    when(mockUserDAO.getUserByEmailPassword("admin", "admin")).thenThrow(new Exception());
    ResponseEntity<Buyer[]> res4 = buyerController.getBuyers(mockRequest);

    // Assert
    assertEquals(200, res1.getStatusCodeValue());
    assertEquals(401, res2.getStatusCodeValue());
    assertEquals(500, res3.getStatusCodeValue());
    assertEquals(401, res4.getStatusCodeValue());
  }

  @Test
  public void testCreateBuyer() throws IOException {
    when(mockBuyer.getEmail()).thenReturn("email");
    Buyer[] buyers = { mockBuyer };
    when(mockBuyerDAO.getBuyers()).thenReturn(buyers);

    Buyer newMockBuyer = mock(Buyer.class);
    when(newMockBuyer.getEmail()).thenReturn("email2");
    Buyer newMockBuyer2 = mock(Buyer.class);
    when(newMockBuyer.getEmail()).thenReturn("email3");
    // Setup
    when(mockBuyerDAO.createBuyer(newMockBuyer)).thenReturn(newMockBuyer);
    when(mockBuyerDAO.createBuyer(mockBuyer)).thenReturn(mockBuyer);
    when(mockBuyerDAO.createBuyer(newMockBuyer2)).thenThrow(new IOException());

    // Exercise
    ResponseEntity<Buyer> res1 = buyerController.createBuyer(newMockBuyer);
    ResponseEntity<Buyer> res2 = buyerController.createBuyer(mockBuyer);
    ResponseEntity<Buyer> res3 = buyerController.createBuyer(newMockBuyer2);

    // Assert
    assertTrue(res1.getStatusCodeValue() == 201);
    assertTrue(res2.getStatusCodeValue() == 409);
    assertTrue(res3.getStatusCodeValue() == 500);
  }

  @Test
  public void testUpdateBuyer() throws IOException{
    // Setup
    when(mockUser.getAuthorities()).thenReturn("USER");
    when(mockBuyer.getEmail()).thenReturn("user");
    when(mockBuyerDAO.updateBuyer(null)).thenReturn(null);

    // Exercise
    ResponseEntity<Buyer> res1 = buyerController.updateBuyer(mockRequest,mockBuyer);
    ResponseEntity<Buyer> res2 = buyerController.updateBuyer(mockRequest,null);

    // Assert
    assertEquals(401, res1.getStatusCodeValue());
    assertEquals(401, res2.getStatusCodeValue());

    when(mockRequest.getHeader("Authorization")).thenReturn(null);
    res1 = buyerController.updateBuyer(mockRequest,mockBuyer);
    assertEquals(401, res1.getStatusCodeValue());

    when(mockRequest.getHeader("Authorization")).thenReturn("admin:admin");
    when(mockUser.getAuthorities()).thenReturn("ADMIN");
    res1 = buyerController.updateBuyer(mockRequest,mockBuyer);
    assertEquals(404, res1.getStatusCodeValue());
    when(mockBuyerDAO.updateBuyer(mockBuyer)).thenReturn(mockBuyer);
    res1 = buyerController.updateBuyer(mockRequest,mockBuyer);
    assertEquals(200, res1.getStatusCodeValue());
    when(mockBuyerDAO.updateBuyer(mockBuyer)).thenThrow(new IOException());
    res1 = buyerController.updateBuyer(mockRequest,mockBuyer);
    assertEquals(500, res1.getStatusCodeValue());
  }

  @Test
  public void testDeleteBuyer() throws IOException{
    // Setup
    when(mockRequest.getHeader("Authorization")).thenReturn("adminadmin");
    ResponseEntity<Buyer> res1 = buyerController.deleteBuyer(mockRequest,1);
    assertEquals(401, res1.getStatusCodeValue());

    when(mockRequest.getHeader("Authorization")).thenReturn("admin:admin");
    when(mockUser.getAuthorities()).thenReturn("USER");
    when(mockUser.getUsername()).thenReturn("notadmin");
    when(mockBuyer.getEmail()).thenReturn("definitelyadmin");
    res1 = buyerController.deleteBuyer(mockRequest,1);
    
    when(mockUser.getAuthorities()).thenReturn("ADMIN");
    when(mockUser.getUsername()).thenReturn("admin");
    when(mockBuyerDAO.deleteBuyer(1)).thenReturn(false);
    ResponseEntity<Buyer> res2 = buyerController.deleteBuyer(mockRequest,1);
    
    assertEquals(404, res1.getStatusCodeValue());
    assertEquals(404, res2.getStatusCodeValue());

    
    when(mockBuyerDAO.deleteBuyer(1)).thenReturn(true);
    res2 = buyerController.deleteBuyer(mockRequest,1);
    when(mockBuyerDAO.deleteBuyer(1)).thenThrow(new IOException());
    res1 = buyerController.deleteBuyer(mockRequest,1);

    assertEquals(500, res1.getStatusCodeValue());
    assertEquals(200, res2.getStatusCodeValue());
    
  }
}
