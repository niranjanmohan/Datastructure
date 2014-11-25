package cardgames;

import java.util.ArrayList;
import java.util.Random;

class Deck extends CardList{	
	public void initialize(){
		Card card;
		super.cards = new ArrayList<Card>();
		for(Suit s:Suit.values())
			for(int i=0;i<=13;i++){
				card = new Card();
				card.setFaceValue(i);
				card.setSuit(s);
				cards.add(card);
			}
	}
	public void shuffle(){
		Random r = new Random();
		for(int i=0;i<53;i++){
			int rand = r.nextInt(52);
			Card temp= cards.get(i);
			cards.set(i,cards.get(rand));
			cards.set(rand,temp);
		}
	}
	public Card deal(){
		int size = cards.size();
		Random r = new Random();
		int next = r.nextInt(size);
		Card c = cards.get(next);
		this.getCard(c);
		return c;
	}

}
