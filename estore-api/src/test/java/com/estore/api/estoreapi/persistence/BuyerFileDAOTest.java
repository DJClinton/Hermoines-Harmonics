package com.estore.api.estoreapi.persistence;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.estore.api.estoreapi.model.Buyer;
import com.estore.api.estoreapi.model.CreditCard;
import com.estore.api.estoreapi.model.Order;
import com.estore.api.estoreapi.model.Order.OrderStatus;
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
    BuyerFileDAO buyerFileDAO;
    Buyer[] testBuyers;
    ObjectMapper mockObjectMapper;

    @BeforeEach
    public void setupBuyerFileDAO() throws IOException {
        mockObjectMapper = mock(ObjectMapper.class);
        testBuyers = new Buyer[1];
        List<Order> pastOrderList = new ArrayList<>();
        List<CreditCard> paymentMethods = new ArrayList<>();

        int[] productIds1 = {1, 2, 3};
        int[] productIds2 = {4, 5, 6};
        Order order1 = new Order(productIds1, new Date(), OrderStatus.UNPROCESSED);
        Order order2 = new Order(productIds2, new Date(), OrderStatus.SHIPPED);
        pastOrderList.add(order1);
        pastOrderList.add(order2);


        CreditCard card = new CreditCard("John B. Buyer", 1234, new Date(), 333);
        paymentMethods.add(card);
        testBuyers[0] = new Buyer(1, "john@gmail.com", "1234", "john", 
                                  "buyer", "555-123-4567", pastOrderList, paymentMethods);
        

        // When the object mapper is supposed to read from the file
        // the mock object mapper will return the buyer array above
        when(mockObjectMapper
            .readValue(new File("doesnt_matter.txt"),Buyer[].class))
                .thenReturn(testBuyers);
        buyerFileDAO = new BuyerFileDAO("doesnt_matter.txt",mockObjectMapper);

    }

    @Test
    public void testGetBuyers() {
        // Invoke
        Buyer[] buyers = buyerFileDAO.getBuyers();

        // Analyze
        assertArrayEquals(buyers, testBuyers);
    }

    @Test
    public void testGetBuyer() {
        // Invoke
        Buyer buyer = buyerFileDAO.getBuyer(1);

        // Analzye
        assertEquals(buyer, testBuyers[0]);
    }

    @Test
    public void testCreateBuyer() {
        // Setup
        Buyer buyer = new Buyer(2, "Joe@joe.com", "password", "joe", "setup", 
                                "999-999-9999", new ArrayList<Order>(), new ArrayList<CreditCard>());

        // Invoke
        Buyer result = assertDoesNotThrow(() -> buyerFileDAO.createBuyer(buyer),
                                "Unexpected exception thrown");

        // Analyze
        assertNotNull(result);
        Buyer actual = buyerFileDAO.getBuyer(buyer.getId());
        assertEquals(actual.getId(), buyer.getId());
        assertEquals(actual.getEmail(), buyer.getEmail());
        assertEquals(actual.getFirstName(), buyer.getFirstName());
        assertEquals(actual.getLastName(), buyer.getLastName());
        assertEquals(actual.getPhoneNumber(), buyer.getPhoneNumber());
        assertEquals(actual.getPastOrders(), buyer.getPastOrders());
        assertEquals(actual.getPaymentMethods(), buyer.getPaymentMethods());
    }

    @Test
    public void testUpdateBuyer() {
        // Setup
        Buyer buyer = new Buyer(1, "Joe@joe.com", "password", "joe", "setup", 
                                "999-999-9999", new ArrayList<Order>(), new ArrayList<CreditCard>());

        // Invoke
        Buyer result = assertDoesNotThrow(() -> buyerFileDAO.updateBuyer(buyer),
                                "Unexpected exception thrown");

        // Analyze
        assertNotNull(result);
        Buyer actual = buyerFileDAO.getBuyer(buyer.getId());
        assertEquals(actual, buyer);
    }

    @Test
    public void testDeleteBuyer() {
        // Invoke
        boolean result = assertDoesNotThrow(() -> buyerFileDAO.deleteBuyer(1),
                            "Unexpected exception thrown");

        // Analzye
        assertEquals(result, true);
        // We check the internal tree map size against the length
        // of the test buyers array - 1 (because of the delete)
        // Because buyers attribute of BuyerFileDAO is package private
        // we can access it directly
        assertEquals(buyerFileDAO.buyers.size(), testBuyers.length - 1);
    }

}
