/*NIKHIL PARVATIKAR*/
package cardgames;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args)  {

		Card card;

		System.out.println("Please select a choice (1,2 or 3)");

		System.out.println(" 1  : POKER \n 2  : BLACKJACK \n 3  : WAR \n");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		System.out.println("Enter the number of players");
		Scanner p = new Scanner(System.in);
		int players = p.nextInt();
		ArrayList<Player> playersList = new ArrayList<Player>();
		for(int i=0;i<players;i++){
			playersList.add(new Player());
		}

		if (players > 6 || players < 1) {
//			throw new InvalidPayerException();
			System.out.println("Ivalid number of players");
			System.exit(0);
		}
		//create the deck object with all 52 cards

		Deck deck = new Deck();
		deck.initialize();

		Card cardtemp ;
		Player playerT;
		for(int pl =1;pl<=playersList.size();pl++){
			switch (choice) {
			case 1:
				//POKER(&-card suit
				for(int i=0;i<7;i++){
					cardtemp = deck.deal();
					playerT = playersList.get(pl);
					playerT.addCard(cardtemp);
					System.out.println("Player "+pl+"was dealt with :");
					cardtemp.printDisplayName();
				}
				break;
			case 2: //Black Jack
				for(int i=0;i<2;i++){
					cardtemp = deck.deal();
					playerT = playersList.get(pl);
					playerT.addCard(cardtemp);
					System.out.println("Player "+pl+"was dealt with :");
					cardtemp.printDisplayName();
				}
				break;
			case 3://Poker(texas holdem)
				for(int i=0;i<2;i++){
					cardtemp = deck.deal();
					playerT = playersList.get(pl);
					playerT.addCard(cardtemp);
					System.out.println("Player "+pl+"was dealt with :");
					cardtemp.printDisplayName();
				}
				break;
			default:
				System.out.println("Invalid Option");
				
			}
		}

	}

}
