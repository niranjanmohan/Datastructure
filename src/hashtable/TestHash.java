package hashtable;

import java.util.Scanner;

public class TestHash {
	public static void main(String [] args){
//		MyHashTable mhash = new MyHashTable(32);
//		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
//                "235", "802", "900", "723", "699", "1", "16", "999", "890",
//                "725", "998", "978", "988", "990", "989", "984", "320", "321",
//                "400", "415", "450", "50", "660", "624" };
//		mhash.hashFunction(elementsToAdd2);
//		mhash.findKey("235");
//		mhash.displayContent();
		
		
		 String[][] elementsToAdd = {
		            { "ace", "Very good" },
		            { "act", "Take action" },
		            { "add", "Join (something) to something else" },
		            { "age", "Grow old" },
		            { "ago", "Before the present" },
		            { "aid", "Help, assist, or support" },
		            { "aim", "Point or direct" },
		            { "air", "Invisible gaseous substance" },
		            { "all", "Used to refer to the whole quantity" },
		            { "amp",
		                    "Unit of measure for the strength of an electrical current" },
		            { "and", "Used to connect words" }, { "ant", "A small insect" },
		            { "any", "Used to refer to one or some of a thing" },
		            { "ape", "A large primate" },
		            { "apt", "Appropriate or suitable in the circumstances" },
		            { "arc", "A part of the circumference of a curve" },
		            { "are", "Unit of measure, equal to 100 square meters" },
		            { "ark", "The ship built by Noah" },
		            { "arm", "Two upper limbs of the human body" },
		            { "art", "Expression or application of human creative skill" },
		            { "ash", "Powdery residue left after the burning" },
		            { "ask", "Say something in order to obtain information" },
		            { "asp", "Small southern European viper" },
		            { "ass", "Hoofed mammal" },
		            { "ate", "To put (food) into the mouth and swallow it" },
		            { "atm", "Unit of pressure" },
		            { "awe", "A feeling of reverential respect" },
		            { "axe", "Edge tool with a heavy bladed head" },
		            { "aye", "An affirmative answer" } };
		 
		 
		 
		MyHashTableString hmap = new MyHashTableString(50);
		hmap.insert("customer", "test");
		hmap.insert("visitor", "tonawanda");
		hmap.insertArray(elementsToAdd);
		hmap.displayTable();
		
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		while (! input.equalsIgnoreCase("x")){
			System.out.println(hmap.getValue(input));
			input = sc.nextLine();
		}
		
		
		
		
	}

}
