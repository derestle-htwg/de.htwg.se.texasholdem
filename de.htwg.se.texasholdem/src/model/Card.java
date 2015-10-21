package model;

public class Card {

	public static enum Rank {
		TWO {
			@Override
			public String toString() {
				return "2";
			}
		},
		THREE {
			@Override
			public String toString() {
				return "3";
			}
		},
		FOUR {
			@Override
			public String toString() {
				return "4";
			}
		},
		FIVE {
			@Override
			public String toString() {
				return "5";
			}
		},
		SIX {
			@Override
			public String toString() {
				return "6";
			}
		},
		SEVEN {
			@Override
			public String toString() {
				return "7";
			}
		},
		EIGHT {
			@Override
			public String toString() {
				return "8";
			}
		},
		NINE {
			@Override
			public String toString() {
				return "9";
			}
		},
		TEN {
			@Override
			public String toString() {
				return "10";
			}
		},
		JACK {
			@Override
			public String toString() {
				return "J";
			}
		},
		QUEEN {
			@Override
			public String toString() {
				return "Q";
			}
		},
		KING {
			@Override
			public String toString() {
				return "K";
			}
		},
		ACE {
			@Override
			public String toString() {
				return "A";
			}
		}
	}

	public static enum Suit {
		SPACE {
			@Override
			public String toString() {
				return "S";
			}
		},
		DIAMOND {
			@Override
			public String toString() {
				return "D";
			}
		},
		HEART {
			@Override
			public String toString() {
				return "H";
			}
		},
		CLUB {
			@Override
			public String toString() {
				return "C";
			}
		};
	}

	Rank rank;

	Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return this.rank;
	}

	public Suit getSuit() {
		return this.suit;
	}

	@Override
	public String toString() {

		int cardNameMaxLength = 3;
		StringBuilder s = new StringBuilder(suit + " " + rank);
		return s.toString();
	}
}