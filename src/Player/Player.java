package Player;

import Deck.*;

/**
 * Player class. Contains the name, score, deck, and the cards within the points pile of the player.
 */
public class Player {
    private String name;
    private int score;
    private Deck playerDeck;
    private ScorePile pointsPile;

    /**
     * Constructor for the player.
     */
    public Player(String name, int score, Deck playerDeck, ScorePile pointsPile) {
        this.name = name;
        this.score = score;
        this.playerDeck = playerDeck;
        this.pointsPile = pointsPile;
    }

    /**
     * Getter for the name of the player.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the player.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the score of the player.
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter for the score of the player.
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter for the player's deck.
     * @return
     */
    public Deck getPlayerDeck() {
        return playerDeck;
    }

    /**
     * Setter for the player's deck.
     * @param playerDeck
     */
    public void setPlayerDeck(Deck playerDeck) {
        this.playerDeck = playerDeck;
    }

    /**
     * Getter for the pile of cards within the points pile.
     * @return
     */
    public ScorePile getPointPile() {
        return pointsPile;
    }

    /**
     * Setter for the points pile.
     * @param pointPile
     */
    public void setPointsPile(ScorePile pointPile) {
        this.pointsPile = pointPile;
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
     * Adds the cards to the score of the player and not
     * to the bottom of the player's deck. This is for 
     * variation2 and variation3.
     * @param cardsWon
     */
    public void addCardsToScore(Deck cardsWon) {
        while(!cardsWon.isEmpty()) {
            cardsWon.removeCardFromTop();
            score = score + 1;
        }
    }
}