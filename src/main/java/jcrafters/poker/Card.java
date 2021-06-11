package jcrafters.poker;

public class Card {
	private final Value value;
	private final Suit suit;

	public Card(String s) {
		if(!hasValueAndSuit(s)){
			throw new IllegalArgumentException("Card should contain value and suit, ex : 2H");
		}
		value = Value.valueOf(s.charAt(0));
		suit = Suit.valueOf(s.charAt(1));
	}

	private boolean hasValueAndSuit(String s) {
		return s != null && s.length() == 2;
	}

	public boolean isHigherThan(Card card) {
		return this.value.ordinal() > card.value.ordinal();
	}

	public String getValueName() {
		return value.visualName;
	}

	public enum Suit {
		SPADES,
		HEARTS,
		CLUBS,
		DIAMONDS;

		public static Suit valueOf(char c){
			switch (c){
				case 'S': return SPADES;
				case 'H': return HEARTS;
				case 'C': return CLUBS;
				case 'D': return DIAMONDS;
				default: throw new IllegalArgumentException("Illegal suit");
			}
		}
	}

	public enum Value {
		TWO("2"),
		THREE("3"),
		FOUR("4"),
		FIVE("5"),
		SIX("6"),
		SEVEN("7"),
		EIGHT("8"),
		NINE("9"),
		TEN("Ten"),
		JACK("Jack"),
		QUEEN("Queen"),
		KING("King"),
		ACE("Ace");

		private String visualName;

		Value(String visualName) {
			this.visualName = visualName;
		}

		public static Value valueOf(char c){
			switch (c){
				case '2' : return TWO;
				case '3' : return THREE;
				case '4' : return FOUR;
				case '5' : return FIVE;
				case '6' : return SIX;
				case '7' : return SEVEN;
				case '8' : return EIGHT;
				case '9' : return NINE;
				case 'T' : return TEN;
				case 'J' : return JACK;
				case 'Q' : return QUEEN;
				case 'K' : return KING;
				case 'A' : return ACE;
				default: throw new IllegalArgumentException("Illegal value");
			}
		}
	}
}
