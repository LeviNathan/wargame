package Game;

import java.util.*;
import Deck.*;
import Player.*;

/**
 * 3rd variation of the war card game. Extends Wargame2. 
 * The only difference with this class from Wargame2 is the number of players.
 */
public class Wargame3 extends Wargame2 {

    public Wargame3(ArrayList<Player> playerList, Deck masterDeck) {
        super(3, playerList, masterDeck);
    }
}