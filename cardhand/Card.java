package cardhand;

import java.util.Random;
import java.util.Set;

public class Card {

	private String suit;
	private String rank;

	public Card() {
		this.suit = Suit.randomSuit();
		this.rank = Rank.randomRank();
	}

	public enum Suit {
		HEARTS ("Hearts"),
		SPADES("Spades"),
		CLUBS("Clubs"),
		DIAMONDS("Diamonds");

		private String value;

		public String getValue() {
			return value;
		}
		private Suit(String value) {
			this.value=value;
		}

		@Override
		public String toString() {
			return this.getValue();
		}
		public static String randomSuit() {
			Random random = new Random();
			int index = random.nextInt(values().length);
			return values()[index].toString();

		}

	}

	public enum Rank{
		ACE("Ace"),
		KING("King"),
		QUEEN("Queen"),
		JACK("Jack"),
		TEN("Ten"),
		NINE("Nine"),
		EIGHT("Eight"),
		SEVEN("Seven");

		private String value;

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return this.getValue();
		}

		private Rank (String value) {
			this.value=value;
		}

		public static String randomRank() {
			Random random = new Random();
			int index = random.nextInt(values().length);
			return values()[index].toString();

		}

		//use to get the value as a string.
		//Rank.ACE.getValue();

	};

	@Override
	public String toString() {
		return "Card suit:"+ this.suit.toString()+"  Card rank:"+this.rank.toString();
	}
	
}
