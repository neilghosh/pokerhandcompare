package com.ea.entities;

import com.ea.utils.PokerUtilities;
import java.util.List;
import java.util.TreeMap;

/**
 * @author neil
 */
public class Hand {

    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public HandCategory assignCategory(TreeMap<Rank, Integer> m) {
        int highFreq = m.firstEntry().getValue();
        if (highFreq == 4) {
            return HandCategory.FOUR_OF_A_KIND;
        } else if (highFreq == 3) {
            int lowFreq = m.lastEntry().getValue();
            if (lowFreq == 2) {
                return HandCategory.FULL_HOUSE;
            } else {
                return HandCategory.THREE_OF_A_KIND;
            }
        } else if (highFreq == 2) {
            if (m.size() == 3) {
                return HandCategory.TWO_PAIR;

            } else {
                return HandCategory.ONE_PAIR;
            }
        }

        //Check for flush
        boolean flush = false;

        for (int i = 0; i < 4; i++) {
            if (cards.get(i).getSuite() == cards.get(i + 1).getSuite()) {
                flush = true;
                break;
            }
        }

        PokerUtilities.sortByRank(cards);

        if (cards.get(0).getRank().ordinal() - cards.get(cards.size() - 1).getRank().ordinal() == 4) {
            if (flush) {
                return HandCategory.STRAIGHT_FLUSH;
            } else {
                return HandCategory.STRAIGHT;
            }
        } else {
            if (flush) {
                return HandCategory.FLUSH;
            }
        }
        return HandCategory.HIGH_CARD;
    }

 
}
