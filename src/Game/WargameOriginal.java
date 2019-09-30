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
        int numOfCards = masterDeck.getSize()/numOfPlayers;
        for(int i = 0; i < numOfCards; i++) {
            for(int j = 0; j < numOfPlayers; j++) {
                playerList.get(j).getPlayerDeck().addCardToTop(masterDeck.removeCardFromTop());
            }
        }
    }

    public Deck playCards(ArrayList<Player> playerList) {
        Stack<Card> cardStack = new Stack<Card>();
        Deck deckOfCardsPlayed = new Deck(cardStack, 0);
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getPlayerDeck().isEmpty()) {
                return deckOfCardsPlayed;
            }
        }
        Card playedCard = null;
        for (int i = 0; i < playerList.size(); i++) {
            playedCard = playerList.get(i).getPlayerDeck().removeCardFromTop();
            if(playedCard != null) {
                deckOfCardsPlayed.addCardToTop(playedCard);
            }
        }
        return deckOfCardsPlayed;
    }

    public Player findRoundWinner(ArrayList<Player> playerList) {
        Player winner = null;
        Stack<Card> cardsOfScorePile = new Stack<Card>();
        ScorePile scorePile = new ScorePile(cardsOfScorePile, 0);

        int warIndicator = 1;
        while (warIndicator == 1) {
            warIndicator = 0;
            Deck deckOfCardsPlayed = playCards(playerList);
            if (deckOfCardsPlayed.isEmpty()) {
                return winner;
            }
            int best = 0;
            for (int i = 0; i < deckOfCardsPlayed.getSize(); i++) {
                Card playerCard = deckOfCardsPlayed.getDeck().get(i);
                int playerCardValue = playerCard.getValue();
                System.out.println(playerList.get(i).getName() + " plays " + playerCard.toString());
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

    public Deck warRound(ArrayList<Player> playerList) {
        Stack<Card> cardStack = new Stack<Card>();
        Deck deckOfCardsPlayed = new Deck(cardStack, 0);
        Card playedCard = null;
        for (int i = 0; i < playerList.size(); i++) {
            
            playedCard = playerList.get(i).getPlayerDeck().removeCardFromTop();
            if (playerList.get(i).getPlayerDeck().isEmpty()) {
                playerList.get(i).getPlayerDeck().addCardToTop(playedCard);
            } else {
                deckOfCardsPlayed.addCardToTop(playedCard);
            }
        }
        return deckOfCardsPlayed;
    }
}