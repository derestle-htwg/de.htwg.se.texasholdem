package model;

import model.imp.Card.Rank;
import model.imp.Card.Suit;

public interface ICard {
	
	public Rank getRank();

	public Suit getSuit();

	public String toString();

}
