package Deck;

/**
 * Card class. Contains the the parameters needed for a standard playing card.
 */
public class Card {
    private String suit;
    private int value;
    private String stringValue;

    /**
     * Constructor for the card class.
     */
    public Card(String suit, int value, String stringValue) {
        this.suit = suit;
        this.value = value;
        this.stringValue = stringValue;
    }

    /**
     * Getter for card value.
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for card value.
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Getter for the suit of the playing card.
     * @return
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Setter for the suit of the card.
     * @param suit
     */
    public void setSuit(String suit) {
        this.suit = suit.toUpperCase();
    }

    /**
     * Getter for the string of the value of the card.
     * @return
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Setter for string of the value of the card.
     * @param stringValue
     */
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * To string method to print the information of the card.
     */
    public String toString() {
        return stringValue + " of " + suit + " as up card.";
    }
}