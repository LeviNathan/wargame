package Game;

import java.util.*;
import Deck.*;
import Player.*;

public class Wargame2 extends WargameOriginal{

    public Wargame2(int numOfPlayers, ArrayList<Player> playerList, Deck masterDeck) {
        super(numOfPlayers, playerList, masterDeck);
    }
    
    public void startGame() {
        int i = 0;
        while (i < getNumOfPlayers()) {
            if (super.getPlayerList().get(i).getPlayerDeck().isEmpty()) {
                break;
            }
            playCards();
        }
        addCardsToPlayerScore();
        declareWinner();
    }

    public void addCardsToPlayerScore() {
        for (int i = 0; i < super.getNumOfPlayers(); i++) {
            Player player = super.getPlayerList().get(i);
            int finalScore = player.getPlayerDeck().getSize() + player.getPointPile().getSize();
            player.setScore(finalScore);
        }
    }
}