package cardhand;

import java.util.Random;

public class Card {
	
	public  String rank;
	public  String suit;
	
	public String getSuit() {
		return suit;
	}

	public  String getRank() {
		return rank;
	}

	

	public Card() {
		this.suit = Suit.randomSuit();
		this.rank = Rank.randomRank();
	}

	public enum Suit {
		SPADES("Spades",0),
		HEARTS ("Hearts",1),
		DIAMONDS("Diamonds",2),
		CLUBS("Clubs",3);
		
		public static int intValue;
		private String value;

		public String getValue() {
			return value;
		}
		public int getIntValue() {
			return intValue;
		}
		private Suit(String value,int intValue) {
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
	};
	@Override
	public String toString() {
		return this.rank+" of "+ this.suit;
	}

}
