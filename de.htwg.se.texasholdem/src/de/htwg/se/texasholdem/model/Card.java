package de.htwg.se.texasholdem.model;

import de.htwg.se.texasholdem.model.imp.Rank;
import de.htwg.se.texasholdem.model.imp.Suit;

public interface Card {

	@Override
	public String toString();

	public Rank getRank();

	public Suit getSuit();

}
