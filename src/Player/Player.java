package Player;

import Deck.*;

public class Player {
    private String name;
    private int score;
    private Deck playerDeck;

    public Player(Deck playerDeck, String name, int score) {
        this.name = name;
        this.score = score;
        this.playerDeck = playerDeck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Deck getDeck() {
        return playerDeck;
    }

    public void setDeck(Deck playerDeck) {
        this.playerDeck = playerDeck;
    }

    /**
     * @return
     * Takes a card from the top of the player's deck
     * to be played.
     */
    public Card playCard() {
        return playerDeck.removeCardFromTop();
    }

    /**
     * @param cardsWon
     * Adding cards to the bottom of the player's deck
     * Will be utilized when dealing the cards and 
     * when winning cards in variation1.
     */ 
    public void addCardsToDeck(Deck cardsWon) {
        playerDeck.addCardToBottom(cardsWon);
    }

    /**
     * @param cardsWon
     * Adding the cards won into the score instead of
     * back into the deck. This function is for 
     * variation2 and variation3
     */
    public void addingScore(Deck cardsWon) {
        while(!cardsWon.isEmpty()) {
            cardsWon.removeCardFromTop();
            score = score + 1;
        }
    }

}