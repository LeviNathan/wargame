import Deck.*;
import Game.*;
import Player.*;
import java.util.*;

public class temp{
    public static void main(String[] args) {
        Stack<Card> stackCard1 = new Stack<Card>();
        Deck tempDeck1 = new Deck(stackCard1, 0);
        Stack<Card> scorePile1 = new Stack<Card>();
        ScorePile tempPile1 = new ScorePile(scorePile1, 0);
        Player player1 = new Player("Nathan", 0, tempDeck1, tempPile1);

        Stack<Card> stackCard2 = new Stack<Card>();
        Deck tempDeck2 = new Deck(stackCard2, 0);
        Stack<Card> scorePile2 = new Stack<Card>();
        ScorePile tempPile2 = new ScorePile(scorePile2, 0);
        Player player2 = new Player("Chan", 0, tempDeck2, tempPile2);

        
        Stack<Card> stackCard3 = new Stack<Card>();
        Deck tempDeck3 = new Deck(stackCard3, 0);
        Stack<Card> scorePile3 = new Stack<Card>();
        ScorePile tempPile3 = new ScorePile(scorePile3, 0);
        Player player3 = new Player("Solomon", 0, tempDeck3, tempPile3);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        
        Stack<Card> masterStack = new Stack<Card>();
        Deck masterDeck = new Deck(masterStack, 0);
        masterDeck.initializeDeck();
        masterDeck.shuffleDeck();

        Wargame3 game3 = new Wargame3(players, masterDeck);
        game3.startGame();


    }
}