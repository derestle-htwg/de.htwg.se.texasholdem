package de.htwg.se.texasholdem.controller;

import de.htwg.se.texasholdem.model.Deck;

public interface DeckManager {

	public void createShuffledDeck();

	public void emptyDeck();

	public Deck getDeck();
}
