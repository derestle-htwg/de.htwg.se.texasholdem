package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> deck;
	
	
	// Create the Deck with 52 cards
	public Deck() {
		deck = new ArrayList<Card>();
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Rank rank : Card.Rank.values()) {
				this.deck.add(new Card(rank, suit));
			}
		}
	}
	
	public void shuffleDeck() 
	{
		Collections.shuffle(deck);
	}
	
	
	public List<Card> getDeckCards() 
	{
		return deck;
	}
	
	public int getDeckSize() 
	{
		return deck.size();
	}
	
	
	/* delete the first Card from Deck and return this */
	public Card getCard()
	{
		return deck.remove(0);
	}
}