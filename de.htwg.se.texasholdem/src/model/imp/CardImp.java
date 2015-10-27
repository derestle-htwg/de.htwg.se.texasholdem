package model.imp;

import model.Card;

public class CardImp implements Card{

	private Rank rank;
	private Suit suit;

	public CardImp() {
		
	}
	
	public Rank getRank() {
		return rank;
	}


	public Suit getSuit() {
		return suit;
	}


	public Rank setRank(Rank rank) {
		return this.rank = rank;
	}


	public Suit setSuit(Suit suit) {
		return this.suit = suit;
	}
	
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(rank + "" + suit);
		return s.toString();
	}
}