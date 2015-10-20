package model;

public class Card {
	
	private Suit suit;
	private Rank rank;
	
	public enum Suit
	{
		// SPADE, DIAMOND, HEART, CLUB
		S, D, H, C;
	}
	
	public enum Rank
	{
		TWO 	{
					public String toString() {
						return "2";
				}
		},
		
		THREE 	{
					public String toString() {
						return "3";
					}
				},
		
		FOUR	{
					public String toString() {
						return "4";
					}
				},
		
		FIVE	{
					public String toString() {
						return "5";
					}
				},
				
		SIX		{
					public String toString() {
						return "6";
					}
				},
		
		SEVEN 	{
					public String toString() {
						return "7";
					}
				},
			
		EIGHT	{
					public String toString() {
						return "8";
					}
				},
		
		NINE	{
					public String toString() {
						return "9";
					}
				},
	
		TEN		{
					public String toString() {
						return "10";
					}
				},
				
		J, Q, K, A;
				// JACK, QUEEN, KING, ACE
		
				
	}
	
	public Card(Rank rank, Suit suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank()
	{
		return rank;
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	
	@Override
	public String toString()
	{
		int cardNameMaxLength = 3;
		StringBuilder s = new StringBuilder (suit + " " + rank);
		for (@SuppressWarnings("unused") int i = 0; s.length() < cardNameMaxLength; i++)
		{
			s.append(" ");
		}
		return s.toString();
	}
}
