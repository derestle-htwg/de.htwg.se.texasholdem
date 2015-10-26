package model.imp;

import model.imp.Card;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

	Card c1, c2, c3, c4;

	@Before
	public void _setup() {
		c1 = new Card(Card.Rank.ACE, Card.Suit.DIAMOND);
		c2 = new Card(Card.Rank.THREE, Card.Suit.HEART);
		c3 = new Card(Card.Rank.KING, Card.Suit.CLUB);
		c4 = new Card(Card.Rank.NINE, Card.Suit.SPACE);
	}

	@Test
	public void getRank_inputHeartThree_returnsThree() {
		Assert.assertEquals(Card.Rank.THREE, c2.getRank());
	}

	@Test
	public void getSuit_inputDiamondAce_returnsDiamond() {
		Assert.assertEquals(Card.Suit.DIAMOND, c1.getSuit());
	}

	@Test
	public void toString_inputClubKing_returnsClubKingString() {
		Assert.assertEquals("C K", c3.toString());
	}

	@Test
	public void toString_inputDiamondAce_returnsDiamondAceString() {
		Assert.assertEquals("D A", c1.toString());
	}

	@Test
	public void toString_inputHeartThree_returnsHeartThreeString() {
		Assert.assertEquals("H 3", c2.toString());
	}

	@Test
	public void toString_inputSpaceNine_returnsSpaceNineString() {
		Assert.assertEquals("S 9", c4.toString());
	}
}
