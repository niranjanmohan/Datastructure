package cardgames;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Card> cards;
	
	Player(){
		cards = new ArrayList<Card>();
	}

	public void displayHand() {
		for (Card c : cards)
			System.out.println(c.getSuit() + " "
					+ c.getDisplayName(c.getFaceValue()));
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public boolean hasCard(Card card) {
		// check for the card code to implement
		return cards.contains(card);
	}

	public boolean getCard(Card card) {
		// have to implement the logic
		if (hasCard(card))
			return cards.remove(card);
		return false;
	}

}