package Game;

import Player.*;
import Deck.*;
import java.util.*;

public class WargameOriginal {
    private int numOfPlayers;
    private ArrayList<Player> playerList;
    private Deck masterDeck;

    public WargameOriginal(int numOfPlayers, ArrayList<Player> playerList, Deck masterDeck) {
        this.numOfPlayers = numOfPlayers;
        this.playerList = playerList;
        this.masterDeck = masterDeck;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public Deck getMasterDeck() {
        return masterDeck;
    }

    public void setMasterDeck(Deck masterDeck) {
        this.masterDeck = masterDeck;
    }

    /**
     * Deals the cards to start the game.
     */
    public void dealCards() {
        int i = 0;
        while(!masterDeck.getDeck().empty()) {
            playerList.get(i).getPlayerDeck().addCardToTop(masterDeck.removeCardFromTop());
            i++;
            if (i == numOfPlayers) {
                i = 0;
            }
        }
    }

    public void playCards() {
        System.out.println("Hello");
        Stack<Card> playedCards = new Stack<Card>();
        Deck cardsPlayed = new Deck(playedCards, 0);
        for (int i = 0; i < numOfPlayers; i++) {
            Card playedCard = playerList.get(i).getPlayerDeck().removeCardFromTop();
            playedCards.add(i, playedCard);
            System.out.println(playerList.get(i).getName() + " plays " + playedCard.toString());
        }
        findRoundWinner(cardsPlayed);
    }

    public void findRoundWinner(Deck playedCards) {

    }
}