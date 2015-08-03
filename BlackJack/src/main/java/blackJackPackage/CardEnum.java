package blackJackPackage;

import java.util.HashMap;
import java.util.Map;

public enum CardEnum {

    ACE_OF_SPADES(11, "Ace", "Spades"),
    TWO_OF_SPADES(2, "Two", "Spades"),
    THREE_OF_SPADES(3, "Three", "Spades"),
    FOUR_OF_SPADES(4, "Four", "Spades"),
    FIVE_OF_SPADES(5, "Five", "Spades"),
    SIX_OF_SPADES(6, "Six", "Spades"),
    SEVEN_OF_SPADES(7, "Seven", "Spades"),
    EIGHT_OF_SPADES(8, "Eight", "Spades"),
    NINE_OF_SPADES(9, "Nine", "Spades"),
    TEN_OF_SPADES(10, "Ten", "Spades"),
    JACK_OF_SPADES(10, "Jack", "Spades"),
    QUEEN_OF_SPADES(10, "Queen", "Spades"),
    KING_OF_SPADES(10, "King", "Spades"),
    ACE_OF_CLUBS(11, "Ace", "Clubs"),
    TWO_OF_CLUBS(2, "Two", "Clubs"),
    THREE_OF_CLUBS(3, "Three", "Clubs"),
    FOUR_OF_CLUBS(4, "Four", "Clubs"),
    FIVE_OF_CLUBS(5, "Five", "Clubs"),
    SIX_OF_CLUBS(6, "Six", "Clubs"),
    SEVEN_OF_CLUBS(7, "Seven", "Clubs"),
    EIGHT_OF_CLUBS(8, "Eight", "Clubs"),
    NINE_OF_CLUBS(9, "Nine", "Clubs"),
    TEN_OF_CLUBS(10, "Ten", "Clubs"),
    JACK_OF_CLUBS(10, "Jack", "Clubs"),
    QUEEN_OF_CLUBS(10, "Queen", "Clubs"),
    KING_OF_CLUBS(10, "King", "Clubs"),
    ACE_OF_DIAMONDS(11, "Ace", "Diamonds"),
    TWO_OF_DIAMONDS(2, "Two", "Diamonds"),
    THREE_OF_DIAMONDS(3, "Three", "Diamonds"),
    FOUR_OF_DIAMONDS(4, "Four", "Diamonds"),
    FIVE_OF_DIAMONDS(5, "Five", "Diamonds"),
    SIX_OF_DIAMONDS(6, "Six", "Diamonds"),
    SEVEN_OF_DIAMONDS(7, "Seven", "Diamonds"),
    EIGHT_OF_DIAMONDS(8, "Eight", "Diamonds"),
    NINE_OF_DIAMONDS(9, "Nine", "Diamonds"),
    TEN_OF_DIAMONDS(10, "Ten", "Diamonds"),
    JACK_OF_DIAMONDS(10, "Jack", "Diamonds"),
    QUEEN_OF_DIAMONDS(10, "Queen", "Diamonds"),
    KING_OF_DIAMONDS(10, "King", "Diamonds"),
    ACE_OF_HEARTS(11, "Ace", "Hearts"),
    TWO_OF_HEARTS(2, "Two", "Hearts"),
    THREE_OF_HEARTS(3, "Three", "Hearts"),
    FOUR_OF_HEARTS(4, "Four", "Hearts"),
    FIVE_OF_HEARTS(5, "Five", "Hearts"),
    SIX_OF_HEARTS(6, "Six", "Hearts"),
    SEVEN_OF_HEARTS(7, "Seven", "Hearts"),
    EIGHT_OF_HEARTS(8, "Eight", "Hearts"),
    NINE_OF_HEARTS(9, "Nine", "Hearts"),
    TEN_OF_HEARTS(10, "Ten", "Hearts"),
    JACK_OF_HEARTS(10, "Jack", "Hearts"),
    QUEEN_OF_HEARTS(10, "Queen", "Hearts"),
    KING_OF_HEARTS(10, "King", "Hearts");

    private int blackJackValue;
    private String cardName;
    private String cardSuit;
    private static Map<String, CardEnum> cardEnumMap;

    static {
        cardEnumMap = new HashMap<String, CardEnum>();
        for (CardEnum e : CardEnum.values()) {
            cardEnumMap.put(e.name(), e);
        }
    }

    public static CardEnum getCardEnumForName(final String name) {
        return cardEnumMap.get(name);
    }

    CardEnum(int blackJackValue, String cardName, String cardSuit) {
        this.blackJackValue = blackJackValue;
        this.cardName = cardName;
        this.cardSuit = cardSuit;
    }

    public String getCardLabel() {
        return cardName + " of " + cardSuit;
    }

    public int blackJackValue() {
        return blackJackValue;
    }

    public String cardName() {
        return cardName;
    }
}