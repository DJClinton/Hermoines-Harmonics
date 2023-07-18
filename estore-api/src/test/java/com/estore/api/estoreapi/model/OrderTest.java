package com.estore.api.estoreapi.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.estore.api.estoreapi.model.Order.OrderStatus;

@Tag("Model-tier")
public class OrderTest {
        
    @Test 
    public void testProductIDS(){
        //Setup

        Date date = new Date(1688607420);

        int[] ids = new int[3];
        ids[0] = 1;
        ids[1] = 2;
        ids[2] = 3;
        
        //Invoke
        Order order = new Order(ids, date, OrderStatus.SHIPPED);

        //Analyze
        assertEquals(ids, order.getProductIds());
    }

    @Test
    public void testOrderStatus(){
        //Setup
        Date date = new Date(1688607420);

        int[] ids = new int[3];
        ids[0] = 1;
        ids[1] = 2;
        ids[2] = 3;
        
        //Invoke
        Order order1 = new Order(ids, date, OrderStatus.SHIPPED);
        Order order2 = new Order(ids, date, OrderStatus.DELIVERED);
        
        //Analyze
        assertNotEquals(order1, order2);
    }

    @Test
    public void testDate(){

    }

    @Test
    public void testDate(){

    }

    @Test
    public void testToString(){
        //Setup
        Date date = new Date(1688607420);

        int[] ids = new int[3];
        ids[0] = 1;
        ids[1] = 2;
        ids[2] = 3;


        String expectedString = String.format(Order.STRING_FORMAT, Arrays.toString(ids), date, OrderStatus.SHIPPED);

        
        //Invoke
        Order order = new Order(ids, date, OrderStatus.SHIPPED);

        String actualString = order.toString();

        assertEquals(expectedString, actualString);

    }
}
