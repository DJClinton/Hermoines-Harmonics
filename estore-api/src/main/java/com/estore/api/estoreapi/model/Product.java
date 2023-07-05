package com.estore.api.estoreapi.model;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Product entity
 * 
 * @author Team 2
 */
public class Product {
    private static final Logger LOG = Logger.getLogger(Product.class.getName());

    // Package private for tests
    static final String STRING_FORMAT = "Product [id=%d, name=%s]";

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private double price;
    @JsonProperty("quantity")
    private int quantity;

    /**
     * Create a product with the given id and name
     * 
     * @param id       The id of the product
     * @param name     The name of the product
     * @param price    The price of the product
     * @param quantity How many products are in stock
     * 
     *                 {@literal @}JsonProperty is used in serialization and
     *                 deserialization
     *                 of the JSON object to the Java object in mapping the fields.
     *                 If a field
     *                 is not provided in the JSON object, the Java field gets the
     *                 default Java
     *                 value, i.e. 0 for int
     */
    public Product(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("price") double price,
            @JsonProperty("quantity") int quantity) {
        LOG.info("Creating Product with id: " + id + " and name: " + name);
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the id of the product
     * 
     * @return The id of the product
     */
    public int getId() {
        LOG.info("Retrieving Product by id of " + id);
        return id;
    }

    /**
     * Sets the name of the product - necessary for JSON object to Java object
     * deserialization
     * 
     * @param name The new name of the product
     */
    public void setName(String name) {
        LOG.info("Setting Product name to " + name);
        this.name = name;
    }

    /**
     * Retrieves the name of the product
     * 
     * @return The name of the product
     */
    public String getName() {
        LOG.info("Retrieving Product by the name of " + name);
        return name;
    }

    /**
     * Sets the price of the product
     * 
     * @param price The new price of the product
     */
    public void setPrice(double price) {
        LOG.info("Setting Product price to " + price);
        this.price = price;
    }

    /**
     * Retrieves the price of the product
     * 
     * @return The price of the product
     */
    public double getPrice() {
        LOG.info("Retrieving Product by the price of " + price);
        return price;
    }

    /**
     * Sets the quantity of the product
     * 
     * @param quantity The new quantity of the product
     */
    public void setQuantity(int quantity) {
        LOG.info("Setting Product quantity to " + quantity);
        this.quantity = quantity;
    }

    /**
     * Increments the quantity by 1
     */
    public void incrementQuantity() {
        LOG.info("Incrementing Product quantity by 1");
        this.quantity++;
    }

    /**
     * Decrements the quantity by 1
     */
    public void decrementQuantity() {
        LOG.info("Decrementing Product quantity by 1");
        this.quantity--;
    }

    /**
     * Retrieves the quantity of the product
     * 
     * @return The quantity of the product
     */
    public int getQuantity() {
        LOG.info("Retrieving Product by the quantity of " + quantity);
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            Product other = (Product)o;
            return (this.id == other.id);
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(STRING_FORMAT, id, name);
    }
}