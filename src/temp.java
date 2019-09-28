import Deck.*;
import Player.*;
//import Game.*;
import java.util.*;

public class temp{
    public static void main(String[] args) {
        Stack<Card> stackCard = new Stack<Card>();
        Deck tempDeck = new Deck(stackCard, 0);
        tempDeck.initializeDeck();
        Player player = new Player("Nathan", 0, tempDeck);

        
        System.out.println(player.getPlayerDeck().getDeck());
        System.out.println(player.getPlayerDeck().getSize());
        System.out.println();
        /*
        System.out.println(player.playCard().toString());
        System.out.println(player.getPlayerDeck().getSize());
        Card tempCard = new Card("NATHAN", 10, "CHAN");
        Stack<Card> winStack = new Stack<Card>();
        Deck winDeck = new Deck(winStack, 0);
        System.out.println();
        System.out.println(player.getScore());
        winDeck.addCardToTop(tempCard);
        winDeck.addCardToTop(tempCard);
        winDeck.addCardToTop(tempCard);
        System.out.println(winDeck.getSize());
        player.addCardsToDeck(winDeck);
        System.out.println(player.getScore());

        tempDeck.addCardToBottom(winDeck);
        System.out.println(tempDeck.getSize());
        System.out.println(tempDeck.getDeck().toString());
        Card printCard = tempDeck.removeCardFromTop();
        System.out.println(printCard);
        
        System.out.println(tempDeck.getSize());
*/

    }
}