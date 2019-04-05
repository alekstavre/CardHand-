package cardhand;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import cardhand.Card.Rank;

public class CardGame extends LinkedPositionalList{

	static Scanner scan = new Scanner(System.in);
	static CardHand<Card> cardHand = new CardHand<Card>();


	public static void main(String[] args) {

		System.out.println("draw 4 cards!\n");
		for (int i=0;i<4;i++) {	
			Node<Card> initCard = new Node<Card>(new Card(), null, null);
			cardHand.addCard(initCard);
			System.out.println(cardHand.iterator().next()+"\n");
		}

		System.out.println("add a new Card to hand?");

		while (!"stop".equals(scan.nextLine())){
			Node<Card> newCard = new Node<Card>(new Card(), null, null);
			cardHand.addCard(newCard);
			System.out.println("you drew a new card:\n"+newCard+"\n");
			System.out.println("add a new Card to hand?");
		}	

		//cardHand.insertionSort(cardHand);

		System.out.println("the cards in your hand:");
		System.out.println("--------------------");
		for (Iterator i = cardHand.iterator(); i.hasNext();) {

			System.out.println(i.next());
		}
		System.out.println("--------------------");
		System.out.println("remove the card :");
		String position = scan.next();


		//iterate and remove
		for (Iterator i = cardHand.iterator(); i.hasNext();) {

			if(i.toString().equals(position)){
				i.remove();
				i.forEachRemaining(sortCards());
			}

		}

		System.out.println("the updated cards in your hand: \n");
		for (Iterator i = cardHand.iterator(); i.hasNext();) {

			System.out.println(i.next().toString());
		}		
	}
	private static Consumer sortCards() {
		// TODO Auto-generated method stub
		return null;
	}
	class sortCards implements Comparator<Card>{

		@Override
		public int compare(Card initCard, Card newCard) {

			return initCard.suit.compareTo(newCard.suit);
		}
	}
}






