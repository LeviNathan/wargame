package Game;

import java.util.*;
import Deck.*;
import Player.*;

/**
 * The 2nd variation of the war card game. It extends the WargameOriginal class. 
 * Contains 2 players but the cards will not return to playeys' hands when won.
 */
public class Wargame2 extends WargameOriginal{

    /**
     * Constructor for the class. Not different from the WargameOriginal classes' constructor.
     */
    public Wargame2(int numOfPlayers, ArrayList<Player> playerList, Deck masterDeck) {
        super(numOfPlayers, playerList, masterDeck);
    }
    
    /**
     * Starts the game of war.
     */
    public void startGame() {
        dealCards();
        ArrayList<Player> playersInPlay = super.getPlayerList();
        while (!playersInPlay.get(0).getPlayerDeck().isEmpty()) {
            findRoundWinner(playersInPlay);
            printScore();
            System.out.println();
        }
        addCardsToPlayerScore();
        declareWinner();
    }

    /**
     * Adds the cards from the player's decks and the players' scorepils at the end of the game.
     */
    public void addCardsToPlayerScore() {
        for (int i = 0; i < super.getNumOfPlayers(); i++) {
            Player player = super.getPlayerList().get(i);
            int finalScore = player.getPlayerDeck().getSize() + player.getPointPile().getSize();
            player.setScore(finalScore);
        }
    }

    /**
     * Finds the player with the most points and declares the winner.
     * Accounts for multiple winners.
     */
    public void declareWinner() {
        Player winner = new Player("", 0, null, null);
        String winnerStr = "";
        for (int i = 0; i < super.getNumOfPlayers(); i++) {
            if (super.getPlayerList().get(i).getScore() > winner.getScore()) {
                winner = super.getPlayerList().get(i);
                winnerStr = "";
            }
            else if (super.getPlayerList().get(i).getScore() == winner.getScore()) {
                winnerStr = winnerStr + " and " + super.getPlayerList().get(i).getName();
            }
        }
        System.out.println(winner.getName() + winnerStr + " wins!");
    }
   
    /**
     * Prints the score of all the players for each round that is played. 
     */
    public void printScore() {
        String scoreString = "Score is ";
        for (int i = 0; i < super.getNumOfPlayers(); i++) {
            if (i != 0) {
                scoreString = scoreString + ", ";
            }
            Player selectedPlayer= super.getPlayerList().get(i);
            scoreString = scoreString + selectedPlayer.getName() + " " + selectedPlayer.getPointPile().getSize();
        }
        System.out.println(scoreString);
    }
}