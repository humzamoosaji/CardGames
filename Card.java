package cardGames; /**
 * 
 */

/**
 * @author humza
 *
 */
public class Card {

	public static final int heart = 0;
	public static final int club = 1;
	public static final int spade = 2;
	public static final int diamond = 3;

	private int suit;
	private int value;
	private boolean isFaceUp;

	/**
	 * @param suit
	 * @param value
	 */
	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
		this.isFaceUp = false;
	}

	/**
	 * Represent the card as string for printing Now the cardGames.Card can be printed with
	 * println
	 */
	public String toString() {
		String cardDetails = getSuitAsString() + " " + value;
		return cardDetails;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the suit
	 */
	public int getSuit() {
		return suit;
	}
	
	public String getValueAsString() {
		String valueString = Character.toString((char)(this.value+64));
		return valueString;
	}
	
	public String getSuitAsString() {
		String suitString = "";
		if (this.suit == 0) 
			suitString = "H";
		else if (this.suit == 1) 
			suitString = "C";
		else if (this.suit == 2) 
			suitString = "S";
		else 
			suitString = "D";
		return suitString;
	}

	public void flip() {
		if (isFaceUp == false)
			isFaceUp = true;
		else
			isFaceUp = false;
	}
}
