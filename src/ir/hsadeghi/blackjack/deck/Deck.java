package ir.hsadeghi.blackjack.deck;

import ir.hsadeghi.blackjack.cards.Card;
import ir.hsadeghi.blackjack.cards.Rank;
import ir.hsadeghi.blackjack.cards.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private final List<Card> cards;
    private final Random random;

    public Deck() {
        cards = new ArrayList<>();
        random = new Random();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        animateShuffling();
        Collections.shuffle(cards, random);
    }

    public Card dealCard() {
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }

    public void animateShuffling() {
        for (int i = 0; i < 10; i++) {
            System.out.print("\rShuffling cards... ");
            System.out.print("\033[35m/\033[0m");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\rShuffling cards... ");
            System.out.print("\033[35m-\033[0m");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\rShuffling cards... ");
            System.out.print("\033[35m\\\033[0m");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
    }

}
