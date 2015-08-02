package blackJackPackage;

public interface Player {
    Integer BLACK_JACK_SCORE = 21;
    Integer PERFECT_SCORE_WITH_ACE = 31;

    void hit(BlackJackCard blackJackCard);
    void stand();
    boolean isStanding();
    Integer calculateScore();
    boolean hasBlackJack();
    void resetHand();
    boolean hasBusted();
    boolean handContainsAnAce();
}
