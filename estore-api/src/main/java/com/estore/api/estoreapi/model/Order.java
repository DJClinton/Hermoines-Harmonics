package com.estore.api.estoreapi.model;

import java.util.Date;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an order entity
 * 
 * @author Team 2
 */
public class Order {
    private static final Logger LOG = Logger.getLogger(Product.class.getName());

    static final String STRING_FORMAT = "Order [productId=%d, date=%s]";

    @JsonProperty("productId")
    private int productId;

    @JsonProperty("date")
    private Date date;

    /**
     * Create an order with the product sold and the date it was placed
     * 
     * @param product   product that was sold in this order
     * @param date      date that this order was placed
     */

    public Order(@JsonProperty("productId") int productId, @JsonProperty("date") Date date) {
        this.productId = productId;
        this.date = date;
        LOG.info("Creating " + this);
    }

    /**
     * Retrieve the product id that was sold in this order
     * 
     * @return sold product id
     */
    public int getProductId() {
        LOG.info("Retrieving order product by id: " + productId);
        return productId;
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
        return String.format(STRING_FORMAT, productId, date);
    }

}
