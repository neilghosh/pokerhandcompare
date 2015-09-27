/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ea.pokerhand;

import com.ea.entities.Hand;
import com.ea.utils.TestUntilities;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author neil
 */
public class HighCardTest {

    public HighCardTest() {
    }

    @Test
    public void testHighCardKingHigh() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C2-H4-D6-S8-CA");
        Hand h2 = TestUntilities.parseHand("D3-S5-D7-SJ-HK");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testHighCardWithSameHighestCard() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C2-H4-D6-S8-CA");
        Hand h2 = TestUntilities.parseHand("D3-S5-D7-SJ-HA");

        Assert.assertEquals(-1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testHighCardWithTie() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C2-H4-D6-S8-CA");
        Hand h2 = TestUntilities.parseHand("H2-C4-S6-D8-HA");

        Assert.assertEquals(0, pokerHand.evaluate(h1, h2));
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
