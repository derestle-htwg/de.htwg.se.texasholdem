package de.htwg.se.texasholdem.model.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardImpTest {

	CardImp c1, c2, c3, c4;

	@Before
	public void _setup() {
		c1 = new CardImp(Rank.ACE, Suit.DIAMOND);
		c2 = new CardImp(Rank.THREE, Suit.HEART);
		c3 = new CardImp(Rank.KING, Suit.CLUB);
		c4 = new CardImp(Rank.NINE, Suit.SPACE);
	}

	@Test
	public void getRank_inputHeartThree_returnsThree() {
		Assert.assertEquals(Rank.THREE, c2.getRank());
	}

	@Test
	public void getSuit_inputDiamondAce_returnsDiamond() {
		Assert.assertEquals(Suit.DIAMOND, c1.getSuit());
	}

	@Test
	public void toString_inputClubKing_returnsClubKingString() {
		Assert.assertEquals("K C", c3.toString());
	}

	@Test
	public void toString_inputDiamondAce_returnsDiamondAceString() {
		Assert.assertEquals("A D", c1.toString());
	}

	@Test
	public void toString_inputHeartThree_returnsHeartThreeString() {
		Assert.assertEquals("3 H", c2.toString());
	}

	@Test
	public void toString_inputSpaceNine_returnsSpaceNineString() {
		Assert.assertEquals("9 S", c4.toString());
	}
}
