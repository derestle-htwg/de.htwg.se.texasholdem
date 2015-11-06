package de.htwg.se.texasholdem.model.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardImpTest {

	CardImp card;

	@Before
	public void _setup() {
		card = new CardImp(Rank.TWO, Suit.HEART);
	}

	@Test
	public void getRank_inputRanksAndSuits_returnsTrue() {
		StringBuilder sb = new StringBuilder();

		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				card = new CardImp(r, s);
				sb.setLength(0);
				sb.append(r + " " + s);
				Assert.assertEquals(sb.toString(), card.toString());
			}
		}
	}

	@Test
	public void getRank_inputTwoOfHearts_returnsTwo() {
		Assert.assertEquals(Rank.TWO, card.getRank());
	}

	@Test
	public void getSuit_inputTwoOfHearts_returnsHearts() {
		Assert.assertEquals(Suit.HEART, card.getSuit());
	}
}
