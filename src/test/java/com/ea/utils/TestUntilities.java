/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ea.utils;

import com.ea.entities.Card;
import com.ea.entities.Hand;
import com.ea.entities.Rank;
import com.ea.entities.Suite;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author neil
 */
public class TestUntilities {

    /**
     * @param handString encoded list of 5 cards 
     * @return Hand
     */
    public static Hand parseHand(String handString) {
        List<Card> cards = new ArrayList();
        String[] cardStrings = handString.split("-");
        for (String cardString : cardStrings) {
            Card c = parseCard(cardString);
            cards.add(c);
        }
        Hand h = new Hand();
        h.setCards(cards);
        return h;
    }

    private static Card parseCard(String cardString) {

        Suite s = parseSuite(cardString.charAt(0));
        Rank r = parseRank(cardString.charAt(1));
        return new Card(s, r);
    }

    private static Suite parseSuite(char c) {
        switch (c) {
            case 'C':
                return Suite.CLUBS;
            case 'H':
                return Suite.HEARTS;
            case 'D':
                return Suite.DIAMONDS;
            case 'S':
                return Suite.SPADES;
            default:
                throw new RuntimeException("Invalid Suite code " + c);

        }
    }

    private static Rank parseRank(char c) {
        switch (c) {
            case '2':
                return Rank.TWO;
            case '3':
                return Rank.THREE;
            case '4':
                return Rank.FOUR;
            case '5':
                return Rank.FIVE;
            case '6':
                return Rank.SIX;
            case '7':
                return Rank.SEVEN;
            case '8':
                return Rank.EIGHT;
            case '9':
                return Rank.NINE;
            case 'T':
                return Rank.TEN;
            case 'J':
                return Rank.JACK;
            case 'Q':
                return Rank.QUEEN;
            case 'K':
                return Rank.KING;
            case 'A':
                return Rank.ACE;
            default:
                throw new RuntimeException("Invalid Rank code " + c);

        }
    }
}
