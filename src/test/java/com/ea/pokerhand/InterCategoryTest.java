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
 * Tests for the cases when hands are in different category 
 * @author neil
 */
public class InterCategoryTest {

    public InterCategoryTest() {
    }

    @Test
    public void StraightFlushVsFourOfAKindTests() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C2-C3-C4-C5-C6");
        Hand h2 = TestUntilities.parseHand("DA-SA-HA-CA-HK");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void FourOfAKindVsFullHouseOfAKindTests() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C2-H2-D2-S2-C4");
        Hand h2 = TestUntilities.parseHand("D3-S3-H3-SA-HA");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void FullHouseVsFlushTest() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("CK-CJ-C9-C7-C5");
        Hand h2 = TestUntilities.parseHand("D3-S3-H3-S6-H6");

        Assert.assertEquals(-1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void FlushVsStraightTest() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("CK-CJ-C9-C7-C5");
        Hand h2 = TestUntilities.parseHand("D3-S4-H5-S6-H7");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void StraightVsThreeOfAKindTest() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("CK-DK-HK-SA-CQ");
        Hand h2 = TestUntilities.parseHand("D3-S4-H5-S6-H7");

        Assert.assertEquals(-1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void ThreeOfAKindVsTwoPairTests() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("CK-HK-DK-SJ-CA");
        Hand h2 = TestUntilities.parseHand("D3-S3-H4-S4-H6");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void TwoPairTestsVsOnePair() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("CK-HK-DQ-SJ-CA");
        Hand h2 = TestUntilities.parseHand("D3-S3-H4-S4-H6");

        Assert.assertEquals(-1, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void OnePairVsHighCard() {
        PokerHand pokerHand = new PokerHand();
        Hand h1 = TestUntilities.parseHand("C2-H2-D4-S5-C6");
        Hand h2 = TestUntilities.parseHand("DA-SK-HQ-SJ-H9");

        Assert.assertEquals(1, pokerHand.evaluate(h1, h2));
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
