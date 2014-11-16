package cardgames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
List<Card> cards;
	
	Deck(){
		cards = new ArrayList<Card>();
	}
	

// initalize the cards fill the deck 
	public void initialize(){
		Card card;
		for(Suit s:Suit.values())
			for(int i=0;i<13;i++){
				card = new Card();
				card.setFaceValue(i);
				card.setSuit(s);
				cards.add(card);
			}
	}
	
// shuffle the cards
	public void shuffle(){
		Random rand = new Random();
		for(int i=0;i<52;i++){
			int r = rand.nextInt(52);
			Card card1 = cards.get(r);
			Card card2 = cards.get(i);
			//swap values
			cards.set(r,card2);
			cards.set(i,card1);
		}

	}
	
	//display all cards
	public void displayAll(){
		for(Card c:cards)
			System.out.println(c.getSuit()+" "+c.getDisplayName(c.getFaceValue()));
	}
	
	public Card deal(){
		if ( cards.size() == 0) {
            throw new IllegalStateException("No cards in deck");
        }
		return cards.remove(0);
		
	}
}
