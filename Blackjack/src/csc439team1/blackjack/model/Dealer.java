package csc439team1.blackjack.model;

import java.util.ArrayList;

/**
 * Dealer class contains a private variable type Hand
 */
public class Dealer {
    /**
     * this is the collection of cards on the current Dealer hand
     */
    private Hand dealerHand = new Hand();

    /**
     * default no args constructor for Dealer()
     */
    public Dealer() {
    }

    /**
     * Getter method for Dealer's hand
     *
     * @return dealer's hand.
     */
    public ArrayList<Card> getHand() {
        return this.dealerHand.getCards();
    }

    /**
     * this method return Hand object consists of collection of cards
     *
     * @return Hand object
     */
    public Hand getDealerHand() {
        if (this.dealerHand.size() < 1) throw new IndexOutOfBoundsException();
        return this.dealerHand;
    }

    /**
     * Adds a card to the dealer's hand.
     * @param card Card returned from shoe.pick() will be added to dealer's hand.
     */
    public void addCard(Card card){
        dealerHand.addCard(card);
    }
}
