package controller.imp;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.controller.imp.EvaluationManagerImp;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.imp.CardImp;
import de.htwg.se.texasholdem.model.imp.Rank;
import de.htwg.se.texasholdem.model.imp.Suit;

public class EvaluationManagerImpTest {

	private EvaluationManager evaluationManager;
	private List<Card> sevenCards;

	@Before
	public void _setup() {
		evaluationManager = new EvaluationManagerImp();
		sevenCards = new LinkedList<Card>();
	}

	@Test
	public void isFourOfAKind_inputSevenCardsWithFourOfAKind_returnsTrue() {
		sevenCards.add(new CardImp(Rank.ACE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.ACE, Suit.DIAMOND));
		sevenCards.add(new CardImp(Rank.ACE, Suit.CLUB));
		sevenCards.add(new CardImp(Rank.ACE, Suit.SPACE));
		sevenCards.add(new CardImp(Rank.SEVEN, Suit.HEART));
		sevenCards.add(new CardImp(Rank.NINE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.TWO, Suit.HEART));

		Assert.assertTrue(evaluationManager.isFourOfAKind(sevenCards));
	}

	@Test
	public void isThreeOfAKind_inputSevenCardsWithThreeOfAKind_returnsTrue() {
		sevenCards.add(new CardImp(Rank.ACE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.ACE, Suit.DIAMOND));
		sevenCards.add(new CardImp(Rank.ACE, Suit.CLUB));
		sevenCards.add(new CardImp(Rank.FIVE, Suit.SPACE));
		sevenCards.add(new CardImp(Rank.SEVEN, Suit.HEART));
		sevenCards.add(new CardImp(Rank.NINE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.TWO, Suit.HEART));

		Assert.assertTrue(evaluationManager.isThreeOfAKind(sevenCards));
	}

	@Test
	public void isThreeOfAKind_inputSevenCardsWithTwoOfAKind_returnsFalse() {
		sevenCards.add(new CardImp(Rank.ACE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.ACE, Suit.DIAMOND));
		sevenCards.add(new CardImp(Rank.FIVE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.FIVE, Suit.SPACE));
		sevenCards.add(new CardImp(Rank.SEVEN, Suit.HEART));
		sevenCards.add(new CardImp(Rank.NINE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.TWO, Suit.HEART));

		Assert.assertFalse(evaluationManager.isThreeOfAKind(sevenCards));
	}

	@Test
	public void isTwoPair_inputSevenCardsWithTwoPair_returnsTrue() {
		sevenCards.add(new CardImp(Rank.ACE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.ACE, Suit.DIAMOND));
		sevenCards.add(new CardImp(Rank.FIVE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.FIVE, Suit.SPACE));
		sevenCards.add(new CardImp(Rank.SEVEN, Suit.HEART));
		sevenCards.add(new CardImp(Rank.NINE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.TWO, Suit.HEART));

		Assert.assertTrue(evaluationManager.isTwoPair(sevenCards));
	}

	@Test
	public void isTwoPair_inputSevenCardsWithNoPair_returnsFalse() {
		sevenCards.add(new CardImp(Rank.THREE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.ACE, Suit.DIAMOND));
		sevenCards.add(new CardImp(Rank.FIVE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.SIX, Suit.HEART));
		sevenCards.add(new CardImp(Rank.SEVEN, Suit.HEART));
		sevenCards.add(new CardImp(Rank.NINE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.TWO, Suit.HEART));

		Assert.assertFalse(evaluationManager.isTwoPair(sevenCards));
	}

	@Test
	public void isOnePair_inputSevenCardsThreeOfAKind_returnsTrue() {
		sevenCards.add(new CardImp(Rank.ACE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.ACE, Suit.DIAMOND));
		sevenCards.add(new CardImp(Rank.ACE, Suit.CLUB));
		sevenCards.add(new CardImp(Rank.SIX, Suit.HEART));
		sevenCards.add(new CardImp(Rank.SEVEN, Suit.HEART));
		sevenCards.add(new CardImp(Rank.NINE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.TWO, Suit.HEART));

		Assert.assertFalse(evaluationManager.isOnePair(sevenCards));
	}

	@Test
	public void isOnePair_inputSevenCardsWithOnePair_returnsTrue() {
		sevenCards.add(new CardImp(Rank.ACE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.ACE, Suit.DIAMOND));
		sevenCards.add(new CardImp(Rank.FIVE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.SIX, Suit.HEART));
		sevenCards.add(new CardImp(Rank.SEVEN, Suit.HEART));
		sevenCards.add(new CardImp(Rank.NINE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.TWO, Suit.HEART));

		Assert.assertTrue(evaluationManager.isOnePair(sevenCards));
	}

	@Test
	public void isOnePair_inputSevenCardsWithNoPair_returnsFalse() {
		sevenCards.add(new CardImp(Rank.THREE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.ACE, Suit.DIAMOND));
		sevenCards.add(new CardImp(Rank.FIVE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.SIX, Suit.HEART));
		sevenCards.add(new CardImp(Rank.SEVEN, Suit.HEART));
		sevenCards.add(new CardImp(Rank.NINE, Suit.HEART));
		sevenCards.add(new CardImp(Rank.TWO, Suit.HEART));

		Assert.assertFalse(evaluationManager.isOnePair(sevenCards));
	}

}
