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

}