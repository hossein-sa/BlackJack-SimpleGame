package ir.hsadeghi.blackjack;

import ir.hsadeghi.blackjack.cards.Card;
import ir.hsadeghi.blackjack.deck.Deck;
import ir.hsadeghi.blackjack.players.Player;

import java.util.Scanner;

public class BlackJack {
    private final Deck deck;
    private final Player player;
    private final Player dealer;
    private final Scanner scanner;
    private boolean playing;

    public BlackJack() {
        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Player();
        this.scanner = new Scanner(System.in);
        this.playing = true;
    }

    public void play() {
        System.out.println("Welcome to BlackJack!");


        while (playing) {
            deck.shuffle();

            player.resetHand();
            dealer.resetHand();

            player.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());

            System.out.println("Dealer shows: " + dealer.getHand().get(0));
            System.out.println("Your " + player);

            while (true) {
                System.out.print("Do you want to hit or stand? ");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("hit")) {
                    Card card = deck.dealCard();
                    player.addCard(card);
                    System.out.println("You drew a " + card + ".");
                    System.out.println("Score: " + player.getScore());
                    if (player.isBust()) {
                        System.out.println("You busted! Dealer wins");
                        break;
                    }
                } else if (input.equals("stand")) {
                    break;
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            }

            if (!player.isBust()) {
                System.out.println("Dealer's turn.");
                while (dealer.getScore() < 17) {
                    Card card = deck.dealCard();
                    dealer.addCard(card);
                    System.out.println("Dealer drew a " + card + ".");
                    if (dealer.isBust()) {
                        System.out.println("Dealer busted! You win!");
                        break;
                    }
                }
            }

            if (!player.isBust() && !dealer.isBust()) {
                if (player.getScore() > dealer.getScore()) {
                    System.out.println("You win!");
                } else if (dealer.getScore() > player.getScore()) {
                    System.out.println("Dealer wins!");
                } else {
                    System.out.println("It's a tie!");
                }
            }

            // Ask if the player wants to play again
            System.out.print("\nDo you want to play again? (Y/N): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                playing = false;
            }
        }

        System.out.println("\nThanks for playing Blackjack!");
        System.out.println("\nAll right reserved for Hossein Sadeghi (sadeghi.ho@hotmail.com)\nHave fun!");
        scanner.close();
    }
}
