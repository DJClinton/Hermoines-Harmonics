package com.estore.api.estoreapi.persistence;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.estore.api.estoreapi.model.Order;
import com.estore.api.estoreapi.model.Order.OrderStatus;
import com.fasterxml.jackson.databind.ObjectMapper;

@Tag("Persistence-tier")
public class OrderFileDAOTest {

    OrderFileDAO orderFileDAO;
    Order[] orders;
    ObjectMapper mockObjectMapper;

    @BeforeEach
    public void setUpOrderFileDao() throws IOException{
        mockObjectMapper = mock(ObjectMapper.class);
        
        orders = new Order[3];
        int[] productId = {1, 2, 3};
        orders[0] =  new Order(productId, new Date(1689653389), OrderStatus.UNPROCESSED, 
                    0123, "9782 West Bayberry Street Cookeville, TN 38501", 0, 0);
        orders[1] = new Order(productId, new Date(1689653370), OrderStatus.UNPROCESSED, 
                    4567, "8622 Marconi St. Brookfield, WI 53045", 0, 0);
        orders[2] = new Order(productId, new Date(1689653379), OrderStatus.UNPROCESSED, 
                    8901, "50 Talbot Lane Bellmore, NY 11710, TN 38501", 0, 0);
    }
    

    @Test 
    public void testGetProductIDs(){

    }

    @Test
    public void testGetDate(){

    }

    @Test
    public void testGetOrderStatus(){

    }
    
    @Test
    public void testUpdateOrderStatus(){

    }

    @Test
    public void testGetCCDigits(){

    }
    
    @Test
    public void testGetAddress(){

    }

    @Test
    public void testGetOrderID(){

    }

    @Test
    public void testGetUserID(){

    }
}
