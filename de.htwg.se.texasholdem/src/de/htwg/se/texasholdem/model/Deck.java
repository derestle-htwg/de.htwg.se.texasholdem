package de.htwg.se.texasholdem.model;

import java.util.LinkedList;

public interface Deck {

	public void addCard(Card newCard);

	public Card getCard();

	public LinkedList<Card> getCards();

	public int getNumberOfCards();

	public void shuffleDeck();

}
