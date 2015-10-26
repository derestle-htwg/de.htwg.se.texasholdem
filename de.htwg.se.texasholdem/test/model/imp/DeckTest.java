package model.imp;

import model.ICard;
import model.imp.Card;
import model.imp.Deck;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	Deck d;

	@Before
	public void _setup() {
		d = new Deck(52);
	}

	@Test
	public void getCard_inputDeckWith52Cards_returnsOneCard() {
		ICard c = d.getCard();
		Assert.assertEquals(Card.class, c.getClass());
	}

	@Test
	public void getNumberOfCards_inputDeckWith52Cards_returnsInteger52() {
		Assert.assertEquals(52, d.getNumberOfCards());
	}
}
