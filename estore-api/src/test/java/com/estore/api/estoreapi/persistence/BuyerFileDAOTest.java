package com.estore.api.estoreapi.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import com.estore.api.estoreapi.model.Buyer;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Test the Buyer File DAO Class
 * 
 * @author Team 2
 */
@Tag("Persistence-tier")
public class BuyerFileDAOTest {

  ObjectMapper mockObjectMapper;
  Buyer[] testBuyers;
  BuyerFileDAO buyerFileDAO;

  @BeforeEach
  public void setupBuyerFileDAO() throws IOException {
    mockObjectMapper = mock(ObjectMapper.class);

    testBuyers = new Buyer[3];
    testBuyers[0] = mock(Buyer.class);
    testBuyers[1] = mock(Buyer.class);
    testBuyers[2] = mock(Buyer.class);

    when(testBuyers[0].getId()).thenReturn(0);
    when(testBuyers[1].getId()).thenReturn(1);
    when(testBuyers[2].getId()).thenReturn(2);

    when(mockObjectMapper.readValue(new File("doesnt_matter.txt"), Buyer[].class))
        .thenReturn(testBuyers);
    buyerFileDAO = new BuyerFileDAO("doesnt_matter.txt", mockObjectMapper);
  }

  @Test
  public void testGetArray() {
    Buyer[] buyers = buyerFileDAO.getBuyers();
    assertEquals(testBuyers.length, buyers.length);
  }

  @Test
  public void testGetter() {
    assertEquals(testBuyers[0], buyerFileDAO.getBuyer(0));
    assertEquals(testBuyers[1], buyerFileDAO.getBuyer(1));
    assertEquals(testBuyers[2], buyerFileDAO.getBuyer(2));

    assertNull(buyerFileDAO.getBuyer(3));
  }

  @Test
  public void testCreate() throws IOException {
    Buyer mockBuyer = mock(Buyer.class);

    when(mockBuyer.getId()).thenReturn(3);
    when(mockBuyer.getEmail()).thenReturn("email");
    when(mockBuyer.getPassword()).thenReturn("password");
    when(mockBuyer.getFirstName()).thenReturn("fName");
    when(mockBuyer.getLastName()).thenReturn("lName");
    when(mockBuyer.getPhoneNumber()).thenReturn("phone");
    when(mockBuyer.getPastOrders()).thenReturn(null);
    when(mockBuyer.getPaymentMethods()).thenReturn(null);
    when(mockBuyer.getCart()).thenReturn(null);
    when(mockBuyer.getWishlist()).thenReturn(null);

    assertNotNull(buyerFileDAO.createBuyer(mockBuyer));
  }

  @Test
  public void testDelete() throws IOException {
    assertTrue(buyerFileDAO.deleteBuyer(0));
    assertNull(buyerFileDAO.getBuyer(0));
    assertFalse(buyerFileDAO.deleteBuyer(3));
  }

  @Test
  public void testUpdate() throws IOException {
    Buyer mockBuyer = mock(Buyer.class);

    when(mockBuyer.getId()).thenReturn(0);
    when(mockBuyer.getEmail()).thenReturn("email");
    when(mockBuyer.getPassword()).thenReturn("password");
    when(mockBuyer.getFirstName()).thenReturn("fName");
    when(mockBuyer.getLastName()).thenReturn("lName");
    when(mockBuyer.getPhoneNumber()).thenReturn("phone");
    when(mockBuyer.getPastOrders()).thenReturn(null);
    when(mockBuyer.getPaymentMethods()).thenReturn(null);
    when(mockBuyer.getCart()).thenReturn(null);
    when(mockBuyer.getWishlist()).thenReturn(null);

    assertEquals(mockBuyer, buyerFileDAO.updateBuyer(mockBuyer));
    when(mockBuyer.getId()).thenReturn(3);
    assertNull(buyerFileDAO.updateBuyer(mockBuyer));
  }

}
