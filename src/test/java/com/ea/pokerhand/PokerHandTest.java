package com.ea.pokerhand;

import com.ea.entities.Card;
import com.ea.entities.Hand;
import com.ea.entities.Suite;
import com.ea.entities.Rank;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests for basic sanity of hand comparator
 * @author neil
 */
public class PokerHandTest {

    public PokerHandTest() {
    }

    
    @Test
    public void testEqualRanksDifferentSuites()  {
        PokerHand pokerHand = new PokerHand();

        List Cards1 = new ArrayList();
        Cards1.add(new Card(Suite.DIAMONDS, Rank.ACE));
        Cards1.add(new Card(Suite.CLUBS, Rank.TWO));
        Cards1.add(new Card(Suite.HEARTS, Rank.THREE));
        Cards1.add(new Card(Suite.SPADES, Rank.FOUR));
        Cards1.add(new Card(Suite.CLUBS, Rank.FOUR));

        Hand h1 = new Hand();
        h1.setCards(Cards1);

        List Cards2 = new ArrayList();
        Cards2.add(new Card(Suite.CLUBS, Rank.ACE));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.TWO));
        Cards2.add(new Card(Suite.SPADES, Rank.THREE));
        Cards2.add(new Card(Suite.HEARTS, Rank.FOUR));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.FOUR));

        Hand h2 = new Hand();
        h2.setCards(Cards2);

        Assert.assertEquals(0, pokerHand.evaluate(h1, h2));
    }

    @Test
    public void testEqualFlush()  {
        PokerHand pokerHand = new PokerHand();

        List Cards1 = new ArrayList();
        Cards1.add(new Card(Suite.CLUBS, Rank.ACE));
        Cards1.add(new Card(Suite.CLUBS, Rank.TWO));
        Cards1.add(new Card(Suite.CLUBS, Rank.FIVE));
        Cards1.add(new Card(Suite.CLUBS, Rank.THREE));
        Cards1.add(new Card(Suite.CLUBS, Rank.FOUR));

        Hand h1 = new Hand();
        h1.setCards(Cards1);

        List Cards2 = new ArrayList();
        Cards2.add(new Card(Suite.DIAMONDS, Rank.ACE));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.TWO));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.FOUR));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.THREE));
        Cards2.add(new Card(Suite.DIAMONDS, Rank.FIVE));

        Hand h2 = new Hand();
        h2.setCards(Cards2);

        Assert.assertEquals(0, pokerHand.evaluate(h1, h2));
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
