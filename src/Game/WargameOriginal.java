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

    public void printWinner(ArrayList<Player> players) {
        System.out.println(playCards(players) + " wins the round.");
    }

    public String playCards(ArrayList<Player> playerList) {
        Stack<Card> playedCards = new Stack<Card>();
        Deck cardsPlayed = new Deck(playedCards, 0);
        for (int i = 0; i < playerList.size(); i++) {
            Card playedCard = playerList.get(i).getPlayerDeck().removeCardFromTop();
            playedCards.add(i, playedCard);
            System.out.println(playerList.get(i).getName() + " plays " + playedCard.toString());
        }
        return findRoundWinner(cardsPlayed, playerList);
        
    }

    public String findRoundWinner(Deck playedCards, ArrayList<Player> playerList) {
        int winScore = 0;
        String winner = "";    
        int winScoreTemp = 0;
        ArrayList<Player> tempPlayer = new ArrayList<Player>();
        
        for(int i = 0; i < playerList.size(); i++)
        {
            if(winScore == 0){
                winScore = playedCards.getDeck().get(i).getValue();
                winner = playerList.get(i).getName();
                tempPlayer.add(playerList.get(i));
                continue;
            }
            if(winScoreTemp == 0 && winScore > 0){
                winScoreTemp = playedCards.getDeck().get(i).getValue();
                winner = playerList.get(i).getName();
                if(winScoreTemp > winScore){
                    tempPlayer.clear();
                    tempPlayer.add(playerList.get(i));
                }
                if(winScoreTemp == winScore)
                    tempPlayer.add(playerList.get(i));
                    continue;
            }
            if(winScore < playedCards.getDeck().get(i).getValue())
            {
                winScore = playedCards.getDeck().get(i).getValue();
                winner = playerList.get(i).getName();
                tempPlayer.clear();
                tempPlayer.add(playerList.get(i));
                continue;
            }
            if(winScore == playedCards.getDeck().get(i).getValue()){
                tempPlayer.add(playerList.get(i));
                System.out.println("War!");
                System.out.println(tempPlayer.size());
                return warRound(tempPlayer);
            }
        }
        return winner;
        /*
        for(int i = 0; i < numOfPlayers; i++){
            if(winner == playerList.get(i).getName()){
                playerList.get(i).addCardToScore();
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
        */
    }
    public String warRound(ArrayList<Player> players) {
        Stack<Card> playedCards = new Stack<Card>();
        Stack<Card> scorePileStack = new Stack<Card>();
        //Deck cardsPlayed = new Deck(playedCards, 0);
        for (int i = 0; i < players.size(); i++) {
            scorePileStack.add(players.get(i).getPlayerDeck().removeCardFromTop());
            //cardsPlayed.addCardToTop(players.get(i).getPlayerDeck().removeCardFromTop());
        }
        return playCards(players);
    }

    public void declareWinner() {
        Player winner = new Player("", 0, null, null);
        String winnerStr = "";
        for (int i = 0; i < numOfPlayers; i++) {
            if (playerList.get(i).getScore() > winner.getScore()) {
                winner = playerList.get(i);
                winnerStr = "";
            }
            else if (playerList.get(i).getScore() == winner.getScore()) {
                winnerStr = winnerStr + " and " + playerList.get(i).getName();
            }
        }
        System.out.println(winner.getName() + winnerStr + " wins!");
    }
    
}