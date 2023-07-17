// package com.estore.api.estoreapi.model;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Tag;
// import org.junit.jupiter.api.Test;

// import com.estore.api.estoreapi.model.Order.OrderStatus;

// @Tag("Model-tier")
// public class BuyerTest {
//     private int expectedId;
//     private String expectedEmail;
//     private String expectedPassword;
//     private String expectedFirstName;
//     private String expectedLastName;
//     private String expectedPhoneNumber;
//     private List<Order> expectedPastOrders;
//     private List<CreditCard> expectedPaymentMethods;
//     private Buyer buyer;
    
//     @BeforeEach
//     public void setupBuyerTest() {
//         expectedId = 1;
//         expectedEmail = "email";
//         expectedPassword = "password";
//         expectedFirstName = "joe";
//         expectedLastName = "smith";
//         expectedPhoneNumber = "222-222-2222";
//         expectedPastOrders = new ArrayList<>();
//         expectedPastOrders.add(new Order(new int[1], new Date(), OrderStatus.UNPROCESSED));
//         expectedPaymentMethods = new ArrayList<>();
//         expectedPaymentMethods.add(new CreditCard("joe smith", 1234, new Date(), 321));
//         buyer = new Buyer(expectedId, expectedEmail, expectedPassword, expectedFirstName, 
//                           expectedLastName, expectedPhoneNumber, expectedPastOrders, expectedPaymentMethods);
//     }


//     @Test
//     public void testID() {
//         assertEquals(expectedId, buyer.getId());
//     }

//     @Test
//     public void testEmail() {
//         assertEquals(expectedEmail, buyer.getEmail());
//     }

//     @Test
//     public void testPassword() {
//         assertEquals(expectedPassword, buyer.getPassword());
//     }

//     @Test
//     public void testFirstName() {
//         assertEquals(expectedFirstName, buyer.getFirstName());
//     }

//     @Test
//     public void testLastName() {
//         assertEquals(expectedLastName, buyer.getLastName());
//     }

//     @Test
//     public void testPhoneNumber() {
//         assertEquals(expectedPhoneNumber, buyer.getPhoneNumber());
//     }

//     @Test
//     public void testPastOrders() {
//         assertEquals(expectedPastOrders, buyer.getPastOrders());
//     }

//     @Test
//     public void testPaymentMethods() {
//         assertEquals(expectedPaymentMethods, buyer.getPaymentMethods());
//     }

//     @Test
//     public void testToString() {
//         String expectedString = String.format(Buyer.STRING_FORMAT, expectedId, expectedEmail, expectedPassword, 
//                                               expectedFirstName, expectedLastName, expectedPhoneNumber, expectedPastOrders,
//                                               expectedPaymentMethods);

//         assertEquals(expectedString, buyer.toString());
//     }
// }
