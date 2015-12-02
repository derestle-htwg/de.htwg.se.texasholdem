package controller.imp;

import java.util.HashMap;
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

	private Card aceH, aceD, aceC, aceS;
	private Card sevenH, sevenD;
	private Card twoH, threeH, fourH, fiveH, sixH;

	@Before
	public void _setup() {
		evaluationManager = new EvaluationManagerImp();
		sevenCards = new LinkedList<Card>();

		aceH = new CardImp(Rank.ACE, Suit.HEART);
		aceD = new CardImp(Rank.ACE, Suit.DIAMOND);
		aceC = new CardImp(Rank.ACE, Suit.CLUB);
		aceS = new CardImp(Rank.ACE, Suit.SPACE);

		sevenH = new CardImp(Rank.SEVEN, Suit.HEART);
		sevenD = new CardImp(Rank.SEVEN, Suit.DIAMOND);

		sixH = new CardImp(Rank.SIX, Suit.HEART);

		fiveH = new CardImp(Rank.FIVE, Suit.HEART);

		fourH = new CardImp(Rank.FOUR, Suit.HEART);

		threeH = new CardImp(Rank.THREE, Suit.HEART);

		twoH = new CardImp(Rank.TWO, Suit.HEART);
	}

	@Test
	public void isFourOfAKind_inputSevenCardsWithFourOfAKind_returnsListWithFourCards() {
		sevenCards.add(aceH);
		sevenCards.add(aceD);
		sevenCards.add(aceC);
		sevenCards.add(aceS);

		sevenCards.add(sevenD);
		sevenCards.add(sevenH);
		sevenCards.add(twoH);

		List<Card> sameOfAKind = evaluationManager.isFourOfAKind(sevenCards);

		Assert.assertNotNull(sameOfAKind);
		Assert.assertTrue(sameOfAKind.contains(aceH));
		Assert.assertTrue(sameOfAKind.contains(aceD));
		Assert.assertTrue(sameOfAKind.contains(aceC));
		Assert.assertTrue(sameOfAKind.contains(aceS));
	}

	@Test
	public void isThreeOfAKind_inputSevenCardsWithThreeOfAKind_returnsListWithThreeCards() {
		sevenCards.add(aceH);
		sevenCards.add(sevenD);
		sevenCards.add(sixH);
		sevenCards.add(fiveH);
		sevenCards.add(fourH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		List<Card> sameOfAKind = evaluationManager.isFourOfAKind(sevenCards);

		Assert.assertNull(sameOfAKind);
	}

	@Test
	public void isThreeOfAKind_inputSevenCardsWithThreeOfAKind_returnsNull() {
		sevenCards.add(aceH);
		sevenCards.add(aceD);
		sevenCards.add(aceC);

		sevenCards.add(sevenD);
		sevenCards.add(sevenH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		List<Card> sameOfAKind = evaluationManager.isThreeOfAKind(sevenCards);

		Assert.assertNotNull(sameOfAKind);
		Assert.assertTrue(sameOfAKind.contains(aceH));
		Assert.assertTrue(sameOfAKind.contains(aceD));
		Assert.assertTrue(sameOfAKind.contains(aceC));
	}

	@Test
	public void isThreeOfAKind_inputSevenCardsWithTwoOfAKind_returnsNull() {
		sevenCards.add(aceH);
		sevenCards.add(aceD);

		sevenCards.add(sevenD);
		sevenCards.add(sevenH);

		sevenCards.add(fourH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		List<Card> sameOfAKind = evaluationManager.isThreeOfAKind(sevenCards);

		Assert.assertNull(sameOfAKind);
	}

	@Test
	public void isTwoPair_inputSevenCardsWithTwoPair_returnsHashMapWithTwoPair() {
		sevenCards.add(aceH);
		sevenCards.add(aceD);

		sevenCards.add(sevenD);
		sevenCards.add(sevenH);

		sevenCards.add(fourH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		HashMap<Card, Card> pairs = evaluationManager.isTwoPair(sevenCards);

		Assert.assertNotNull(pairs);
		Assert.assertTrue((pairs.containsKey(aceH) && pairs.containsValue(aceD))
				|| (pairs.containsKey(aceD) && pairs.containsValue(aceH)));
		Assert.assertTrue((pairs.containsKey(sevenD) && pairs.containsValue(sevenH))
				|| (pairs.containsKey(sevenH) && pairs.containsValue(sevenD)));
	}

	@Test
	public void isTwoPair_inputSevenCardsWithNoPair_returnsNull() {
		sevenCards.add(aceH);
		sevenCards.add(sevenD);
		sevenCards.add(sixH);
		sevenCards.add(fiveH);
		sevenCards.add(fourH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		HashMap<Card, Card> pairs = evaluationManager.isTwoPair(sevenCards);

		Assert.assertNull(pairs);
	}

	@Test
	public void isOnePair_inputSevenCardsWithOnePair_returnsHashMapWithOnePair() {
		sevenCards.add(aceH);
		sevenCards.add(aceD);

		sevenCards.add(sevenD);
		sevenCards.add(fiveH);
		sevenCards.add(fourH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		HashMap<Card, Card> pairs = evaluationManager.isOnePair(sevenCards);

		Assert.assertNotNull(pairs);
		Assert.assertTrue((pairs.containsKey(aceH) && pairs.containsValue(aceD))
				|| (pairs.containsKey(aceD) && pairs.containsValue(aceH)));
	}

	@Test
	public void isOnePair_inputSevenCardsWithNoPair_returnsNull() {
		sevenCards.add(aceH);
		sevenCards.add(sevenD);
		sevenCards.add(sixH);
		sevenCards.add(fiveH);
		sevenCards.add(fourH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		HashMap<Card, Card> pairs = evaluationManager.isOnePair(sevenCards);

		Assert.assertNull(pairs);
	}

	@Test
	public void getHighestCard_inputSevenCardsWithAce_returnsAce() {
		sevenCards.add(aceH);
		sevenCards.add(sevenD);
		sevenCards.add(sixH);
		sevenCards.add(fiveH);
		sevenCards.add(fourH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		Card highestCard = evaluationManager.getHighestCard(sevenCards);

		Assert.assertEquals(aceH, highestCard);
	}
}
