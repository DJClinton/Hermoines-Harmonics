package com.estore.api.estoreapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Model-tier")
public class ProductTest {

    @Test
    public void testID() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        int expected = 4;

        // Invoke
        int actual = product.getId();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testGetName() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        String expected = "Saxophone";

        // Invoke
        String actual = product.getName();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testSetName() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        String expected = "Alto Saxophone";

        // Invoke
        product.setName("Alto Saxophone");
        String actual = product.getName();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        double expected = 699.99;

        // Invoke
        double actual = product.getPrice();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testSetPrice() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        double expected = 799.99;

        // Invoke
        product.setPrice(799.99);
        double actual = product.getPrice();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuantity() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        int expected = 7;

        // Invoke
        double actual = product.getQuantity();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testSetQuantity() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        int expected = 5;

        // Invoke
        product.setQuantity(5);
        double actual = product.getQuantity();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testIncrementQuantity() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        int expected = 8;

        // Invoke
        product.incrementQuantity();
        double actual = product.getQuantity();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testDecrementQuantity() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        Product product = new Product(id, name, price, quantity);
        int expected = 6;

        // Invoke
        product.decrementQuantity();
        double actual = product.getQuantity();

        // Analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        // Setup
        int id = 4;
        String name = "Saxophone";
        double price = 699.99;
        int quantity = 7;
        String expected = String.format(Product.STRING_FORMAT,id,name);
        Product product = new Product(id,name,price,quantity);

        // Invoke
        String actual = product.toString();

        // Analyze
        assertEquals(expected,actual);
    }
    
}
