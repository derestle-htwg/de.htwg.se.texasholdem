package model.imp;

import java.util.Collections;
import java.util.LinkedList;

import model.Card;
import model.Deck;

public class DeckImp implements Deck {

	private LinkedList<Card> cards = new LinkedList<Card>();

	public DeckImp() {
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				cards.add(new CardImp(rank, suit));
			}
		}
	}

	public Card getCard() {
		return cards.remove();
	}

	public LinkedList<Card> getCards() {
		return cards;
	}

	public int getNumberOfCards() {
		return cards.size();
	}

	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
}
