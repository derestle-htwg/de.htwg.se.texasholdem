package de.htwg.se.texasholdem.controller.imp;

import de.htwg.se.texasholdem.controller.DeckManager;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Deck;
import de.htwg.se.texasholdem.model.Deck;
import de.htwg.se.texasholdem.model.Rank;
import de.htwg.se.texasholdem.model.Suit;

public class DeckManagerImp implements DeckManager {

	private final Deck deck;

	public DeckManagerImp() {
		deck = new Deck();
	}

	public void createShuffledDeck() {

		emptyDeck();

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.addCard(new Card(r, s));
			}
		}

		deck.shuffleDeck();
	}

	public void emptyDeck() {
		deck.getCards().clear();
	}

	public Deck getDeck() {
		return deck;
	}

}
