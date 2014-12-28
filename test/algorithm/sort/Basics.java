package algorithm.sort;

public class Basics {
	public enum Suits {
		CLUBS(20), DIAMONDS(20), HEARTS(30), SPADES(30),
		NOTRUMP(40) { public int getValue(int bid) {
			return ((bid-1)*30)+40; } };
			Suits(int points) { this.points = points; }
			private int points;
			public int getValue(int bid) { return points * bid; }
	}
	static Weather s;
	public static void main(String [] args){
		// test bit shift and unsigned bit shift
		
		int i = -32;
		System.out.println(Integer.toBinaryString(i));
		int un = i; int s =i;int count =0;
		while(count < 10){
			un = un >>>1;
			s = s>>1;
			System.out.println("integers :"+un+ "   :"+ s);
			System.out.println("in binary form :"+Integer.toBinaryString(un)+"   :"+Integer.toBinaryString(s));
			count++;
			
		}
		
		
//		
//		System.out.println(s.COLD.range);
//		Boolean [] b [];
//		Integer i =9;
//		checkBoxWiden(i);
//		System.out.println(Suits.NOTRUMP.getValue(3));
//		System.out.println(Suits.SPADES + " " + Suits.SPADES.points);
//		System.out.println(Suits.values());
	}
	public static void checkBoxWiden(float o){

		System.out.println(o);
	}
}
