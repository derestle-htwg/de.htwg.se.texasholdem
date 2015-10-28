package model;

import java.util.LinkedList;

public interface Deck {

	public Card getCard();

	public LinkedList<Card> getCards();

	public int getNumberOfCards();

	public void shuffleDeck();

}
