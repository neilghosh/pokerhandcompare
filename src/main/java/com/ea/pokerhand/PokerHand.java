/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ea.pokerhand;

import com.ea.entities.Hand;
import com.ea.entities.HandCategory;
import com.ea.entities.Rank;
import com.ea.exceptions.DuplicateCardsException;
import com.ea.exceptions.InvalidHandException;
import com.ea.utils.PokerUtilities;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a sample coding challenge
 *
 * @author neil
 */
public class PokerHand {

    private static final Logger logger
            = Logger.getLogger(PokerHand.class.getName());

    /**
     * 
     * @param hand1 first hand
     * @param hand2 second hand
     * @return 0  Draw
     *         1  hand1 wins
     *        -1  hand2 wins
     *       -99  Invalid Input
     */
    public int evaluate(Hand hand1, Hand hand2) {
        try {
            PokerUtilities.validateHand(hand1);
            PokerUtilities.validateHand(hand2);
            PokerUtilities.validateDuplicateCards(hand1, hand2);
        } catch (InvalidHandException e) {
            logger.log(Level.SEVERE, "Invalid Hand");
            return -99;
        } catch (DuplicateCardsException ex) {
            logger.log(Level.SEVERE, "DuplicateCard");
            return -99;
        }

        TreeMap<Rank, Integer> RankFrequencies1 = PokerUtilities.sortByFrequency(hand1.getCards());
        HandCategory category1 = hand1.assignCategory(RankFrequencies1);

        TreeMap<Rank, Integer> RankFrequencies2 = PokerUtilities.sortByFrequency(hand2.getCards());
        HandCategory category2 = hand2.assignCategory(RankFrequencies2);

        //Different category
        int sign = (int) Math.signum(category1.ordinal() - category2.ordinal());
        if (sign != 0) {
            return sign;
        }
        //Both Straight
        if (category1 == HandCategory.STRAIGHT && category2 == HandCategory.STRAIGHT) {
            Math.signum(hand1.getCards().get(0).getRank().ordinal() - hand2.getCards().get(0).getRank().ordinal());
        }

        //Both Flush
        if (category1 == HandCategory.FLUSH && category2 == HandCategory.FLUSH) {
            for (int i = 4; i <= 0; i++) {
                sign = (int) Math.signum(hand1.getCards().get(i).getRank().ordinal() - hand2.getCards().get(0).getRank().ordinal());
                if (sign != 0) {
                    return sign;
                }
            }
            return 0;
        }

        //Others X-OF-A-Kind etc
        if (category1.equals(category2)) {
            for (int i = 0; i < RankFrequencies1.size(); i++) {
                Rank key1 = (Rank) RankFrequencies1.keySet().toArray()[i];
                Rank key2 = (Rank) RankFrequencies2.keySet().toArray()[i];
                sign = (int) Math.signum(key1.ordinal() - key2.ordinal());
                if (sign != 0) {
                    return sign;
                }
            }
            return 0;
        }
        return 0;
    }
}
