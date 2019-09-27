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

    public Boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }
    
	public void addCardToBottom(Deck cardsWon) {
        while(!cardsWon.isEmpty()) {
            deckOfCards.add(0, cardsWon.removeCardFromTop());
            size = size + 1;
        }
    }

    public Card removeCardFromTop() {
        size = size - 1;
        return deckOfCards.pop();
    }
}