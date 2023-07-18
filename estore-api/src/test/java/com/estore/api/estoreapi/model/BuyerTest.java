package com.estore.api.estoreapi.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.estore.api.estoreapi.model.Order.OrderStatus;

@Tag("Model-tier")
public class BuyerTest {
  @Test
  public void testConstructor() {
    int id = 1;
    String email = "email";
    String password = "password";
    String firstName = "firstName";
    String lastName = "lastName";
    String phoneNumber = "phoneNumber";
    List<Order> pastOrders = new ArrayList<Order>();
    List<CreditCard> paymentMethods = new ArrayList<CreditCard>();
    Collection<Integer> cart = Collections.emptyList();
    Collection<Integer> wishlist = Collections.emptyList();

    assertDoesNotThrow(() -> new Buyer(id, email, password, firstName, lastName, phoneNumber, pastOrders,
        paymentMethods, cart, wishlist), "constructor threw an error");
  }

  @Test
  public void testSetGet() {
    int id = 1;
    String email = "email";
    String password = "password";
    String firstName = "firstName";
    String lastName = "lastName";
    String phoneNumber = "phoneNumber";
    List<Order> pastOrders = new ArrayList<Order>();
    List<CreditCard> paymentMethods = new ArrayList<CreditCard>();
    Collection<Integer> cart = Collections.emptyList();
    Collection<Integer> wishlist = Collections.emptyList();

    Buyer buyer = new Buyer(id, email, password, firstName, lastName, phoneNumber, pastOrders, paymentMethods, cart,
        wishlist);

    assertEquals("Buyer [id=" + id + ", email=" + email + ", password=" + password + ", first name=" + firstName
        + ", last name=" + lastName + ", phone number=" + phoneNumber + ", past orders=" + pastOrders
        + ", payment methods=" + paymentMethods + ", cart=" + cart + ", wishlist=" + wishlist + "]",
        buyer.toString());

    buyer.setEmail("newEmail");
    buyer.setPassword("newPassword");
    buyer.setFirstName("newFirstName");
    buyer.setLastName("newLastName");
    buyer.setPhoneNumber("newPhoneNumber");
    Order mockedOrder = mock(Order.class);
    Order[] mockedOrders = { mockedOrder };
    buyer.setPastOrders(Arrays.asList(mockedOrders));
    CreditCard mockCreditCard = mock(CreditCard.class);
    CreditCard[] mockedCreditCards = { mockCreditCard };
    buyer.setPaymentMethods(Arrays.asList(mockedCreditCards));
    Product mockedProduct = mock(Product.class);
    when(mockedProduct.getId()).thenReturn(1);
    buyer.addProductCart(mockedProduct);
    buyer.addProductWishlist(mockedProduct);

    assertEquals("newEmail", buyer.getEmail());
    assertEquals("newPassword", buyer.getPassword());
    assertEquals("newFirstName", buyer.getFirstName());
    assertEquals("newLastName", buyer.getLastName());
    assertEquals("newPhoneNumber", buyer.getPhoneNumber());
    assertEquals(mockedOrders.length, buyer.getPastOrders().size());
    assertEquals(mockedCreditCards.length, buyer.getPaymentMethods().size());
    assertEquals(1, buyer.getCart().size());
    assertEquals(1, buyer.getWishlist().size());

    buyer.removeProductCart(mockedProduct);
    buyer.removeProductWishlist(mockedProduct);
    assertEquals(0, buyer.getCart().size());
    assertEquals(0, buyer.getWishlist().size());

  }
}
