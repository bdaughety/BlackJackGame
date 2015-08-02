package blackJackPackage;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player {
    private Integer score;
    private Integer handSize;
    private List<BlackJackCard> playerHand;
    private boolean isStanding = false;
    private boolean blackJack;
    private boolean busted;

    public void hit(BlackJackCard newCard) {
        if (playerHand == null || playerHand.isEmpty()) {
            playerHand = new ArrayList<BlackJackCard>();
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
            for (BlackJackCard blackJackCard : playerHand) {
                score += blackJackCard.getCardValue();
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
        for (BlackJackCard blackJackCard : getPlayerHand()) {
            if (blackJackCard.getCardName().equalsIgnoreCase("ace")) {
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

    public List<BlackJackCard> getPlayerHand() {
        if (playerHand == null || playerHand.isEmpty()) {
            playerHand = new ArrayList<BlackJackCard>();
        }
        return playerHand;
    }

}
