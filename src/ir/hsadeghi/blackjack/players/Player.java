package ir.hsadeghi.blackjack.players;

import ir.hsadeghi.blackjack.cards.Card;
import ir.hsadeghi.blackjack.cards.Rank;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> hand;
    private int score;

    public Player() {
        hand = new ArrayList<>();
        score = 0;
    }

    public void addCard(Card card) {
        hand.add(card);
        score += card.getRank().getValue();
        if (score > 21) {
            for (Card c : hand) {
                if (c.getRank() == Rank.ACE) {
                    score -= 10;
                    break;
                }
            }
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public boolean isBust() {
        return score > 21;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hand:  ");
        for (Card card : hand) {
            sb.append(card).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\nScore: ").append(score);
        return sb.toString();
    }

    public void resetHand() {
        if (hand.size() > 0) {
            hand.clear();
            score = 0;
        }
    }
}
