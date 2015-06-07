package blackJackPackage;

/**
 * Created by Ben Daughety on 6/6/2015.
 */
public interface Player {
    Integer BLACK_JACK_SCORE = 21;

    void hit(BlackJackCard blackJackCard);
    boolean stand();
    Integer calculateScore();
    boolean hasBlackJack();
}
