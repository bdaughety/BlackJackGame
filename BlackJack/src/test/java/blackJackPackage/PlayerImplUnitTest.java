package blackJackPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerImplUnitTest {
    private PlayerImpl player;

    @Before
    public void setup() {
        player = new PlayerImpl();
    }

    @After
    public void destroy() {
        player = null;
    }

    @Test
    public void testHit() throws Exception {
        assertTrue(player.getHandSize() == 0);

        player.hit(CardEnum.SIX_OF_CLUBS);
        assertTrue(player.getHandSize() == 1);

        player.resetHand();
        player.hit(CardEnum.ACE_OF_HEARTS);
        player.hit(CardEnum.TEN_OF_DIAMONDS);
        assertTrue(player.getHandSize() == 2);

        player.hit(CardEnum.SIX_OF_CLUBS);
        assertTrue(player.getHandSize() == 2);

        player.resetHand();
        player.hit(CardEnum.TEN_OF_DIAMONDS);
        player.hit(CardEnum.SIX_OF_CLUBS);
        player.hit(CardEnum.ACE_OF_HEARTS);
        assertTrue(player.getHandSize() == 3);

        player.resetHand();
        player.hit(CardEnum.FOUR_OF_SPADES);
        player.hit(CardEnum.SIX_OF_CLUBS);
        player.hit(CardEnum.TEN_OF_DIAMONDS);
        player.stand();
        player.hit(CardEnum.ACE_OF_HEARTS);
        assertTrue(player.getHandSize() == 3);
    }

    @Test
    public void testStand() throws Exception {
        assertTrue(!player.isStanding());

        player.stand();
        assertTrue(player.isStanding());

        player.resetHand();
        assertTrue(!player.isStanding());

        player.hit(CardEnum.ACE_OF_HEARTS);
        player.hit(CardEnum.TEN_OF_DIAMONDS);
        assertTrue(player.isStanding());

        player.resetHand();
        player.hit(CardEnum.SIX_OF_CLUBS);
        assertTrue(!player.isStanding());

        player.hit(CardEnum.TEN_OF_DIAMONDS);
        assertTrue(!player.isStanding());

        player.hit(CardEnum.TWO_OF_CLUBS);
        player.hit(CardEnum.FOUR_OF_SPADES);
        assertTrue(player.isStanding());


    }

    @Test
    public void testCalculateScore() throws Exception {

    }

    @Test
    public void testHasBlackJack() throws Exception {

    }
}