package com.estore.api.estoreapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
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
    private Collection<Integer> expectedPastOrderIds;
    private Collection<CreditCard> expectedCreditCards;
    private Collection<String> expectedShippingAddresses;
    private Collection<Integer> expectedCart;
    private Collection<Integer> expectedWishlist;
    private BuyerInfo buyerInfo;
    
    @BeforeEach
    public void setupBuyerInfoTest() {
        expectedId = 1;
        expectedUserId = 2;
        expectedFirstName = "joe";
        expectedLastName = "smith";
        expectedPhoneNumber = "222-222-2222";

        expectedPastOrderIds = new ArrayList<>();
        expectedPastOrderIds.add(1);
        expectedPastOrderIds.add(2);

        CreditCard card = new CreditCard("joe smith", 1234);
        expectedCreditCards = new ArrayList<>();
        expectedCreditCards.add(card);

        expectedShippingAddresses = new ArrayList<>();
        expectedShippingAddresses.add("stupid town");

        expectedCart = new ArrayList<>();
        expectedCart.add(4);

        expectedWishlist = new ArrayList<>();
        expectedWishlist.add(5);


        buyerInfo = new BuyerInfo(expectedId, expectedUserId, expectedFirstName, 
                          expectedLastName, expectedPhoneNumber, expectedPastOrderIds, expectedCreditCards, 
                          expectedShippingAddresses, expectedCart, expectedWishlist);
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
    public void testPastOrderIds() {
        assertEquals(expectedPastOrderIds, buyerInfo.getPastOrderIds());
    }

    @Test
    public void testCreditCards() {
        assertEquals(expectedCreditCards, buyerInfo.getCreditCards());
    }

    @Test
    public void testShippingAddresses() {
        assertEquals(expectedShippingAddresses, buyerInfo.getShippingAddresses());
    }

    @Test
    public void testCart() {
        assertEquals(expectedCart, buyerInfo.getCart());
    }

    @Test
    public void testWishlist() {
        assertEquals(expectedWishlist, buyerInfo.getWishlist());
    }

    @Test
    public void testToString() {
        String expectedString = String.format(BuyerInfo.STRING_FORMAT, expectedId, expectedUserId, 
                                              expectedFirstName, expectedLastName, expectedPhoneNumber,
                                              expectedPastOrderIds, expectedCreditCards, 
                                              expectedShippingAddresses, expectedCart, expectedWishlist);

        assertEquals(expectedString, buyerInfo.toString());
    }
}
