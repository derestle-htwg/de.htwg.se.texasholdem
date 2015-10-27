package model;

import model.imp.Rank;
import model.imp.Suit;

public interface Card {
	
	public Rank getRank();

	public Suit getSuit();
	
	public Rank setRank(Rank rank);
	
	public Suit setSuit(Suit suit);

	public String toString();

}
