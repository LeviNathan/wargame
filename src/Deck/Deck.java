package Deck;

import java.util.*;

/**
 * Deck class. Contains the stack of card objects and the size of the deck.
 */
public class Deck {
    private Stack<Card> deckOfCards;
    private int size;

    /**
     * Deck constructor.
     */
    public Deck(Stack<Card> deckOfCards, int size) {
        this.deckOfCards = deckOfCards;
        this.size = size;
    }

    /**
     * Getter for the stack of card objects.
     * @return
     */
    public Stack<Card> getDeck() {
        return deckOfCards;
    }

    /**
     * Setter for the stack of card objects.
     * @param deckOfCards
     */
    public void setDeck(Stack<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    /**
     * Getter for the size of the deck.
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter for the size of the deck.
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Checks if the deck is empty.
     * @return
     */
    public Boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Will add cards to the bottom of the deck. Will also change the size of the
     * deck when a card is added.
     * @param cardsWon
     */
    public void addCardToBottom(Deck cardsWon) {
        while (!cardsWon.isEmpty()) {
            if(deckOfCards.isEmpty()) {
                deckOfCards.add(cardsWon.removeCardFromTop());
            } else {
                deckOfCards.add(0, cardsWon.removeCardFromTop());
            }
            size = size + 1;
        }
    }

    /**
     * Will remove a card from the top of the deck to be played. Adjust the deck
     * size accordingly.
     * @return
     */
    public Card removeCardFromTop() {
        if (deckOfCards.isEmpty()) {
            return null;
        }
        size = size - 1;
        return deckOfCards.pop();
    }

    /**
     * For dealing purposes. Adds one card to the top of the deck.
     * @param card
     */
    public void addCardToTop(Card card) {
        deckOfCards.push(card);
        size = size + 1;
    }

    /**
     * Creates the deck and shuffles the deck.
     */
    public void initializeDeck() {
        String [] suits = { "CLUBS", "CLOVER", "DIAMOND", "HEARTS" };
        String [] values = { "ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
                            "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card tempCard = new Card(suits[i], j + 1, values[j]);
                addCardToTop(tempCard);
            }
        }
    }

    /**
     * Shuffles the deck of cards
     */    
    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }

}