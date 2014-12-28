package cardgames;

import java.util.List;

abstract class CardList{
	List<Card> cards;

	public boolean  hasCard(Card card){
			return cards.contains(card);
	}
	public boolean getCard(Card card){//removes the card from the list
		if(card !=null && cards.contains(card)){
			return cards.remove(card);
		}
		return false;
	}
	public void setCard(Card card){
		if(card !=null){
			cards.add(card);
		}
	}
	public void addCard(Card card){
			cards.add(card);
	}
	public void printAll(){
		for(Card c:cards)
			c.printDisplayName();
	}


}