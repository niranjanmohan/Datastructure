package cardgames;

enum Suit{
	SPADE(1),
	DIAMOND(2),
	HEARTS(3),
	CLUB(4);

int value;

Suit(int value){
	this.value = value;
}

public int getValue(){
	return this.value;
}

public Suit getSuit(int value){
	switch(value){
		case 1: return Suit.SPADE;
		case 2: return Suit.DIAMOND;
		case 3: return Suit.HEARTS;
		case 4: return Suit.CLUB;
		default : return null;
	}
}


}
