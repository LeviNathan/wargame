import Deck.*;
import Game.*;
import Player.*;
import java.util.*;

public class temp{
    public static void main(String[] args) {
        Stack<Card> stackCard1 = new Stack<Card>();
        Deck tempDeck1 = new Deck(stackCard1, 0);
        ScorePile tempPile1 = new ScorePile(null, 5);
        Player player1 = new Player("Nathan", 0, tempDeck1, tempPile1);

        Stack<Card> stackCard2 = new Stack<Card>();
        Deck tempDeck2 = new Deck(stackCard2, 0);
        ScorePile tempPile2 = new ScorePile(null, 3);
        Player player2 = new Player("Chan", 0, tempDeck2, tempPile2);

        
        Stack<Card> stackCard3 = new Stack<Card>();
        Deck tempDeck3 = new Deck(stackCard3, 0);
        ScorePile tempPile3 = new ScorePile(null, 10);
        Player player3 = new Player("Solomon", 0, tempDeck3, tempPile3);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        
        Stack<Card> masterStack = new Stack<Card>();
        Deck masterDeck = new Deck(masterStack, 0);
        //masterDeck.initializeDeck();
        //WargameOriginal game = new WargameOriginal(players.size(), players, masterDeck);
        
        //System.out.println(game.getMasterDeck().getDeck());
        //game.dealCards();
        //game.playCards();
        //System.out.println(game.getNumOfPlayers());
       
       /* System.out.println("Game1");
        Wargame1 game1 = new Wargame1(players, masterDeck, 10);
        game1.dealCards();

        game1.getPlayerList().get(0).getPlayerDeck().removeCardFromTop();
        game1.setPlayerScore();
        for(int i = 0; i < game1.getNumOfPlayers(); i++) {
            System.out.println(game1.getPlayerList().get(i).getPlayerDeck().getSize());
        }
        game1.declareWinner();
        
        /*System.out.println(game1.getNumOfPlayers());
        //System.out.println(game1.getPlayerList().get(1).getPlayerDeck().getDeck());
        System.out.println(game1.getPlayerList().get(0).getPlayerDeck().getSize());
        System.out.println(tempDeck1.getSize());
        tempDeck1.addCardToTop(game1.getPlayerList().get(0).getPlayerDeck().removeCardFromTop());
        System.out.println(tempDeck1.getSize());
*/
        /*for (int i = 0; i < game.getNumOfPlayers(); i++) {
            System.out.println();
            System.out.println(game.getPlayerList().get(i).getPlayerDeck().getDeck());
        }*/
        /*
        for (int i = 0; i < game.getNumOfPlayers(); i++) {

        System.out.println("Game2");
        Wargame2 game2 = new Wargame2(2, players, masterDeck);
        //game2.dealCards();
        System.out.println(game2.getNumOfPlayers());
*/

        System.out.println("Game3");
        Wargame3 game3 = new Wargame3(players, masterDeck);
        //game3.dealCards();
        Card kingCard = new Card("HEARTS", 13, "KING");
        Card queenCard = new Card("HEARTS", 12, "QUEEN");
        Card jackCard = new Card("HEARTS", 11, "JACK");
        masterDeck.addCardToTop(kingCard);
        masterDeck.addCardToTop(kingCard);
        masterDeck.addCardToTop(kingCard);
        
        masterDeck.addCardToTop(kingCard);
        masterDeck.addCardToTop(kingCard);
        masterDeck.addCardToTop(queenCard);
        
        masterDeck.addCardToTop(kingCard);
        masterDeck.addCardToTop(jackCard);
        masterDeck.addCardToTop(queenCard);
        
        game3.dealCards();
        System.out.println(game3.getNumOfPlayers());
        game3.addCardsToPlayerScore();
        for (int i = 0 ; i < game3.getNumOfPlayers(); i++){
            System.out.println(game3.getPlayerList().get(i).getScore());
        }
        game3.declareWinner();
  /*      

        System.out.println(game3.getMasterDeck().getSize());
        for (int i = 0; i < game3.getNumOfPlayers(); i++) {
            System.out.println();
            System.out.println(game3.getPlayerList().get(i).getPlayerDeck().getSize());
        }
        */
        /*
        for(int i = 0; i < 10; i++)
        /*for(int i = 0; i < 10; i++)
        {
            game1.playCards();
        }
        System.out.println(tempDeck1.getSize());
        */
            /*
        for (int i = 0; i < game.getNumOfPlayers(); i++) {

        game3.playCards();
        for (int i = 0; i < game3.getNumOfPlayers(); i++) {
            System.out.println();
            System.out.println(game3.getPlayerList().get(i).getPlayerDeck().getSize());
        }
        */


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