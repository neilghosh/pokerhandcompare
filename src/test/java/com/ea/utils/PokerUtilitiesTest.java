/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ea.utils;

import com.ea.entities.Card;
import com.ea.entities.Rank;
import com.ea.entities.Suite;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests the utility methods used for tests
 * @author neil
 */
public class PokerUtilitiesTest {

    @Test
    public void sortByFrequencyAllDiffRankTest() {
        List cards = new ArrayList();
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.TWO));
        cards.add(new Card(Suite.CLUBS, Rank.FIVE));
        cards.add(new Card(Suite.CLUBS, Rank.THREE));
        cards.add(new Card(Suite.CLUBS, Rank.FOUR));

        TreeMap<Rank, Integer> map = PokerUtilities.sortByFrequency(cards);
        Assert.assertEquals(5, map.size());
        //All frequencies should be 1
        for (Integer i : map.values()) {
            Assert.assertEquals(1, i.intValue());
        }
    }

    @Test
    public void sortByFrequencyAllSameRankTest() {
        List cards = new ArrayList();
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.ACE));

        TreeMap<Rank, Integer> map = PokerUtilities.sortByFrequency(cards);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(5, map.firstEntry().getValue().intValue());
    }

    @Test
    public void sortByFrequencyRankTest() {
        List cards = new ArrayList();
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.TEN));
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.TEN));
        cards.add(new Card(Suite.CLUBS, Rank.ACE));

        TreeMap<Rank, Integer> map = PokerUtilities.sortByFrequency(cards);
        Assert.assertEquals(2, map.size());
        Assert.assertEquals(3, map.firstEntry().getValue().intValue());
        Assert.assertEquals(2, map.lastEntry().getValue().intValue());
    }
    
    @Test
    public void sortByFrequencyFrequencyTieTest() {
        List cards = new ArrayList();
        
        cards.add(new Card(Suite.CLUBS, Rank.TEN));
        cards.add(new Card(Suite.CLUBS, Rank.TEN));
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.ACE));
        cards.add(new Card(Suite.CLUBS, Rank.TWO));

        TreeMap<Rank, Integer> map = PokerUtilities.sortByFrequency(cards);
        Assert.assertEquals(3, map.size());
        Assert.assertEquals(Rank.ACE, map.firstEntry().getKey());
    }

    @Test
    public void sortByRankTest(){
        List<Card> cards = new ArrayList();
        cards.add(new Card(Suite.CLUBS, Rank.FIVE));
        cards.add(new Card(Suite.CLUBS, Rank.TWO));
        cards.add(new Card(Suite.CLUBS, Rank.SIX));
        cards.add(new Card(Suite.CLUBS, Rank.THREE));
        cards.add(new Card(Suite.CLUBS, Rank.FOUR));
        
        PokerUtilities.sortByRank(cards);
        Assert.assertEquals(Rank.SIX,cards.get(0).getRank());
        Assert.assertEquals(Rank.FIVE,cards.get(1).getRank());
        Assert.assertEquals(Rank.FOUR,cards.get(2).getRank());
        Assert.assertEquals(Rank.THREE,cards.get(3).getRank());
        Assert.assertEquals(Rank.TWO,cards.get(4).getRank());
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
