package Game;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Deck.*;
import Player.*;

class WarGameTest {
    Stack<Card> stackCard1;
    Deck tempDeck1;
    Stack<Card> scorePile1;
    ScorePile tempPile1;
    Player player1;

    Stack<Card> stackCard2;
    Deck tempDeck2;
    Stack<Card> scorePile2;
    ScorePile tempPile2;
    Player player2;

    
    Stack<Card> stackCard3;
    Deck tempDeck3;
    Stack<Card> scorePile3;
    ScorePile tempPile3;
    Player player3;

    ArrayList<Player> players;


    Stack<Card> masterStack;
    Deck masterDeck;
    Wargame3 game3;

	@Before
	public void setUp()
	{
        stackCard1 = new Stack<Card>();
        tempDeck1 = new Deck(stackCard1, 0);
        scorePile1 = new Stack<Card>();
        tempPile1 = new ScorePile(scorePile1, 0);
        player1 = new Player("Nathan", 0, tempDeck1, tempPile1);

        stackCard2 = new Stack<Card>();
        tempDeck2 = new Deck(stackCard2, 0);
        scorePile2 = new Stack<Card>();
        tempPile2 = new ScorePile(scorePile2, 0);
        player2 = new Player("Chan", 0, tempDeck2, tempPile2);

        
        stackCard3 = new Stack<Card>();
        tempDeck3 = new Deck(stackCard3, 0);
        scorePile3 = new Stack<Card>();
        tempPile3 = new ScorePile(scorePile3, 0);
        player3 = new Player("Solomon", 0, tempDeck3, tempPile3);

        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        masterStack = new Stack<Card>();
        masterDeck = new Deck(masterStack, 0);
        masterDeck.initializeDeck();
        game3 = new Wargame3(players, masterDeck);
        game3.startGame();
	}
	@Test
	void checkPlayerName() {
        Player player1 = new Player("Nathan", 0, tempDeck1, tempPile1);
		if(player1.getName() != "Nathan")
			fail("Wrong player name");
	}
	@Test
	void checkNumberOfPlayers() {
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
		if(players.size() != 3)
			fail("incorrect number of players");
	}
	@Test
	void checkDeckSize() {

        Stack<Card> masterStack = new Stack<Card>();
        Deck masterDeck = new Deck(masterStack, 0);
        masterDeck.initializeDeck();
        assertEquals(52, masterDeck.getSize());
	}
	@Test
	void checkPlayerHand() {
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
        Wargame3 game3 = new Wargame3(players, masterDeck);
        game3.dealCards();
        assertEquals(17, player1.getPlayerDeck().getSize());
        assertEquals(17, player2.getPlayerDeck().getSize());
        assertEquals(17, player3.getPlayerDeck().getSize());
	}
	@Test
	void checkScorePile() {
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
        Wargame3 game3 = new Wargame3(players, masterDeck);
        game3.startGame();
        if(player1.getScore() + player2.getScore() + player3.getScore() <= 0)
        	fail("Score did not add up");
	}
	@Test
	void checkWinnerGame3() {
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
        Wargame3 game3 = new Wargame3(players, masterDeck);
        game3.startGame();
        assertEquals("Solomon wins!", game3.declareWinner());
	}
	@Test
	public void checkWinnerGame1() {
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

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        Stack<Card> masterStack = new Stack<Card>();
        Deck masterDeck = new Deck(masterStack, 0);
        
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
        Wargame1 game1 = new Wargame1(players, masterDeck, 3);
        game1.startGame();
        assertEquals("Nathan wins!", game1.declareWinner());
	}
	@Test
	public void checkWinnerGame2() {
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

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        Stack<Card> masterStack = new Stack<Card>();
        Deck masterDeck = new Deck(masterStack, 0);
        
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
        Wargame2 game2 = new Wargame2(2, players, masterDeck);
        game2.startGame();
        assertEquals("Nathan wins!", game2.declareWinner());
	}
	@Test
	void checkCardRankGame1() {
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

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        Stack<Card> masterStack = new Stack<Card>();
        Deck masterDeck = new Deck(masterStack, 0);
        
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
        Wargame1 game1 = new Wargame1(players, masterDeck, 3);
        game1.startGame();
        if(player1.getPlayerDeck().getDeck().get(0).getValue() != 12)
        	fail("Card rank was supposed to be 12");
	}
	
	void checkWinnerScoreGame3() {
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
        Wargame3 game3 = new Wargame3(players, masterDeck);
        game3.startGame();
        assertEquals(9, player3.getScore());
	}
	@Test
	void checkWinnerScoreGame2() {
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
        
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        Stack<Card> masterStack = new Stack<Card>();
        Deck masterDeck = new Deck(masterStack, 0);
        
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
        Wargame2 game2 = new Wargame2(2, players, masterDeck);
        game2.startGame();
        assertEquals(8, player1.getScore());
	}
}