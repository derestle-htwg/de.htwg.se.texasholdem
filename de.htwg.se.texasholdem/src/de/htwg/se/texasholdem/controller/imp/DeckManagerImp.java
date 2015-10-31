package de.htwg.se.texasholdem.controller.imp;

import de.htwg.se.texasholdem.controller.DeckManager;
import de.htwg.se.texasholdem.model.Deck;
import de.htwg.se.texasholdem.model.imp.CardImp;
import de.htwg.se.texasholdem.model.imp.DeckImp;
import de.htwg.se.texasholdem.model.imp.Rank;
import de.htwg.se.texasholdem.model.imp.Suit;

public class DeckManagerImp implements DeckManager {

	Deck deck = new DeckImp();

	public Deck getDeck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.addCard(new CardImp(r, s));
			}
		}
		return deck;
	}

}
