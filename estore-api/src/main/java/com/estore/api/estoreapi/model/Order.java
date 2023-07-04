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

    static final String STRING_FORMAT = "Order [productIds=%s, date=%s, order=%s]";

    enum OrderStatus {
        UNPROCESSED,
        SHIPPED,
        RECIEVED
    }

    @JsonProperty("productId")
    private int[] productIds;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("orderStatus")
    private OrderStatus orderStatus;

    /**
     * Create an order with the product sold and the date it was placed
     * 
     * @param product   product that was sold in this order
     * @param date      date that this order was placed
     */

    public Order(@JsonProperty("productId") int[] productIds, @JsonProperty("date") Date date, 
                 @JsonProperty("orderStatus") OrderStatus orderStatus) {
        this.productIds = productIds;
        this.date = date;
        this.orderStatus = orderStatus;
        LOG.info("Creating " + this);
    }

    /**
     * Retrieve the product ids that were sold in this order
     * 
     * @return sold product ids
     */
    public int[] getProductIds() {
        LOG.info("Retrieving order product by id: " + productIds);
        return productIds;
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
     * Retrieve the order status
     * 
     * @return order status
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(STRING_FORMAT, productIds, date, orderStatus);
    }

}
