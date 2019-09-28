import Deck.*;
import Game.*;
import Player.*;
import java.util.*;

public class temp{
    public static void main(String[] args) {
        Stack<Card> stackCard1 = new Stack<Card>();
        Deck tempDeck1 = new Deck(stackCard1, 0);
        Player player1 = new Player("Nathan", 0, tempDeck1);

        Stack<Card> stackCard2 = new Stack<Card>();
        Deck tempDeck2 = new Deck(stackCard2, 0);
        Player player2 = new Player("Chan", 0, tempDeck2);

        
        Stack<Card> stackCard3 = new Stack<Card>();
        Deck tempDeck3 = new Deck(stackCard3, 0);
        Player player3 = new Player("Solomon", 0, tempDeck3);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Stack<Card> masterStack = new Stack<Card>();
        Deck masterDeck = new Deck(masterStack, 0);
        masterDeck.initializeDeck();
        //WargameOriginal game = new WargameOriginal(players.size(), players, masterDeck);
        
        //System.out.println(game.getMasterDeck().getDeck());
        //game.dealCards();
        System.out.println("Game1");
        Wargame1 game1 = new Wargame1(players, masterDeck, 10);
        //game1.dealCards();
        System.out.println(game1.getNumOfPlayers());


        System.out.println("Game2");
        Wargame2 game2 = new Wargame2(2, players, masterDeck);
        //game2.dealCards();
        System.out.println(game2.getNumOfPlayers());

        System.out.println("Game3");
        Wargame3 game3 = new Wargame3(players, masterDeck);
        game3.dealCards();
        System.out.println(game3.getNumOfPlayers());
        

        System.out.println(game3.getMasterDeck().getSize());
        for (int i = 0; i < game3.getNumOfPlayers(); i++) {
            System.out.println();
            System.out.println(game3.getPlayerList().get(i).getPlayerDeck().getSize());
        }

        game3.playCards();
        for (int i = 0; i < game3.getNumOfPlayers(); i++) {
            System.out.println();
            System.out.println(game3.getPlayerList().get(i).getPlayerDeck().getSize());
        }


        /*
        System.out.println(player.getPlayerDeck().getDeck());
        System.out.println(player.getPlayerDeck().getSize());
        System.out.println();
        */


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