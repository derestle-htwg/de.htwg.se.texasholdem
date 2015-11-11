package de.htwg.se.texasholdem.controller.imp;

import de.htwg.se.texasholdem.controller.DeckManager;
import de.htwg.se.texasholdem.model.Deck;
import de.htwg.se.texasholdem.model.imp.CardImp;
import de.htwg.se.texasholdem.model.imp.DeckImp;
import de.htwg.se.texasholdem.model.imp.Rank;
import de.htwg.se.texasholdem.model.imp.Suit;

public class DeckManagerImp implements DeckManager {

	private final Deck deck;

	public DeckManagerImp() {
		deck = new DeckImp();
	}

	public void createShuffledDeck() {

		emptyDeck();

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.addCard(new CardImp(r, s));
			}
		}

		deck.shuffleDeck();
	}

	public void emptyDeck() {

		while (!deck.getCards().isEmpty()) {
			deck.getCards().remove(0);
		}
	}

	public Deck getDeck() {
		return deck;
	}

}
