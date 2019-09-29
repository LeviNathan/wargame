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

    public void removePlayer(Player loser) {
        playerList.remove(loser);
    }

    public Player printWinner(ArrayList<Player> players) {
        return findRoundWinner();
    }

    public Deck playCards(ArrayList<Player> playerList) {
        Stack<Card> cardStack = new Stack<Card>();
        Deck deckOfCardsPlayed = new Deck(cardStack, 0);
        for (int i = 0; i < playerList.size(); i++) {
            Card playedCard = playerList.get(i).getPlayerDeck().removeCardFromTop();
            deckOfCardsPlayed.addCardToTop(playedCard);
            System.out.println(playerList.get(i).getName() + " plays " + playedCard.toString());
        }
        return deckOfCardsPlayed;
    }

    public Player findRoundWinner() {
        Player winner = null;
        Stack<Card> cardsOfScorePile = new Stack<Card>();
        ScorePile scorePile = new ScorePile(cardsOfScorePile, 0);

        int warIndicator = 1;
        while (warIndicator == 1) {
            warIndicator = 0;
            Deck deckOfCardsPlayed = playCards(playerList);
            int best = 0;
            for (int i = 0; i < numOfPlayers; i++) {
                int playerCardValue  = deckOfCardsPlayed.getDeck().get(i).getValue();
                if (best < playerCardValue) {
                    warIndicator = 0;
                    best = playerCardValue;
                    winner = playerList.get(i);
                } else if (best == playerCardValue) {
                    warIndicator = 1;
                }
            }
            if (warIndicator == 1) {
                System.out.println("War!");    
                winner = null;
                deckOfCardsPlayed.addCardToBottom(warRound(playerList));
            }
            scorePile.addCardToBottom(deckOfCardsPlayed);
        }
        System.out.println(winner.getName() + " wins this round!");
        winner.getPointPile().addCardToBottom(scorePile);
        
        return winner;
    }


    public Deck warRound(ArrayList<Player> warPlayers) {
        Stack<Card> scorePile = new Stack<Card>();
        Deck deckOfScorePile = new Deck(scorePile, 0);
        for (int i = 0; i < warPlayers.size(); i++) {
            Card newCard = null;
            if (!warPlayers.get(i).getPlayerDeck().isEmpty()) {
                newCard = warPlayers.get(i).getPlayerDeck().removeCardFromTop();
            }
            if (warPlayers.get(i).getPlayerDeck().isEmpty()) {

            }
            deckOfScorePile.addCardToTop(newCard);
        }
        return deckOfScorePile;
    } 
}