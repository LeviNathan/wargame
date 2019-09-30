package Deck;

import java.util.*;

/**
 * The score pile. It extends a deck and at similarly to a deck. But is the points of the player.
 * This is used in variation 2 and 3 (Wargame2 and Wargame3 classes)of the war card game.
 */
public class ScorePile extends Deck{

    /**
     * The constructor for the Scorepile.
     */
    public ScorePile(Stack<Card> deckOfCards, int size) {
        super(deckOfCards, size);
    }
}