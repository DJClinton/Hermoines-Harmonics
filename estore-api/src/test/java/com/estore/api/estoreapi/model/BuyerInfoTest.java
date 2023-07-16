package com.estore.api.estoreapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.estore.api.estoreapi.model.Order.OrderStatus;

@Tag("Model-tier")
public class BuyerInfoTest {
    private int expectedId;
    private int expectedUserId;
    private String expectedFirstName;
    private String expectedLastName;
    private String expectedPhoneNumber;
    private CreditCard expectedPaymentMethod;
    private BuyerInfo buyerInfo;
    
    @BeforeEach
    public void setupBuyerInfoTest() {
        expectedId = 1;
        expectedUserId = 2;
        expectedFirstName = "joe";
        expectedLastName = "smith";
        expectedPhoneNumber = "222-222-2222";
        expectedPaymentMethod = new CreditCard("joe smith", 1234, new Date(), 321);
        buyerInfo = new BuyerInfo(expectedId, expectedUserId, expectedFirstName, 
                          expectedLastName, expectedPhoneNumber, expectedPaymentMethod);
    }


    @Test
    public void testID() {
        assertEquals(expectedId, buyerInfo.getId());
    }

    @Test
    public void testUserId() {
        assertEquals(expectedUserId, buyerInfo.getUserId());
    }

    @Test
    public void testFirstName() {
        assertEquals(expectedFirstName, buyerInfo.getFirstName());
    }

    @Test
    public void testLastName() {
        assertEquals(expectedLastName, buyerInfo.getLastName());
    }

    @Test
    public void testPhoneNumber() {
        assertEquals(expectedPhoneNumber, buyerInfo.getPhoneNumber());
    }

    @Test
    public void testPaymentMethod() {
        assertEquals(expectedPaymentMethod, buyerInfo.getPaymentMethod());
    }

    @Test
    public void testToString() {
        String expectedString = String.format(BuyerInfo.STRING_FORMAT, expectedId, expectedUserId, 
                                              expectedFirstName, expectedLastName, expectedPhoneNumber,
                                              expectedPaymentMethod);

        assertEquals(expectedString, buyerInfo.toString());
    }
}
