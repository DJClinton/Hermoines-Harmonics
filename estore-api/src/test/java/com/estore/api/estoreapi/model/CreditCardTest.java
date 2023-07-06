package com.estore.api.estoreapi.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Model-tier")
public class CreditCardTest {   
    @Test
    public void testCtor(){
        //Setup

        String holderName1 = "Parappa the Rapper";
        int cardNum1 = 55555555;
        Date exprDate1 = new Date(1688607420);
        int secCode1 = 123;

        //Invoke

        CreditCard card1 = new CreditCard(holderName1, cardNum1, exprDate1, secCode1);

        //Analyze
        assertEquals(holderName1, holderName1);
        assertEquals(card1.getExpirationDate(), exprDate1);
        assertEquals(card1.getCardNumber(), cardNum1);
        assertEquals(card1.getSecurityCode(), secCode1);
    }
    @Test
    public void testNotEquals(){
        //Setup

        String holderName1 = "Parappa the Rapper";
        int cardNum1 = 55555555;
        Date exprDate1 = new Date(1688607420);
        int secCode1 = 123;

        //Invoke

        CreditCard card1 = new CreditCard(holderName1, cardNum1, exprDate1, secCode1);


        //Setup
        String holderName2 = "Legoshi";
        int cardNum2 = 4444444;
        Date exprDate2 = new Date(1688607420);
        int secCode2 = 333;

        //Invoke

        CreditCard card2 = new CreditCard(holderName2, cardNum2, exprDate2, secCode2);


        //Analyze

        assertNotEquals(card1,card2);
    }

    public void testEquals(){
        //Setup

        String holderName1 = "Parappa the Rapper";
        int cardNum1 = 55555555;
        Date exprDate1 = new Date(1688607420);
        int secCode1 = 123;

        //Invoke

        CreditCard card1 = new CreditCard(holderName1, cardNum1, exprDate1, secCode1);


        //Setup
        String holderName2 = "Parappa the Rapper";
        int cardNum2 = 55555555;
        Date exprDate2 = new Date(1688607420);
        int secCode2 = 123;

        //Invoke

        CreditCard card2 = new CreditCard(holderName2, cardNum2, exprDate2, secCode2);


        //Analyze

        assertEquals(card1,card2);
    }
    @Test
    public void testToString(){
        //Setup
        String holderName = "Parappa the Rapper";
        int cardNum = 55555555;
        Date exprDate = new Date(1688607420);
        int secCode = 123;

        String expectedString = String.format(CreditCard.STRING_FORMAT, holderName, cardNum, exprDate, secCode);

        //Invoke
        CreditCard newCard = new CreditCard(holderName, cardNum, exprDate, secCode);
        String actualString = newCard.toString();

        //Analyze
        assertEquals(expectedString, actualString);


    }
}
