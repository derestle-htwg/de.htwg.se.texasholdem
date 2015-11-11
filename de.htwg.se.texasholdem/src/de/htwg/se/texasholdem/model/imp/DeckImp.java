package de.htwg.se.texasholdem.model.imp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Deck;

public class DeckImp implements Deck {

	private List<Card> cards = new LinkedList<Card>();

	public void addCard(Card newCard) {
		cards.add(newCard);
	}

	public Card getCard() {
		return cards.remove(0);
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getNumberOfCards() {
		return cards.size();
	}

	public void shuffleDeck() {
		List<Card> tmpList = new LinkedList<Card>(cards);

		do {
			Collections.shuffle(this.cards);
		} while (tmpList.get(0).toString().equals(cards.get(0).toString()));
	}
}
