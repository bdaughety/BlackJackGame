package blackJackPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben Daughety on 6/6/2015.
 */
public class PlayerImpl implements Player {
    private Integer score = 0;
    private Integer handSize;
    private List<BlackJackCard> playerHand;
    private boolean stand = false;
    private boolean blackJack = false;

    public void hit(BlackJackCard newCard) {
        if (playerHand == null) {
            playerHand = new ArrayList<BlackJackCard>();
        }
        if (!stand) {
            playerHand.add(newCard);
        }
        calculateScore();
    }

    public boolean stand() {
        stand = true;
        return stand;
    }

    public Integer calculateScore() {
        if (playerHand != null && !playerHand.isEmpty()) {
            for (BlackJackCard blackJackCard : playerHand) {
                score += blackJackCard.getCardValue();
            }
        }
        return score;
    }

    public boolean hasBlackJack() {
        if (playerHand != null && playerHand.size() == 2) {
            if (calculateScore() == BLACK_JACK_SCORE) {
                blackJack = true;
                stand();
            }
        }
        return blackJack;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getHandSize() {
        return handSize;
    }

    public List<BlackJackCard> getPlayerHand() {
        return playerHand;
    }

}
