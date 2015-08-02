package blackJackPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerImplUnitTest {
    private PlayerImpl player;
    private BlackJackCard sixOfClubs;
    private BlackJackCard aceOfHearts;
    private BlackJackCard tenOfDiamonds;
    private BlackJackCard fourOfSpades;
    private BlackJackCard twoOfClubs;

    @Before
    public void setup() {
        player = new PlayerImpl();
        sixOfClubs = new BlackJackCard('c', 5);
        aceOfHearts = new BlackJackCard('h', 0);
        tenOfDiamonds = new BlackJackCard('d', 9);
        fourOfSpades = new BlackJackCard('s', 5);
        twoOfClubs = new BlackJackCard('c', 1);
    }

    @After
    public void destroy() {
        player = null;
        sixOfClubs = null;
        aceOfHearts = null;
        tenOfDiamonds = null;
        fourOfSpades = null;
    }

    @Test
    public void testHit() throws Exception {
        assertTrue(player.getHandSize() == 0);

        player.hit(sixOfClubs);
        assertTrue(player.getHandSize() == 1);

        player.resetHand();
        player.hit(aceOfHearts);
        player.hit(tenOfDiamonds);
        assertTrue(player.getHandSize() == 2);

        player.hit(sixOfClubs);
        assertTrue(player.getHandSize() == 2);

        player.resetHand();
        player.hit(tenOfDiamonds);
        player.hit(sixOfClubs);
        player.hit(aceOfHearts);
        assertTrue(player.getHandSize() == 3);

        player.resetHand();
        player.hit(fourOfSpades);
        player.hit(sixOfClubs);
        player.hit(tenOfDiamonds);
        player.stand();
        player.hit(aceOfHearts);
        assertTrue(player.getHandSize() == 3);
    }

    @Test
    public void testStand() throws Exception {
        assertTrue(!player.isStanding());

        player.stand();
        assertTrue(player.isStanding());

        player.resetHand();
        assertTrue(!player.isStanding());

        player.hit(aceOfHearts);
        player.hit(tenOfDiamonds);
        assertTrue(player.isStanding());

        player.resetHand();
        player.hit(sixOfClubs);
        assertTrue(!player.isStanding());

        player.hit(tenOfDiamonds);
        assertTrue(!player.isStanding());

        player.hit(twoOfClubs);
        player.hit(fourOfSpades);
        assertTrue(player.isStanding());


    }

    @Test
    public void testCalculateScore() throws Exception {

    }

    @Test
    public void testHasBlackJack() throws Exception {

    }
}