package de.htwg.se.texasholdem.model.imp;

import java.util.Collections;
import java.util.LinkedList;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Deck;

public class DeckImp implements Deck {

	private LinkedList<Card> cards = new LinkedList<Card>();

	public void addCard(Card newCard) {
		cards.add(newCard);
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
