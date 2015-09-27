/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ea.utils;

import com.ea.entities.Card;
import com.ea.entities.Hand;
import com.ea.entities.Rank;
import com.ea.exceptions.DuplicateCardsException;
import com.ea.exceptions.InvalidHandException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author neil
 */
public class PokerUtilities {

    /**
     * This sorts the cards by frequency of the ranks and returns a map
     *
     * @param cards
     * @return
     */
    public static TreeMap sortByFrequency(List<Card> cards) {
        Map<Rank, Integer> map = new TreeMap();

        for (Card c : cards) {
            if (!map.containsKey(c.getRank())) {
                map.put(c.getRank(), 1);
            } else {
                map.put(c.getRank(), map.get(c.getRank()) + 1);
            }
        }

        RankMapComparator vc = new RankMapComparator(map);

        TreeMap sortedMap = new TreeMap(vc);
        sortedMap.putAll(map);

        //printMap(sortedMap);
        return sortedMap;
    }

    private void printMap(Map<Rank, Integer> map) {
        for (Map.Entry<Rank, Integer> e : map.entrySet()) {
            System.out.println("\n" + e.getKey().toString() + " " + e.getValue());
        }
    }

    /**
     * Does an in place sorting of cards based on its ranking 
     * @param cards 
     */
    public static void sortByRank(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getRank().compareTo(o1.getRank());
            }
        });

        cards.stream().sorted((object1, object2) -> {
            return object1.getRank().ordinal() - object2.getRank().ordinal();
        });
        //printCards(cards);
    }

    private static void printCards(List<Card> cards) {
        System.out.println("\n ------------------- CARDS --------------- \n");
        for (Card c : cards) {
            System.out.println(c.getSuite().toString() + " " + c.getRank().toString());
        }
    }

    public static void validateHand(Hand h) throws InvalidHandException {
        if (h.getCards().size() != 5) {
            throw new InvalidHandException("Invalid Hand");
        }

    }

    public static void validateDuplicateCards(Hand h1, Hand h2) throws DuplicateCardsException {
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(h1.getCards());
        allCards.addAll(h2.getCards());
        Set<Card> uniQueCards = new HashSet<>(allCards);
        if (uniQueCards.size() != allCards.size()) {
            throw new DuplicateCardsException("Duplicate Cards in the deck");
        }
    }

    //Compares the frequencies of the Ranks and sorts them in heighest to lowest
    //In case of same frequence higher ranks(key) are at the top
    static class RankMapComparator implements Comparator {

        Map map;

        public RankMapComparator(Map map) {
            this.map = map;
        }

        @Override
        public int compare(Object a, Object b) {
            int sign = (int) Math.signum(((Integer) map.get(b)) - ((Integer) map.get(a)));
            if (sign != 0) {
                return sign;
            } else {
                return (int) Math.signum(((Rank) b).ordinal() - ((Rank) a).ordinal());
            }
        }
    }
}
