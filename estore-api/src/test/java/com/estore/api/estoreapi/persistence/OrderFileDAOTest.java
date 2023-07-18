package com.estore.api.estoreapi.persistence;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.estore.api.estoreapi.model.Order;
import com.estore.api.estoreapi.model.Order.OrderStatus;
import com.estore.api.estoreapi.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@Tag("Persistence-tier")
public class OrderFileDAOTest {

    OrderFileDAO orderFileDAO;
    Order[] orders;
    ObjectMapper mockObjectMapper;

    @BeforeEach
    public void setUpOrderFileDao() throws IOException{
        mockObjectMapper = mock(ObjectMapper.class);
        
        orders = new Order[3];
        int[] productId = {1, 2, 3};
        orders[0] =  new Order(productId, new Date(1689653389), OrderStatus.UNPROCESSED, 
                    0123, "9782 West Bayberry Street Cookeville, TN 38501", 1, 2);
        orders[1] = new Order(productId, new Date(1689653370), OrderStatus.UNPROCESSED, 
                    4567, "8622 Marconi St. Brookfield, WI 53045", 2, 2);
        orders[2] = new Order(productId, new Date(1689653379), OrderStatus.UNPROCESSED, 
                    8901, "50 Talbot Lane Bellmore, NY 11710, TN 38501", 3, 2);
    
        when(mockObjectMapper
            .readValue(new File("doesnt_matter.txt"),Order[].class))
                .thenReturn(orders);

        orderFileDAO = new OrderFileDAO("doesnt_matter.txt",mockObjectMapper);
    
    }

    @Test
    public void testConstructorException() throws IOException {
        // Setup
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        doThrow(new IOException()).when(mockObjectMapper).readValue(new File("doesnt_matter.txt"),Order[].class);

        // Invoke & Analyze
        assertThrows(IOException.class,() -> new OrderFileDAO("doesnt_matter.txt",mockObjectMapper),"IOException not thrown");
    }

    @Test
    public void testGetOrders() {
        // Setup
        Order[] expected = orders;

        // Invoke
        Order[] actual = orderFileDAO.getAll();

        // Analyze
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testGetOrder() {
        // Setup
        int index = 0;    // First id is at index 0.
        Order expected = orders[index];

        // Invoke
        int id = 1;
        Order actual = orderFileDAO.getOrder(id);

        // Analyze
        assertEquals(expected,actual);
    }

    @Test
    public void testDeleteProduct() {
        // Setup
        int index0 = 0;
        int index1 = 1;
        Order[] expected = {orders[index0], orders[index1]};

        // Invoke
        try {
            orderFileDAO.deleteOrder(3);
        } catch (IOException e) {/* Squash */}

        Order[] actual = orderFileDAO.getOrders(2);

        // Analyze
       // assertArrayEquals(expected,actual);
    }

    @Test
    public void testCreateProduct() {
        // Setup
        int index0 = 0;
        int index1 = 1;
        int index2 = 2;

        int productids[] = {1, 2, 3};

        Order newOrder = new Order(productids, new Date(), OrderStatus.DELIVERED, 1234, "asdas", 4, 2);

        Order[] expected = {orders[index0], orders[index1], orders[index2], newOrder};

        // Invoke
        try {
            orderFileDAO.createOrder(newOrder);
        } catch (IOException e) {/* Squash */} 

        Order[] actual = orderFileDAO.getOrders(2);

        // Analyze
        //assertArrayEquals(expected,actual);
    }


}
