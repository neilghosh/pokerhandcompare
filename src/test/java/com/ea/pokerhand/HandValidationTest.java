/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ea.pokerhand;

import com.ea.entities.Card;
import com.ea.entities.Hand;
import com.ea.entities.Rank;
import com.ea.entities.Suite;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests of the cases when input hands are invalid.  
 * @author neil
 */
public class HandValidationTest {

    public HandValidationTest() {
    }

    @Test
    public void testHandsWithInsufficuentCards() {
        PokerHand pokerHand = new PokerHand();

        List Cards1 = new ArrayList();
        Cards1.add(new Card(Suite.CLUBS, Rank.ACE));

        Hand h1 = new Hand();
        h1.setCards(Cards1);

        List Cards2 = new ArrayList();
        Cards2.add(new Card(Suite.CLUBS, Rank.ACE));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.TWO));
        Cards2.add(new Card(Suite.HEARTS, Rank.THREE));
        Cards2.add(new Card(Suite.SPADES, Rank.FOUR));
        Cards2.add(new Card(Suite.CLUBS, Rank.FOUR));

        Hand h2 = new Hand();
        h2.setCards(Cards2);

        Assert.assertEquals(-99, pokerHand.evaluate(h1, h2));

    }

    @Test
    public void testHandsWithInterHandDuplicateCards() {
        PokerHand pokerHand = new PokerHand();

        List Cards1 = new ArrayList();
        Cards1.add(new Card(Suite.CLUBS, Rank.ACE));
        Cards1.add(new Card(Suite.DIAMONDS, Rank.FIVE));
        Cards1.add(new Card(Suite.HEARTS, Rank.SIX));
        Cards1.add(new Card(Suite.SPADES, Rank.SEVEN));
        Cards1.add(new Card(Suite.CLUBS, Rank.EIGHT));

        Hand h1 = new Hand();
        h1.setCards(Cards1);

        List Cards2 = new ArrayList();
        Cards2.add(new Card(Suite.CLUBS, Rank.ACE));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.TWO));
        Cards2.add(new Card(Suite.HEARTS, Rank.THREE));
        Cards2.add(new Card(Suite.SPADES, Rank.FOUR));
        Cards2.add(new Card(Suite.CLUBS, Rank.FOUR));

        Hand h2 = new Hand();
        h2.setCards(Cards2);
        Assert.assertEquals(-99, pokerHand.evaluate(h1, h2));

    }

    @Test
    public void testHandsWithIntraHandDuplicateCards() {
        PokerHand pokerHand = new PokerHand();

        List Cards1 = new ArrayList();
        Cards1.add(new Card(Suite.CLUBS, Rank.ACE));
        Cards1.add(new Card(Suite.DIAMONDS, Rank.FIVE));
        Cards1.add(new Card(Suite.HEARTS, Rank.SIX));
        Cards1.add(new Card(Suite.SPADES, Rank.SEVEN));
        Cards1.add(new Card(Suite.CLUBS, Rank.ACE));

        Hand h1 = new Hand();
        h1.setCards(Cards1);

        List Cards2 = new ArrayList();
        Cards2.add(new Card(Suite.CLUBS, Rank.KING));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.TWO));
        Cards2.add(new Card(Suite.HEARTS, Rank.THREE));
        Cards2.add(new Card(Suite.SPADES, Rank.FOUR));
        Cards2.add(new Card(Suite.CLUBS, Rank.FOUR));

        Hand h2 = new Hand();
        h2.setCards(Cards2);
        Assert.assertEquals(-99, pokerHand.evaluate(h1, h2));

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
