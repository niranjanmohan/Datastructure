package cardgames;

public class Card {
	private Suit suit;
	int faceValue;

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public String getDisplayName(int value) {
		if (faceValue == 0)
			return "Ace";
		if (faceValue == 11)
			return "Jack";
		if (faceValue == 12)
			return "Queen";
		if (faceValue == 13)
			return "King";
		else
			return String.valueOf(faceValue);
	}
	
	public void printDisplayName(){
		System.out.println(this.getSuit()+" "+getDisplayName(this.getFaceValue()));
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Card)) {
			return false;
		}
		Card card = (Card) o;
		return (this.suit == card.suit && this.getFaceValue() == card.faceValue);

	}

}
