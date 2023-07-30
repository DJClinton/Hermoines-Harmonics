package com.estore.api.estoreapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Model-tier")
public class BuyerInfoTest {
    private int expectedId;
    private int expectedUserId;
    private String expectedName;
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
        expectedName = "joe smith";
        expectedPhoneNumber = "222-222-2222";

        expectedPastOrderIds = new ArrayList<>();
        expectedPastOrderIds.add(1);
        expectedPastOrderIds.add(2);

        CreditCard card = new CreditCard("joe smith", "1234");
        expectedCreditCards = new ArrayList<>();
        expectedCreditCards.add(card);

        expectedShippingAddresses = new ArrayList<>();
        expectedShippingAddresses.add("stupid town");

        expectedCart = new ArrayList<>();
        expectedCart.add(4);

        expectedWishlist = new ArrayList<>();
        expectedWishlist.add(5);


        buyerInfo = new BuyerInfo(expectedId, expectedUserId, expectedName, expectedPhoneNumber, expectedPastOrderIds, expectedCreditCards, 
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
    public void testName() {
        assertEquals(expectedName, buyerInfo.getName());
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
                                              expectedName, expectedPhoneNumber,
                                              expectedPastOrderIds, expectedCreditCards, 
                                              expectedShippingAddresses, expectedCart, expectedWishlist);

        assertEquals(expectedString, buyerInfo.toString());
    }
}
