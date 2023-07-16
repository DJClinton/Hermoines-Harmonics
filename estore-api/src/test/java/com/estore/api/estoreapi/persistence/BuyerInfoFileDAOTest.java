package com.estore.api.estoreapi.persistence;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.estore.api.estoreapi.model.BuyerInfo;
import com.estore.api.estoreapi.model.CreditCard;
import com.estore.api.estoreapi.model.Order;
import com.estore.api.estoreapi.model.Order.OrderStatus;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


/**
 * Test the BuyerInfo File DAO Class
 * 
 * @author Team 2
 */
@Tag("Persistence-tier")
public class BuyerInfoFileDAOTest {
    BuyerInfoFileDAO buyerInfoFileDAO;
    BuyerInfo[] testBuyerInfos;
    ObjectMapper mockObjectMapper;

    @BeforeEach
    public void setupBuyerInfoFileDAO() throws IOException {
        mockObjectMapper = mock(ObjectMapper.class);
        testBuyerInfos = new BuyerInfo[1];


        CreditCard card = new CreditCard("John B. Buyer", 1234, new Date(), 333);
        testBuyerInfos[0] = new BuyerInfo(1, 2, "John", "Buyer", "555-123-4567", card);
        

        // When the object mapper is supposed to read from the file
        // the mock object mapper will return the buyerInfo array above
        when(mockObjectMapper
            .readValue(new File("doesnt_matter.txt"),BuyerInfo[].class))
                .thenReturn(testBuyerInfos);
        buyerInfoFileDAO = new BuyerInfoFileDAO("doesnt_matter.txt",mockObjectMapper);

    }

    @Test
    public void testGetBuyerInfos() {
        // Invoke
        BuyerInfo[] buyerInfos = buyerInfoFileDAO.getBuyerInfos();

        // Analyze
        assertArrayEquals(buyerInfos, testBuyerInfos);
    }

    @Test
    public void testGetBuyerInfo() {
        // Invoke
        BuyerInfo buyerInfo = buyerInfoFileDAO.getBuyerInfo(1);

        // Analzye
        assertEquals(buyerInfo, testBuyerInfos[0]);
    }

    @Test
    public void testCreateBuyerInfo() {
        // Setup
        BuyerInfo buyerInfo = new BuyerInfo(2, 3, "joe", "setup", 
                                "999-999-9999", new CreditCard("joe setup", 123, new Date(), 456));

        // Invoke
        BuyerInfo result = assertDoesNotThrow(() -> buyerInfoFileDAO.createBuyerInfo(buyerInfo),
                                "Unexpected exception thrown");

        // Analyze
        assertNotNull(result);
        BuyerInfo actual = buyerInfoFileDAO.getBuyerInfo(buyerInfo.getId());
        assertEquals(actual.getId(), buyerInfo.getId());
        assertEquals(actual.getUserId(), buyerInfo.getUserId());
        assertEquals(actual.getFirstName(), buyerInfo.getFirstName());
        assertEquals(actual.getLastName(), buyerInfo.getLastName());
        assertEquals(actual.getPhoneNumber(), buyerInfo.getPhoneNumber());
        assertEquals(actual.getPaymentMethod(), buyerInfo.getPaymentMethod());
    }

    @Test
    public void testUpdateBuyerInfo() {
        // Setup
        BuyerInfo buyerInfo = new BuyerInfo(2, 3, "joe", "setup", 
                                "999-999-9999", new CreditCard("joe setup", 123, new Date(), 456));

        // Invoke
        BuyerInfo result = assertDoesNotThrow(() -> buyerInfoFileDAO.updateBuyerInfo(buyerInfo),
                                "Unexpected exception thrown");

        // Analyze
        assertNotNull(result);
        BuyerInfo actual = buyerInfoFileDAO.getBuyerInfo(buyerInfo.getId());
        assertEquals(actual, buyerInfo);
    }

    @Test
    public void testDeleteBuyerInfo() {
        // Invoke
        boolean result = assertDoesNotThrow(() -> buyerInfoFileDAO.deleteBuyerInfo(1),
                            "Unexpected exception thrown");

        // Analzye
        assertEquals(result, true);
        // We check the internal tree map size against the length
        // of the test buyerInfos array - 1 (because of the delete)
        // Because buyerInfos attribute of BuyerInfoFileDAO is package private
        // we can access it directly
        assertEquals(buyerInfoFileDAO.buyerInfos.size(), testBuyerInfos.length - 1);
    }

}
