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
        int winScore = 0;
        String winner = "";
        
        for(int i = 0; i < numOfPlayers; i++){
            System.out.println(playerList.get(i).getName());
            System.out.println(playedCards.getDeck().get(i).getValue());
        }
        
        for(int i = 0; i < numOfPlayers; i++)
        {
            if(winScore == 0){
                winScore = playedCards.getDeck().get(i).getValue();
                winner = playerList.get(i).getName();
                continue;
            }
            if(winScore < playedCards.getDeck().get(i).getValue())
            {
                winScore = playedCards.getDeck().get(i).getValue();
                winner = playerList.get(i).getName();
            }
        }
        System.out.println(winner);
        for(int i = 0; i < numOfPlayers; i++){
            if(winner == playerList.get(i).getName()){
                playerList.get(i).addScore();
            }
        } 
        System.out.println(winner + " wins the round");
        System.out.printf("Score is ");
        for(int i = 0; i < numOfPlayers; i++){
            if(i < numOfPlayers-1)
                System.out.printf("%s %d, ", playerList.get(i).getName(), playerList.get(i).getScore());
            else
                System.out.printf("%s %d", playerList.get(i).getName(), playerList.get(i).getScore());
        }
        System.out.println();
    }
}