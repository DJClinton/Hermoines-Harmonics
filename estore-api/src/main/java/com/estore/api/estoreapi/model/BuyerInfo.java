package com.estore.api.estoreapi.model;

import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a buyer account
 * 
 * @author Team 2
 */
public class BuyerInfo {
    private static final Logger LOG = Logger.getLogger(Product.class.getName());

    static final String STRING_FORMAT = "Buyer [id=%d, user id=%d, first name=%s, last name=%s, phone number=%s, payment method=%s]";

    @JsonProperty("id")
    private int id;
    @JsonProperty("userid")
    private int userid;
    @JsonProperty("firstName") 
    private String firstName;
    @JsonProperty("lastName") 
    private String lastName;
    @JsonProperty("phoneNumber") 
    private String phoneNumber;
    @JsonProperty("paymentMethod")
    private CreditCard paymentMethod;

    public BuyerInfo(@JsonProperty("id") int id, @JsonProperty("userid") int userid,
                     @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, 
                     @JsonProperty("phoneNumber") String phoneNumber, 
                     @JsonProperty("paymentMethod") CreditCard paymentMethod) {

        LOG.info("Creating buyer info: " + this);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.paymentMethod = paymentMethod;
    }

    /**
     * Retrieves this buyer's account id
     * 
     * @return buyer account id
     */
    public int getId() {
        LOG.info("Retrieving buyer id: " + id);
        return id;
    }

    /**
     * Retrieves the id of the associated user
     * 
     * @return associated user id
     */
    public int getUserId() {
        LOG.info("Retrieving buyer's associated user id: " + userid);
        return userid;
    }

    /**
     * Retrieves this buyer's first name
     * 
     * @return buyer first name
     */
    public String getFirstName() {
        LOG.info("Retrieving buyer first name: " + firstName);
        return firstName;
    }

    /**
     * Retrieves this buyer's last name
     * 
     * @return buyer last name
     */
    public String getLastName() {
        LOG.info("Retrieving buyer last name: " + lastName);
        return lastName;
    }

    /**
     * Retrieves this buyer's phone number
     * 
     * @return buyer phone number
     */
    public String getPhoneNumber() {
        LOG.info("Retrieving buyer phone number: " + phoneNumber);
        return phoneNumber;
    }

    /**
     * Retrieves this buyer's payment method
     * 
     * @return this buyer's payment method
     */
    public CreditCard getPaymentMethod() {
        LOG.info("Retrieving buyer's payment method: " + paymentMethod);
        return paymentMethod;
    }

    /**
     * Sets this buyer's associated user id
     * 
     * @param userid new associated user id
     */
    public void setUserID(int userid) {
        LOG.info("Setting buyer's associated user id: " + userid);
        this.userid = userid;
    }

    /**
     * Sets the buyer's first name
     * 
     * @param firstName new first name
     */
    public void setFirstName(String firstName) {
        LOG.info("Setting buyer first name: " + firstName);
        this.firstName = firstName;
    }

    /**
     * Sets the buyer's last name
     * 
     * @param lastName new last name
     */
    public void setLastName(String lastName) {
        LOG.info("Setting buyer last name: " + lastName);
        this.lastName = lastName;
    }

    /**
     * Sets the buyer's phone number
     * 
     * @param phoneNumber new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        LOG.info("Setting buyer phone number: " + phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the buyer's payment method
     * 
     * @param paymentMethods new payment method
     */
    public void setPaymentMethod(CreditCard paymentMethod) {
        LOG.info("Setting buyer's payment methods: " + paymentMethod);
        this.paymentMethod = paymentMethod;
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(STRING_FORMAT, id, userid, firstName, lastName, 
                             phoneNumber, paymentMethod);
    }

}
