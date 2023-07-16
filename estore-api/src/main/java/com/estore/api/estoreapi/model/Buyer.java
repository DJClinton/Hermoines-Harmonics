package com.estore.api.estoreapi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Represents a buyer account
 * 
 * @author Team 2
 */
public class Buyer {
    private static final Logger LOG = Logger.getLogger(Product.class.getName());

    static final String STRING_FORMAT = "Buyer [id=%d, email=%s, password=%s, first name=%s, last name=%s, phone number=%s, past orders=%s, payment methods=%s]";

    @JsonProperty("id")
    private int id;
    @JsonProperty("email") 
    private String email;
    @JsonProperty("password") 
    private String password;
    @JsonProperty("firstName") 
    private String firstName;
    @JsonProperty("lastName") 
    private String lastName;
    @JsonProperty("phoneNumber") 
    private String phoneNumber;
    @JsonProperty("pastOrders")
    private List<Order> pastOrders;
    @JsonProperty("paymentMethods")
    private List<CreditCard> paymentMethods;
    @JsonProperty 
    private Collection<Integer> cart;
    @JsonProperty("totalCost")
    private int totalCost;

    public Buyer(@JsonProperty("id") int id, @JsonProperty("email") String email,@JsonProperty("cart") Collection<Integer> cart,
                 @JsonProperty("password") String password, @JsonProperty("firstName") String firstName, 
                 @JsonProperty("lastName") String lastName, @JsonProperty("phoneNumber") String phoneNumber, 
                 @JsonProperty("pastOrders") List<Order> pastOrders, @JsonProperty("totalCost") int totalCost,
                 @JsonProperty("paymentMethods") List<CreditCard> paymentMethods) {

        LOG.info("Creating buyer account with email: " + email + " and password: " + password);
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pastOrders = pastOrders;
        this.paymentMethods = paymentMethods;
        this.cart = new ArrayList<Integer>();
        this.totalCost = 0;
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
     * Retrieves this buyer's email
     * 
     * @return buyer email
     */
    public String getEmail() {
        LOG.info("Retrieving buyer email: " + email);
        return email;
    }

    /**
     * Retrieves this buyer's password
     * 
     * @return buyer password
     */
    public String getPassword() {
        LOG.info("Retrieving buyer password: " + password);
        return password;
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
     * Retrieves this buyer's past orders
     * 
     * @return list of buyer's past orders
     */
    public List<Order> getPastOrders() {
        LOG.info("Retrieving buyer's past orders: " + pastOrders);
        return pastOrders;
    }

    /**
     * Retrieves this buyer's payment methods
     * 
     * @return list of buyer's payment methods
     */
    public List<CreditCard> getPaymentMethods() {
        LOG.info("Retrieving buyer's payment methods: " + paymentMethods);
        return paymentMethods;
    }

    /** 
     * Sets the buyer's email
     * 
     * @param email new email
     */
    public void setEmail(String email) {
        LOG.info("Setting buyer email: " + email);
        this.email = email;
    }

    /**
     * Sets the buyer's password
     * 
     * @param password new password
     */
    public void setPassword(String password) {
        LOG.info("Setting buyer password: " + password);
        this.password = password;
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
     * Sets the buyer's past orders
     * 
     * @param pastOrders new list of past orders
     */
    public void setPastOrders(List<Order> pastOrders) {
        LOG.info("Setting buyer's past orders: " + pastOrders);
        this.pastOrders = pastOrders;
    }

    /**
     * Sets the buyer's payment methods
     * 
     * @param paymentMethods new list of payment methods
     */
    public void setPaymentMethods(List<CreditCard> paymentMethods) {
        LOG.info("Setting buyer's payment methods: " + paymentMethods);
        this.paymentMethods = paymentMethods;
    }

    /**
     * Appends a new order to buyer's past orders
     * 
     * @param order order to be appended
     */
    public void addPastOrder(Order order) {
        LOG.info("Appending past order: " + order);
        pastOrders.add(order);
    }

    /**
     * Appends a new payment method to buyer's payment methods
     * 
     * @param creditCard credit card to be appended
     */
    public void addPaymentMethod(CreditCard creditCard) {
        LOG.info("Appending credit card: " + creditCard);
        paymentMethods.add(creditCard);
    }
    

    @JsonGetter("totalCost")
    public int getTotalCost(){
        return this.totalCost;
    }

    @JsonSetter("totalCost")
    public void setTotalCost(int cost){
        this.totalCost = cost;
    }

    @JsonGetter("cart")
    public Collection<Integer> getCart(){
        return cart;
    }

    public void addProductCart(Product product){
        this.cart.add(product.getId());
    }

    public void removeProductCart(Product product){
        this.cart.remove(product.getId());
    }


    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(STRING_FORMAT, id, email, password, firstName, lastName, 
                             phoneNumber, pastOrders, paymentMethods);
    }

}
