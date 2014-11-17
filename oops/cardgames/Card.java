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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + faceValue;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (faceValue != other.faceValue)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}
