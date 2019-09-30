package Game;

import java.util.*;

import Deck.*;
import Player.*;

public class Wargame1 extends WargameOriginal {
    private int numOfRounds;

    public Wargame1(ArrayList<Player> playerList, Deck masterDeck, int numOfRounds) {
        super(2, playerList, masterDeck);
        this.numOfRounds = numOfRounds;
    }

    public int getNumOfRounds() {
        return numOfRounds;
    }

    public void setNumOfRounds(int numOfRounds) {
        this.numOfRounds = numOfRounds;
    }

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
        declareWinner();
    }

    public void setPlayerScore() {
        for (int i = 0; i < super.getNumOfPlayers(); i++) {
            Player selectedPlayer = super.getPlayerList().get(i);
            selectedPlayer.setScore(selectedPlayer.getPlayerDeck().getSize());
        }
    }

    public void declareWinner() {
        Player winner = new Player("", 0, null, null);
        for (int i = 0; i < super.getNumOfPlayers(); i++) {
            if (super.getPlayerList().get(i).getScore() > winner.getScore()) {
                winner = super.getPlayerList().get(i);
            }
            else if (super.getPlayerList().get(i).getScore() == winner.getScore()) {
                System.out.println("Tie Game!");
                return;
            }
        }
        System.out.println(winner.getName() + " wins!");
    }
   

}