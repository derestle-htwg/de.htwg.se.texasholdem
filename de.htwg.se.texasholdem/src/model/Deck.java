package model;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	private LinkedList<Card> cards = new LinkedList<Card>();

	public Deck(int i) {

		for (Card.Rank rank : Card.Rank.values()) {
			for (Card.Suit suit : Card.Suit.values()) {
				cards.add(new Card(rank, suit));
			}
		}
	}

	public Card getCard() {
		return cards.remove();
	}

	public LinkedList<Card> getCardList() {
		return cards;
	}

	public int getNumberOfCards() {
		return cards.size();
	}

	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
}
