package cardgames;

public enum Suit {
	CLUB(1), DIAMOND(2), HEART(3), SPADE(4);
	int value;

	Suit(int value) {
		this.value = value;
	}

	public Suit getValue(int value) {
		switch (value) {
		case 1:
			return Suit.CLUB;
		case 2:
			return Suit.DIAMOND;
		case 3:
			return Suit.HEART;
		case 4:
			return Suit.SPADE;
		default:
			return null;
		}

	}
}
