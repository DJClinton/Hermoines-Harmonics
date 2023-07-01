package com.estore.api.estoreapi.model;

import java.util.Date;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a credit card payment method
 * 
 * @author Team 2
 */
public class CreditCard {
    private static final Logger LOG = Logger.getLogger(Product.class.getName());

    static final String STRING_FORMAT = "Credit Card [holdername=%s, cardNumber=%d, expDate=%s, securityCode=%d]";

    @JsonProperty("holderName") 
    private String holderName;
    @JsonProperty("cardNumber")
    private int cardNumber;
    @JsonProperty("expDate")
    private Date expirationDate;
    @JsonProperty("securityCode")
    private int securityCode;

    /**
     * Create a credit card for buyer use
     * 
     * @param holderName        name of the holder of the card
     * @param cardNumber        credit card number
     * @param expirationDate    expiration date of card
     * @param securityCode      card security code number
     */
    public CreditCard(@JsonProperty("holderName") String holderName, @JsonProperty("cardNumber") int cardNumber,
                      @JsonProperty("expDate") Date expirationDate, @JsonProperty("securityCode")int securityCode) {

        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        LOG.info("Creating " + this);
    }

    /**
     * Sets the holder name of the credit card
     * 
     * @param holderName new holder name
     */
    public void setHolderName(String holderName) {
        LOG.info("Setting credit card name to: " + holderName);
        this.holderName = holderName;
    }

    /**
     * Sets the credit card's number
     * 
     * @param cardNumber new credit card number
     */
    public void setCardNumber(int cardNumber) {
        LOG.info("Setting credit card number to: " + cardNumber);
        this.cardNumber = cardNumber;
    }

    /**
     * Sets the credit card's expiration date
     * 
     * @param expirationDate new expiration date
     */
    public void setExpirationDate(Date expirationDate) {
        LOG.info("Setting credit card expiration date to: " + expirationDate);
        this.expirationDate = expirationDate;
    }

    /**
     * Sets the credit card's security code
     * 
     * @param securityCode new security code
     */
    public void setSecurityCode(int securityCode) {
        LOG.info("Setting credit card security code to: " + securityCode);
        this.securityCode = securityCode;
    }

    /**
     * Retrieves the holder name of the credit card
     * 
     * @return holder name of the card
     */
    public String getHolderName() {
        LOG.info("Retrieving credit card name: " + holderName);
        return holderName;
    }

    /**
     * Retrieves the number of the credit card
     * 
     * @return card number
     */
    public int getCardNumber() {
        LOG.info("Retrieving credit card number: " + cardNumber);
        return cardNumber;
    }

    /**
     * Retrieves the expiration date of the credit card
     * 
     * @return card expiration date
     */
    public Date getExpirationDate() {
        LOG.info("Retrieving credit card expiration date: " + expirationDate);
        return expirationDate;
    }

    /**
     * Retrieves the security code of the credit card
     * 
     * @return card security code
     */
    public int getSecurityCode() {
        LOG.info("Retrieving credit card security code: " + securityCode);
        return securityCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(STRING_FORMAT, holderName, cardNumber, expirationDate, securityCode);
    }
    
}
