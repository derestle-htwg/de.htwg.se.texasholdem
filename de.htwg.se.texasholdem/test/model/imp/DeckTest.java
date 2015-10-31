package model.imp;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.imp.CardImp;
import de.htwg.se.texasholdem.model.imp.DeckImp;
import de.htwg.se.texasholdem.model.imp.Rank;
import de.htwg.se.texasholdem.model.imp.Suit;

public class DeckTest {

	DeckImp d;

	@Before
	public void _setup() {
		d = new DeckImp();

		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				d.addCard(new CardImp(r, s));
			}
		}
	}

	@Test
	public void getCard_inputDeckWith52Cards_returnsOneCard() {
		Card c = d.getCard();
		Assert.assertEquals(CardImp.class, c.getClass());
	}

	@Test
	public void getCards_inputDeckWith52Cards_returnsCardListWith52Cards() {
		LinkedList<Card> cardList = d.getCards();
		Assert.assertEquals(52, cardList.size());
	}

	@Test
	public void getNumberOfCards_inputDeckWith52Cards_returnsInteger52() {
		Assert.assertEquals(52, d.getNumberOfCards());
	}

}
