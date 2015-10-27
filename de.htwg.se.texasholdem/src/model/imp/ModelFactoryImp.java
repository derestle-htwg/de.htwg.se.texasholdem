package model.imp;

import java.util.LinkedList;

import model.Card;
import model.Deck;
import model.ModelFactory;
import model.Place;
import model.Player;
import model.Table;

public class ModelFactoryImp implements ModelFactory {


	public Place createPlace() {
		return new PlaceImp();
	}

	public Card createCard() {
		return new CardImp();
	}

	public Table createTable(LinkedList<Card> cardList) {
		return new TableImp(cardList);
	}

	public Deck createDeck() {
		return new DeckImp();
	}

	public Player createPlayer() {
		return null;
	}

}
