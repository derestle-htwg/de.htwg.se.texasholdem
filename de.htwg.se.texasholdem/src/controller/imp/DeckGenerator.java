package controller.imp;

import java.util.LinkedList;
import java.util.List;

import model.Card;
import model.Deck;
import model.ModelFactory;
import model.imp.Rank;
import model.imp.Suit;

public class DeckGenerator {
	private ModelFactory modelFactory;
	
	public DeckGenerator(ModelFactory modelFactory){
		
	}
	public Deck generateDeck(){
		Deck result = modelFactory.createDeck();
		List<Card> cards = new LinkedList<Card>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				
				cards.add(modelFactory.createCard());
			}
		}
		
		return result;
		
				
	}

}
