package csc439team1.blackjack.controller;

import csc439team1.blackjack.model.Dealer;
import csc439team1.blackjack.model.Player;
import csc439team1.blackjack.model.Shoe;
import csc439team1.blackjack.view.View;

/**
 * Controller class contains 3 attributes: View object, Player object and Dealer object
 */
public class Controller {
    View view;
    Player player = new Player();
    Dealer dealer = new Dealer();

    /**
     * constructor for Controller that takes view object
     * @param view is the object view
     */
    public Controller(View view) {
        this.view = view;
    }

    /**
     * this is the method that starts the game by creating a shoe object that contains 1 deck
     * then call buyChips(), askBet(), and initialDeal(shoe) function
     */
    public void playBlackjack() {
        Shoe shoe = new Shoe(1);
        buyChips();
        askBet();
        initialDeal(shoe);
    }

    /**
     * this methods displays the game is starting and ask the player the amount of chips to buy and set the chips amount
     */
    public void buyChips() {
        view.output("Game is starting.....how much chips do you want to buy (between $10 to $5000): ");
        String input = view.input();
        if (input.equals("quit")) quit();
        int amount = Integer.parseInt(input);
        if (amount > 5000 || amount < 10) {
            throw new IllegalArgumentException();
        }
        player.setChips(amount);
    }

    /**
     * this method ask player the amount to bet and deduct the chip amount from player
     */
    public void askBet() {
        view.output("How much do you want to bet (between $10 to $500): ");
        String input = view.input();
        if (input.equals("quit")) quit();
        int bet = Integer.parseInt(input);
        if (bet > player.getChips() || bet > 500 || bet < 10) {
            throw new IllegalArgumentException();
        }
        player.setChips(player.getChips() - bet);
    }

    /**
     * this method deal 2 cards to player and 2 cards to dealer, shows the first 2 of player cards and 1 dealer card
     * @param shoe is Shoe object
     */
    public void initialDeal(Shoe shoe) {
        player.addCard(shoe.pick());
        player.addCard(shoe.pick());
        dealer.addCard(shoe.pick());
        dealer.addCard(shoe.pick());
        view.output("\nDealer card: ");
        view.output(dealer.getHand().get(0).toString() + "\n\n");
        view.output("Your initial cards are: ");
        view.output(player.getHand().toString() + "\n");
    }

    /**
     * this method displays quit notification and gracefully exit the game
     */
    public void quit() {
        view.output("Player has quit");
        System.exit(0);
    }
}
