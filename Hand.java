package cardGames; /**
 * 
 */

/**
 * @author humza
 *
 */
public class Hand {
	private Card[] hand;
	//creates a hand to hold 10 cards
	public Hand() {
		hand = new Card[10];
	}
	
	//create a hand to hold num cards
	public Hand(int num) {
		hand = new Card[num];
	}
	
	//add a card to this hand
	public void addCard(Card c) {
		for (int x = 0; x < hand.length; x++) {
			if (hand[x] == null) {
				hand[x] = c;
				break;
			}
		}
	}
	
	//remove the card at index i from this hand
	public void removeCard(int i) {
		hand[i] = null;
		
	}
	
	//view the cards in a hand
	public void showCards() {
		for (int i = 0; i < hand.length; i++) {
			if (hand[i] != null) {
			System.out.println(hand[i].toString());
			}
		}
	}
	
	//return the value of the cards in this hand
	public int value() {
		int sum = 0;
		for (int x = 0; x < hand.length; x++) {
			if (hand[x] != null) {
					int value = hand[x].getValue();
					if (value == 1) {
						if (sum > 10) {
							sum += 1;
						}
						else
							sum += 11;
					}
					else if (value > 10) 
						sum += 10;
					else
						sum += value;
				}
			}
		return sum;
	}
	
}
