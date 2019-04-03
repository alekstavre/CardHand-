package cardhand;

import java.util.Scanner;

public class CardGame {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		CardHand<Card> cardHand = new CardHand<Card>();
		
		System.out.println("-----------draw 4 cards!----------\n");
		for (int i=0;i<4;i++) {	
			Card initCard = new Card();
			cardHand.addCard(initCard);
			System.out.println(" ___________you drew_____________\n|"+initCard+"|\n");
		}
		
		System.out.println("-----add a new Card to hand?-----");
		
		while (!"exit".equals(scan.nextLine())){
			Card newCard = new Card();
			cardHand.addCard(newCard);
			System.out.println(" _____you drew a new card!_______\n|"+newCard+"|\n");
			System.out.println("-----add a new Card to hand?-----");

		}
	}
}


