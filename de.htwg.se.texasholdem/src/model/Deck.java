package model;

import java.util.LinkedList;

public interface Deck {
	
	public Card getCard();

	public LinkedList<Card> getCardList();

	public int getNumberOfCards();

}
