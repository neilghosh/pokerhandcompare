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
 * Tests for the cases where hands are of same category 
 * @author neil
 */
public class XOfAKindTest {

    public XOfAKindTest() {
    }

    @Test
    public void testFourOfAKind() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C2-H2-D2-S2-C4");
        Hand h2 = TestUntilities.parseHand("C3-H3-S3-D3-H4");

        Assert.assertEquals(-1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testThreeOfAKind() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("CQ-HQ-DQ-S7-C4");
        Hand h2 = TestUntilities.parseHand("CJ-HJ-SJ-DA-HK");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testFullHouse() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("CQ-HQ-DQ-S7-C7");
        Hand h2 = TestUntilities.parseHand("CJ-HJ-SJ-DA-HA");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testTwoPairBothRanksHigh() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C5-H5-D6-S6-C7");
        Hand h2 = TestUntilities.parseHand("C8-H8-S9-D9-HT");

        Assert.assertEquals(-1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testTwoPairOneRanksHigh() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C5-H5-D9-S9-C7");
        Hand h2 = TestUntilities.parseHand("C8-H8-S6-D6-HT");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testTwoPairKickerInAction() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C5-H5-D9-S9-CA");
        Hand h2 = TestUntilities.parseHand("C9-H9-D5-S5-H4");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testOnePair() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C5-H5-D9-ST-CA");
        Hand h2 = TestUntilities.parseHand("C9-H9-D4-S2-H3");

        Assert.assertEquals(-1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testOnePairKickerInAction() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C5-H5-D9-S4-C2");
        Hand h2 = TestUntilities.parseHand("D5-S5-DA-SK-HQ");

        Assert.assertEquals(-1, pokerHand.evaluate(h1, h2));
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
