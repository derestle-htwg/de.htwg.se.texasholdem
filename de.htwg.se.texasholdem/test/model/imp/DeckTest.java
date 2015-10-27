package model.imp;

import model.Card;
import model.imp.CardImp;
import model.imp.DeckImp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	DeckImp d;

	@Before
	public void _setup() {
		d = new DeckImp();
	}

	@Test
	public void getCard_inputDeckWith52Cards_returnsOneCard() {
		Card c = d.getCard();
		Assert.assertEquals(CardImp.class, c.getClass());
	}

	@Test
	public void getNumberOfCards_inputDeckWith52Cards_returnsInteger52() {
		Assert.assertEquals(52, d.getNumberOfCards());
	}
}
