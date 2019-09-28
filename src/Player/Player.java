package Player;

import Deck.*;

public class Player {
    private String name;
    private int score;
    private Deck playerDeck;

    public Player(String name, int score, Deck playerDeck) {
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

    public Deck getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(Deck playerDeck) {
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
        score = score + cardsWon.getSize();
        playerDeck.addCardToBottom(cardsWon);
    }

}