package model.imp;

import java.util.Collections;
import java.util.LinkedList;

import model.ICard;
import model.IDeck;

public class Deck implements IDeck {

	private LinkedList<ICard> cards = new LinkedList<ICard>();

	public Deck(int i) {

		for (Card.Rank rank : Card.Rank.values()) {
			for (Card.Suit suit : Card.Suit.values()) {
				cards.add(new Card(rank, suit));
			}
		}
	}

	public ICard getCard() {
		return cards.remove();
	}

	public LinkedList<ICard> getCardList() {
		return cards;
	}

	public int getNumberOfCards() {
		return cards.size();
	}

	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
}
