package model.imp;

import model.Card;

public class CardImp implements Card {

	private Rank rank;
	private Suit suit;

	public CardImp(Rank rank, Suit suit) {
		setRank(rank);
		setSuit(suit);

	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	private void setRank(Rank rank) {
		this.rank = rank;
	}

	private void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(rank + " " + suit);
		return s.toString();
	}
}