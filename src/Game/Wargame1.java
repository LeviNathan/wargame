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

            Player winner = printWinner(super.getPlayerList());
            winner.getPlayerDeck().addCardToBottom(winner.getPointPile());
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
   

}