package project;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import project.cards.Card;
import project.cards.Deck;
import project.cards.Rank;
import project.cards.Suit;

/**
 *
 * @author Alexander
 */
public class PlayerActionsTest {
    
    public PlayerActionsTest() {
    }

        
    @Before
    public void setUp() {
        Dealer.getInstance().getHand().clearCards();
    }

    
    /**
     * Test of hit method, of class PlayerActions.
     * @throws java.lang.Exception
     */
    @Test
    public void testHit() throws Exception {
        System.out.println("hit");
        Deck deck = new Deck();
        BlackJackPlayer p = new BlackJackPlayer("Test");
        Dealer d = Dealer.getInstance();
        PlayerActions.hit(deck, p);
        PlayerActions.hit(deck, d);
        int result = deck.getSize();
        int expResult = 50;
        assertEquals(expResult, result);
    }

    /**
     * Test of playerHandString method, of class PlayerActions.
     */
    @Test
    public void testPlayerHandStringBJPlayer() {
        System.out.println("playerHandStringBJPlayer");
        Card c1 = new Card(Rank.Six, Suit.Hearts);
        Card c2 = new Card(Rank.Queen, Suit.Spades);
        BlackJackPlayer p = new BlackJackPlayer("Test");
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c2);
        String expResult = "Test's hand contains:\nSix of Hearts\nQueen of Spades\nWhich is a value of 16\n";
        String result = PlayerActions.playerHandString(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of playerHandString method, of class PlayerActions.
     */
    @Test
    public void testPlayerHandStringDealer() {
        System.out.println("playerHandStringDealer");
        Card c1 = new Card(Rank.Eight, Suit.Hearts);
        Card c2 = new Card(Rank.Four, Suit.Spades);
        Dealer p = Dealer.getInstance();
        p.getHand().getCards().add(c1);
        p.getHand().getCards().add(c2);
        String expResult = "Dealer's hand contains:\nEight of Hearts\nFour of Spades\nWhich is a value of 12\n";
        String result = PlayerActions.playerHandString(p);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
