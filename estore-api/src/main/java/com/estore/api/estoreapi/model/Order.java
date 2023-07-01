package com.estore.api.estoreapi.model;

import java.util.Date;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an order entity
 * 
 * @author Team 2
 */
public class Order {
    private static final Logger LOG = Logger.getLogger(Product.class.getName());

    static final String STRING_FORMAT = "Order [product=%s, date=%s]";

    @JsonProperty("product")
    private Product product;
    @JsonProperty("date")
    private Date date;

    /**
     * Create an order with the product sold and the date it was placed
     * 
     * @param product   product that was sold in this order
     * @param date      date that this order was placed
     */

    public Order(@JsonProperty("product") Product product, @JsonProperty("date") Date date) {
        this.product = product;
        this.date = date;
        LOG.info("Creating " + this);
    }

    /**
     * Retrieve the product that was sold in this order
     * 
     * @return sold product
     */
    public Product getProduct() {
        LOG.info("Retrieving order product: " + product);
        return product;
    }

    /**
     * Retrieve the date this order was placed
     * 
     * @return date of order
     */
    public Date getDate() {
        LOG.info("Retrieving order date: " + date);
        return date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(STRING_FORMAT, product, date);
    }

}
