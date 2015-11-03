package de.htwg.se.texasholdem.model.imp;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.model.Card;

public class DeckImpTest {

	private DeckImp deck;
	//private LinkedList<Card> copyFromDeck;

	@Before
	public void _setup() {
		deck = new DeckImp();
		
		/* Create Deck with 52 Cards*/
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				deck.addCard(new CardImp(r, s));
			}
		}
		
		/* Create a copy from deck */
		/*for (int i = 0; i < deck.getCards().size(); i++) {
			copyFromDeck.add(i, deck.getCards().get(i));
		}*/
		
	}

	@Test
	public void getCard_inputDeckWith52Cards_returnsOneCard() {
		Card card = deck.getCard();
		Assert.assertEquals(CardImp.class, card.getClass());
	}

	@Test
	public void getCards_inputDeckWith52Cards_returnsCardListWith52Cards() {
		LinkedList<Card> cardList = deck.getCards();
		Assert.assertEquals(52, cardList.size());
	}

	@Test
	public void getNumberOfCards_inputDeckWith52Cards_returnsInteger52() {
		Assert.assertEquals(52, deck.getNumberOfCards());
	}
	
	/*@Test
	public void shuffleDeck_inputDeck_returnMixedDeck() {
		deck.shuffleDeck();
		Assert.assertNotSame(copyFromDeck.get(0), deck.getCards().get(0));
	}*/

}
