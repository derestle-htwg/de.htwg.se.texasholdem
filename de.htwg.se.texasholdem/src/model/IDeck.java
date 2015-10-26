package model;

import java.util.LinkedList;

public interface IDeck {
	
	public ICard getCard();

	public LinkedList<ICard> getCardList();

	public int getNumberOfCards();

}
