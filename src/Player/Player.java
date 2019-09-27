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

    public Card playCard() {
        return playerDeck.removeCardFromTop();
    }

    public void addCardsToDeck(Deck cardsWon) {
        playerDeck.addCardToBottom(cardsWon);
    }

    public void addingScore(Deck cardsWon) {
        while(!cardsWon.isEmpty()) {
            cardsWon.removeCardFromTop();
            score = score + 1;
        }
    }

}