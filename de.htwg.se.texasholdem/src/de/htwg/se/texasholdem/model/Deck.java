package de.htwg.se.texasholdem.model;

import java.util.List;

public interface Deck {

	public void addCard(Card newCard);

	public Card getCard();

	public List<Card> getCards();

	public int getNumberOfCards();

	public void shuffleDeck();

}
