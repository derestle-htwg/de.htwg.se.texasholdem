package model;

import java.util.LinkedList;

public interface ModelFactory {
	
	Card createCard();
	
	Deck createDeck();
	
	Place createPlace();
	
	Table createTable(LinkedList<Card> cardList);
	
	Player createPlayer();
	
}
