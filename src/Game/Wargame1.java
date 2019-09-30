package Game;

import java.util.*;

import Deck.*;
import Player.*;

/**
 * Variation of 1 of the War card game. Contains 2 players and the cards won each round will be 
 * added back into the winner's hand. Extends the main WargameOriginal class.
 */
public class Wargame1 extends WargameOriginal {
    private int numOfRounds;

    /**
     * Constructor for the 1st variation of the War card game. Extends the man wargame class
     * but also adds a parameter of the number of rounds for the game to last.
     * @param playerList
     * @param masterDeck
     * @param numOfRounds
     */
    public Wargame1(ArrayList<Player> playerList, Deck masterDeck, int numOfRounds) {
        super(2, playerList, masterDeck);
        this.numOfRounds = numOfRounds;
    }

    /**
     * Getter for the number of rounds of the war game.
     */
    public int getNumOfRounds() {
        return numOfRounds;
    }

    /**
     * Setter for the number of rounds of the war game.
     */
    public void setNumOfRounds(int numOfRounds) {
        this.numOfRounds = numOfRounds;
    }

    /**
     * Starts the game of the 1st variation.
     */
    public void startGame() {
        dealCards();
        int i = 0;
        while (i < numOfRounds) {
            Player winner = findRoundWinner(super.getPlayerList());
            if(winner == null) {
                break;
            }
            winner.getPlayerDeck().addCardToBottom(winner.getPointPile());
            Player player1 = super.getPlayerList().get(0);
            Player player2 = super.getPlayerList().get(1);
            System.out.println("Score is: " + player1.getName() + " " + player1.getPlayerDeck().getSize() + ", " 
                                            + player2.getName() + " " + player2.getPlayerDeck().getSize());
            System.out.println();
            i++;
        }
        setPlayerScore();
        System.out.println(declareWinner());
    }

    /**
     * Sets each of the players' scores to the number of cards within their decks.
     */
    public void setPlayerScore() {
        for (int i = 0; i < super.getNumOfPlayers(); i++) {
            Player selectedPlayer = super.getPlayerList().get(i);
            selectedPlayer.setScore(selectedPlayer.getPlayerDeck().getSize());
        }
    }

    /**
     * Finds the winner of the game and declares them as the winner.
     * Accounts for Tie games.
     */
    public String declareWinner() {
        Player winner = new Player("", 0, null, null);
        for (int i = 0; i < super.getNumOfPlayers(); i++) {
            if (super.getPlayerList().get(i).getScore() > winner.getScore()) {
                winner = super.getPlayerList().get(i);
            }
            else if (super.getPlayerList().get(i).getScore() == winner.getScore()) {
                System.out.println("Tie Game!");
                return"";
            }
        }
        return winner.getName() + " wins!";
    }
}