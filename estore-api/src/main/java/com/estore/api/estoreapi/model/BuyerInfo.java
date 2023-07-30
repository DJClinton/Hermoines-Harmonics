package com.estore.api.estoreapi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the information for a buyer
 * 
 * @author Team 2
 */
public class BuyerInfo {
    private static final Logger LOG = Logger.getLogger(BuyerInfo.class.getName());

    static final String STRING_FORMAT = "Buyer [id=%d, user id=%d, first name=%s, last name=%s, phone number=%s, past orders=%s, credit cards=%s, shipping addresses=%s, cart=%s, wishlist=%s]";

    @JsonProperty("id")
    private int id;
    @JsonProperty("userId")
    private int userid;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("pastOrdersIds")
    private Collection<Integer> pastOrderIds;
    @JsonProperty("creditCards")
    private Collection<CreditCard> creditCards;
    @JsonProperty("shippingAddresses")
    private Collection<String> shippingAddresses;
    @JsonProperty("cart")
    private ArrayList<Integer> cart;
    @JsonProperty("wishlist")
    private ArrayList<Integer> wishlist;

    public BuyerInfo(
            @JsonProperty("id") int id,
            @JsonProperty("userId") int userid,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("pastOrdersIds") Collection<Integer> pastOrderIds,
            @JsonProperty("creditCards") Collection<CreditCard> creditCards,
            @JsonProperty("shippingAddresses") Collection<String> shippingAddresses,
            @JsonProperty("cart") ArrayList<Integer> cart,
            @JsonProperty("wishlist") ArrayList<Integer> wishlist) {

        this.id = id;
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pastOrderIds = pastOrderIds;
        this.creditCards = creditCards;
        this.shippingAddresses = shippingAddresses;
        this.cart = cart;
        this.wishlist = wishlist;
        LOG.info("Creating buyer info: " + this);
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
     * Retrieves this buyer's past order ids
     * 
     * @return list of buyer's past order ids
     */
    public Collection<Integer> getPastOrderIds() {
        LOG.info("Retrieving buyer's past order ids: " + pastOrderIds);
        return pastOrderIds;
    }

    /**
     * Retrieves this buyer's credit cards
     * 
     * @return list of buyer's credit cards
     */
    public Collection<CreditCard> getCreditCards() {
        LOG.info("Retrieving buyer's credit cards: " + creditCards);
        return creditCards;
    }

    /**
     * Retrieves this buyer's shipping addresses
     * 
     * @return list of buyer's shipping addresses
     */
    public Collection<String> getShippingAddresses() {
        return shippingAddresses;
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
     * @param creditCards new payment method
     */
    public void setCreditCards(Collection<CreditCard> creditCards) {
        LOG.info("Setting buyer's credit cards: " + creditCards);
        this.creditCards = creditCards;
    }

    /**
     * Sets the buyer's shipping addresses
     * 
     * @param shippingAddresses new shipping addresses
     */
    // @JsonSetter("shippingAddresses")
    public void setShippingAddresses(List<String> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    /**
     * Grabs the array of the ids in the cart
     * 
     * @return the ids of the items in the cart
     */

    // @JsonGetter("cart")
    public ArrayList<Integer> getCart() {
        return cart;
    }

    /**
     * Add a product into the cart
     * 
     * @param product
     */

    public void addProductCart(Product product) {
        this.cart.add(product.getId());
    }

    /**
     * Remove a product from the cart
     * 
     * @param product
     */

    public void removeProductCart(Product product) {
        this.cart.remove(product.getId());
    }

    /**
     * Grabs the array of the ids in the wishlist
     * 
     * @return the ids of the items in the cart
     */

    // @JsonGetter("wishlist")
    public ArrayList<Integer> getWishlist() {
        return wishlist;
    }

    /**
     * Add a product into the wishlist
     * 
     * @param product
     */

    public void addProductWishlist(Product product) {
        this.wishlist.add(product.getId());
    }

    /**
     * Remove a product from the wishlist
     * 
     * @param product
     */

    public void removeProductWishlist(Product product) {
        this.wishlist.remove(product.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(STRING_FORMAT, id, userid, firstName, lastName,
                phoneNumber, pastOrderIds, creditCards, shippingAddresses, cart, wishlist);
    }

}
