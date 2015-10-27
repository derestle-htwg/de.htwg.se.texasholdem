package model.imp;

import java.util.Collections;
import java.util.LinkedList;

import model.Card;
import model.Deck;

public class DeckImp implements Deck {

	public DeckImp() {
		// TODO Auto-generated constructor stub
	}

	public LinkedList<Card> getCards() {
		return cards;
	}

	public void setCards(LinkedList<Card> cards) {
		this.cards = cards;
	}

	private LinkedList<Card> cards = new LinkedList<Card>();



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
