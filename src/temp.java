import Deck.*;
import java.util.*;

public class temp{
    public static void main(String[] args) {
        Stack<Card> stackCard = new Stack<Card>();
        Deck tempDeck = new Deck(stackCard, 0);
        tempDeck.initializeDeck();

        /*System.out.println(tempDeck.getSize());
        System.out.println();
        System.out.println();
        Card tempCard = new Card("NATHAN", 10, "CHAN");
        Stack<Card> winStack = new Stack<Card>();
        Deck winDeck = new Deck(winStack, 0);

        winDeck.addCardToTop(tempCard);
        winDeck.addCardToTop(tempCard);
        winDeck.addCardToTop(tempCard);
        System.out.println(winDeck.getSize());
        
        tempDeck.addCardToBottom(winDeck);
        System.out.println(tempDeck.getSize());
        System.out.println(tempDeck.getDeck().toString());
        Card printCard = tempDeck.removeCardFromTop();
        System.out.println(printCard);
        
        System.out.println(tempDeck.getSize());
*/

    }
}