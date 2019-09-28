package Deck;

public class Card {
    private String suit;
    private int value;
    private String stringValue;

    public Card(String suit, int value, String stringValue) {
        this.suit = suit;
        this.value = value;
        this.stringValue = stringValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit.toUpperCase();
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String toString() {
        return stringValue + " of " + suit + " as up card.";
    }
}