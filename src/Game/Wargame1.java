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
        int i = 0;
        while (i < numOfRounds) {
            printWinner(super.getPlayerList());
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


}