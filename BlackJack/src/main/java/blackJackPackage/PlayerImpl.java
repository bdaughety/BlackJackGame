package blackJackPackage;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player {
    private Integer score;
    private Integer handSize;
    private List<CardEnum> playerHand;
    private boolean isStanding = false;
    private boolean blackJack;
    private boolean busted;

    public void hit(CardEnum newCard) {
        if (playerHand == null || playerHand.isEmpty()) {
            playerHand = new ArrayList<CardEnum>();
        }
        if (!isStanding && !hasBlackJack() && !hasBusted()) {
            playerHand.add(newCard);
        }
        calculateScore();
        hasBlackJack();
    }

    public void stand() {
        isStanding = true;
    }

    public boolean isStanding() {
        return isStanding;
    }

    public Integer calculateScore() {
        score = 0;
        if (playerHand != null && !playerHand.isEmpty()) {
            for (CardEnum cardEnum : playerHand) {
                score += cardEnum.blackJackValue();
                hasBusted();
                hasBlackJack();
            }
        }
        return score;
    }

    public boolean hasBlackJack() {
        blackJack = false;
        if (playerHand != null && playerHand.size() == 2) {
            if (score.equals(BLACK_JACK_SCORE)) {
                blackJack = true;
                stand();
            }
        }
        return blackJack;
    }

    public void resetHand() {
        if (playerHand != null && !playerHand.isEmpty()) {
            playerHand.clear();
        }
        calculateScore();
        isStanding = false;
    }

    public boolean hasBusted() {
        busted = false;
        calculateScore();
        if (score > BLACK_JACK_SCORE) {
            if ((handContainsAnAce() && score > PERFECT_SCORE_WITH_ACE)
                    || !handContainsAnAce()) {
                busted = true;
                stand();
            }
        }
        return busted;
    }

    public boolean handContainsAnAce() {
        for (CardEnum cardEnum : getPlayerHand()) {
            if (cardEnum.cardName().equals(CardEnum.ACE_OF_CLUBS.cardName())) {
                return true;
            }
        }
        return false;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getHandSize() {
        handSize = 0;
        if (playerHand != null) {
            handSize = playerHand.size();
        }
        return handSize;
    }

    public List<CardEnum> getPlayerHand() {
        if (playerHand == null || playerHand.isEmpty()) {
            playerHand = new ArrayList<CardEnum>();
        }
        return playerHand;
    }

}
