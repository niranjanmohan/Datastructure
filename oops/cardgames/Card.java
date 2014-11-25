package cardgames;

class Card{
	Suit suit;
	int faceValue;
	public void setFaceValue(int faceValue){
		this.faceValue = faceValue;
	}
	public int getFaceValue(){
		return this.faceValue;
	}
	public Suit getSuit(){
		return suit;
	}
	public void setSuit(Suit suit){
		this.suit =suit ;
	}
	public boolean equals(Object object){
		if(object instanceof Card){ 
			Card oCard = (Card) object;
			return (oCard.getSuit() == this.suit && oCard.getFaceValue() == this.faceValue);
		}
		return false;
	}
	public int hashcode(Object object){
		if(object instanceof Card){
			return ((Card)object).faceValue* suit.getValue();
		}
		return -1;
	}
	public void printDisplayName(){
		System.out.println();
		String dispVal ;
		switch(this.faceValue){
		case 10:
			dispVal = "JACK";
			break;
		case 11:
			dispVal = "QUEEN";
			break;
		case 12:
			dispVal = "KING";
			break;
		case 13:
			dispVal = "ACE";
			break;
		 default:
			 dispVal = String.valueOf(this.faceValue);
				
		}
		System.out.print("card is  :"+this.suit+" : " 
		+dispVal);
	}
}	
