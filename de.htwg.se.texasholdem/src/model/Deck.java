package model;

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
		return cards.getFirst();
	}

	public int getNumberOfCards() {
		return cards.size();
	}

	/*
	 * private List<Card> deck;
	 *
	 *
	 * // Create the Deck with 52 cards public Deck() { deck = new
	 * ArrayList<Card>(); for (Card.Suit suit : Card.Suit.values()) { for
	 * (Card.Rank rank : Card.Rank.values()) { this.deck.add(new Card(rank,
	 * suit)); } } }
	 *
	 * public void shuffleDeck() { Collections.shuffle(deck); }
	 *
	 *
	 * public List<Card> getDeckCards() { return deck; }
	 *
	 * public int getDeckSize() { return deck.size(); }
	 *
	 *
	 * delete the first Card from Deck and return this public Card getCard() {
	 * return deck.remove(0); }
	 */
}
