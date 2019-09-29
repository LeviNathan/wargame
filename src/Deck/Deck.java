package Deck;

import java.util.*;

public class Deck {
    private Stack<Card> deckOfCards;
    private int size;

    public Deck(Stack<Card> deckOfCards, int size) {
        this.deckOfCards = deckOfCards;
        this.size = size;
    }

    public Stack<Card> getDeck() {
        return deckOfCards;
    }

    public void setDeck(Stack<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return Checks if the deck is empty.
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
     * 
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
     * 
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
     * 
     * @param card
     */
    public void addCardToTop(Card card) {
        if(card == null) {
            return;
        }
        deckOfCards.add(card);
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
        Collections.shuffle(deckOfCards);
    }

    public void shuffleDeck(Stack<Card> deckOfCards) {
        Collections.shuffle(deckOfCards);
    }

}