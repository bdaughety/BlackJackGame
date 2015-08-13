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

	public Integer getHandSize() {
		return handSize;
	}

	public List<CardEnum> getPlayerHand() {
		if (playerHand == null || playerHand.isEmpty()) {
			setPlayerHand(new ArrayList<CardEnum>());
		}
		return playerHand;
	}

	public Integer getScore() {
		return score;
	}

	public boolean handContainsAnAce() {
		return getPlayerHand().contains(CardEnum.ACE_OF_SPADES)
			   || getPlayerHand().contains(CardEnum.ACE_OF_CLUBS)
			   || getPlayerHand().contains(CardEnum.ACE_OF_DIAMONDS)
			   || getPlayerHand().contains(CardEnum.ACE_OF_HEARTS);
	}

	public boolean hasBlackJack() {
		setBlackJack(false);
		if (playerHand != null && playerHand.size() == 2) {
			if (score.equals(BLACK_JACK_SCORE)) {
				setBlackJack(true);
				stand();
			}
		}
		return isBlackJack();
	}

	public boolean hasBusted() {
		setBusted(false);
		calculateScore();
		if (score > BLACK_JACK_SCORE) {
			if ((handContainsAnAce() && score > PERFECT_SCORE_WITH_ACE)
				|| !handContainsAnAce()) {
				setBusted(true);
				stand();
			}
		}
		return isBusted();
	}

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

	public boolean isBlackJack() {
		return blackJack;
	}

	public boolean isBusted() {
		return busted;
	}

	public boolean isStanding() {
		return isStanding;
	}

	public void resetHand() {
		if (playerHand != null && !playerHand.isEmpty()) {
			playerHand.clear();
		}
		calculateScore();
		setIsStanding(false);
	}

	public void setBlackJack(final boolean blackJack) {
		this.blackJack = blackJack;
	}

	public void setBusted(final boolean busted) {
		this.busted = busted;
	}

	public void setHandSize(final Integer handSize) {
		this.handSize = handSize;
	}

	public void setIsStanding(final boolean isStanding) {
		this.isStanding = isStanding;
	}

	public void setPlayerHand(final List<CardEnum> playerHand) {
		this.playerHand = playerHand;
	}

	public void setScore(final Integer score) {
		this.score = score;
	}

	public void stand() {
		isStanding = true;
	}

}
