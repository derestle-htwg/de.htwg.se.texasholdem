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
	private Card eightH, eightD;
	private Card sevenH, sevenD;
	private Card twoH, threeH, fourH, fiveH, sixH, nineH, tenH, jackH, queenH, kingH;

	@Before
	public void _setup() {
		evaluationManager = new EvaluationManagerImp();
		sevenCards = new LinkedList<Card>();

		aceH = new CardImp(Rank.ACE, Suit.HEART);
		aceD = new CardImp(Rank.ACE, Suit.DIAMOND);
		aceC = new CardImp(Rank.ACE, Suit.CLUB);
		aceS = new CardImp(Rank.ACE, Suit.SPACE);

		kingH = new CardImp(Rank.KING, Suit.HEART);

		queenH = new CardImp(Rank.QUEEN, Suit.HEART);

		jackH = new CardImp(Rank.JACK, Suit.HEART);

		tenH = new CardImp(Rank.TEN, Suit.HEART);

		nineH = new CardImp(Rank.NINE, Suit.HEART);

		eightH = new CardImp(Rank.EIGHT, Suit.HEART);
		eightD = new CardImp(Rank.EIGHT, Suit.DIAMOND);

		sevenH = new CardImp(Rank.SEVEN, Suit.HEART);
		sevenD = new CardImp(Rank.SEVEN, Suit.DIAMOND);

		sixH = new CardImp(Rank.SIX, Suit.HEART);

		fiveH = new CardImp(Rank.FIVE, Suit.HEART);

		fourH = new CardImp(Rank.FOUR, Suit.HEART);

		threeH = new CardImp(Rank.THREE, Suit.HEART);

		twoH = new CardImp(Rank.TWO, Suit.HEART);
	}

	@Test
	public void isRoyalFlush_inputSevenCardsWithRoyalFlush_returnsListWithRoyalFlush() {
		sevenCards.add(aceC);
		sevenCards.add(aceD);

		sevenCards.add(aceH);
		sevenCards.add(kingH);
		sevenCards.add(queenH);
		sevenCards.add(jackH);
		sevenCards.add(tenH);

		List<Card> royalFlush = evaluationManager.isRoyalFlush(sevenCards);

		Assert.assertNotNull(royalFlush);

		Assert.assertTrue(royalFlush.contains(aceH));
		Assert.assertTrue(royalFlush.contains(kingH));
		Assert.assertTrue(royalFlush.contains(queenH));
		Assert.assertTrue(royalFlush.contains(jackH));
		Assert.assertTrue(royalFlush.contains(tenH));
	}

	@Test
	public void isRoyalFlush_inputSevenCardsWithRoyalFlush7CardsStraight_returnsListWithRoyalFlush() {
		sevenCards.add(tenH);
		sevenCards.add(nineH);
		sevenCards.add(eightH);
		sevenCards.add(queenH);
		sevenCards.add(aceH);
		sevenCards.add(kingH);
		sevenCards.add(jackH);

		List<Card> royalFlush = evaluationManager.isRoyalFlush(sevenCards);

		Assert.assertNotNull(royalFlush);

		Assert.assertTrue(royalFlush.contains(aceH));
		Assert.assertTrue(royalFlush.contains(kingH));
		Assert.assertTrue(royalFlush.contains(queenH));
		Assert.assertTrue(royalFlush.contains(jackH));
		Assert.assertTrue(royalFlush.contains(tenH));
	}

	@Test
	public void isRoyalFlush_inputSevenCardsWithNoRoyalFlush_returnsNull() {
		sevenCards.add(tenH);
		sevenCards.add(nineH);
		sevenCards.add(eightH);
		sevenCards.add(queenH);
		sevenCards.add(aceD);
		sevenCards.add(kingH);
		sevenCards.add(jackH);

		List<Card> royalFlush = evaluationManager.isRoyalFlush(sevenCards);

		Assert.assertNull(royalFlush);
	}

	@Test
	public void isStraightFlush_inputSevenCardsWithStraightFlush5Cards_returnsListWithStraightFlush() {
		sevenCards.add(twoH);
		sevenCards.add(threeH);
		sevenCards.add(fourH);
		sevenCards.add(fiveH);
		sevenCards.add(sixH);

		sevenCards.add(aceD);
		sevenCards.add(aceC);

		List<Card> straightFlush = evaluationManager.isStraightFlush(sevenCards);

		Assert.assertNotNull(straightFlush);

		Assert.assertTrue(straightFlush.contains(twoH));
		Assert.assertTrue(straightFlush.contains(threeH));
		Assert.assertTrue(straightFlush.contains(fourH));
		Assert.assertTrue(straightFlush.contains(fiveH));
		Assert.assertTrue(straightFlush.contains(sixH));
	}

	@Test
	public void isStraightFlush_inputSevenCardsWithStraightFlush5CardsSpecialCaseAce_returnsListWithStraightFlush() {
		sevenCards.add(aceH);
		sevenCards.add(twoH);
		sevenCards.add(threeH);
		sevenCards.add(fourH);
		sevenCards.add(fiveH);

		sevenCards.add(aceD);
		sevenCards.add(aceC);

		List<Card> straightFlush = evaluationManager.isStraightFlush(sevenCards);

		Assert.assertNotNull(straightFlush);

		Assert.assertTrue(straightFlush.contains(aceH));
		Assert.assertTrue(straightFlush.contains(twoH));
		Assert.assertTrue(straightFlush.contains(threeH));
		Assert.assertTrue(straightFlush.contains(fourH));
		Assert.assertTrue(straightFlush.contains(fiveH));
	}

	@Test
	public void isStraightFlush_inputSevenCardsWithStraightFlush7Cards_returnsListWithStraightFlush() {
		sevenCards.add(twoH);
		sevenCards.add(threeH);
		sevenCards.add(fourH);
		sevenCards.add(fiveH);
		sevenCards.add(sixH);
		sevenCards.add(sevenH);
		sevenCards.add(eightH);

		List<Card> straightFlush = evaluationManager.isStraightFlush(sevenCards);

		Assert.assertNotNull(straightFlush);

		Assert.assertTrue(straightFlush.contains(fourH));
		Assert.assertTrue(straightFlush.contains(fiveH));
		Assert.assertTrue(straightFlush.contains(sixH));
		Assert.assertTrue(straightFlush.contains(sevenH));
		Assert.assertTrue(straightFlush.contains(eightH));
	}

	@Test
	public void isStraightFlush_inputSevenCardsWithNoStraightFlush_returnsNull() {
		sevenCards.add(twoH);
		sevenCards.add(threeH);
		sevenCards.add(fourH);
		sevenCards.add(fiveH);

		sevenCards.add(aceS);
		sevenCards.add(aceD);
		sevenCards.add(aceC);

		List<Card> straightFlush = evaluationManager.isStraightFlush(sevenCards);

		Assert.assertNull(straightFlush);
	}

	@Test
	public void isFullHouse_inputSevenCardsWithFullHouseTwoPairs_returnsListWithFullHouse() {
		sevenCards.add(sevenD);
		sevenCards.add(sevenH);

		sevenCards.add(aceC);
		sevenCards.add(aceD);
		sevenCards.add(aceH);

		sevenCards.add(eightH);
		sevenCards.add(eightD);

		List<Card> fullHouse = evaluationManager.isFullHouse(sevenCards);

		Assert.assertNotNull(fullHouse);

		Assert.assertTrue(fullHouse.contains(aceC));
		Assert.assertTrue(fullHouse.contains(aceD));
		Assert.assertTrue(fullHouse.contains(aceH));
		Assert.assertTrue(fullHouse.contains(eightH));
		Assert.assertTrue(fullHouse.contains(eightD));
	}

	@Test
	public void isFullHouse_inputSevenCardsWithFullHouse_returnsListWithFullHouse() {
		sevenCards.add(aceC);
		sevenCards.add(aceD);
		sevenCards.add(aceH);

		sevenCards.add(sevenD);
		sevenCards.add(sevenH);

		sevenCards.add(threeH);
		sevenCards.add(twoH);

		List<Card> fullHouse = evaluationManager.isFullHouse(sevenCards);

		Assert.assertNotNull(fullHouse);

		Assert.assertTrue(fullHouse.contains(aceC));
		Assert.assertTrue(fullHouse.contains(aceD));
		Assert.assertTrue(fullHouse.contains(aceH));
		Assert.assertTrue(fullHouse.contains(sevenD));
		Assert.assertTrue(fullHouse.contains(sevenH));
	}

	@Test
	public void isFullHouse_inputSevenCardsWithNoFullHouse_returnsNull() {
		sevenCards.add(aceC);
		sevenCards.add(aceD);
		sevenCards.add(aceH);

		sevenCards.add(sevenD);
		sevenCards.add(sixH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		List<Card> fullHouse = evaluationManager.isFullHouse(sevenCards);

		Assert.assertNull(fullHouse);
	}

	@Test
	public void isFlush_inputSevenCardsWithFlush5CardsWithSameSuits_returnsListWithFlushCards() {
		sevenCards.add(aceH);
		sevenCards.add(sixH);
		sevenCards.add(sevenH);
		sevenCards.add(fiveH);
		sevenCards.add(threeH);

		sevenCards.add(aceD);
		sevenCards.add(aceS);

		List<Card> flush = evaluationManager.isFlush(sevenCards);

		Assert.assertNotNull(flush);

		Assert.assertTrue(flush.contains(aceH));
		Assert.assertTrue(flush.contains(sixH));
		Assert.assertTrue(flush.contains(sevenH));
		Assert.assertTrue(flush.contains(fiveH));
		Assert.assertTrue(flush.contains(threeH));
	}

	@Test
	public void isFlush_inputSevenCardsWithFlush7CardsWithSameSuits_returnsListWithFlushCards() {
		sevenCards.add(fiveH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);
		sevenCards.add(aceH);
		sevenCards.add(sixH);
		sevenCards.add(sevenH);
		sevenCards.add(fourH);

		List<Card> flush = evaluationManager.isFlush(sevenCards);

		Assert.assertNotNull(flush);

		Assert.assertTrue(flush.contains(aceH));
		Assert.assertTrue(flush.contains(sixH));
		Assert.assertTrue(flush.contains(sevenH));
		Assert.assertTrue(flush.contains(fiveH));
		Assert.assertTrue(flush.contains(fiveH));
	}

	@Test
	public void isFlush_inputSevenCardsWithNoFlush_returnsNull() {
		sevenCards.add(aceD);
		sevenCards.add(sevenD);
		sevenCards.add(aceD);

		sevenCards.add(sixH);
		sevenCards.add(fiveH);
		sevenCards.add(threeH);

		sevenCards.add(aceS);

		List<Card> flush = evaluationManager.isFlush(sevenCards);

		Assert.assertNull(flush);
	}

	@Test
	public void isStraight_inputSevenCardsWithStraight_returnsListWithStraightCards() {
		sevenCards.add(eightH);
		sevenCards.add(sevenD);
		sevenCards.add(sixH);
		sevenCards.add(fiveH);
		sevenCards.add(fourH);

		sevenCards.add(aceC);
		sevenCards.add(aceH);

		List<Card> straight = evaluationManager.isStraight(sevenCards);

		Assert.assertNotNull(straight);

		Assert.assertTrue(straight.contains(eightH));
		Assert.assertTrue(straight.contains(sevenD));
		Assert.assertTrue(straight.contains(sixH));
		Assert.assertTrue(straight.contains(fiveH));
		Assert.assertTrue(straight.contains(fourH));
	}

	@Test
	public void isStraight_inputSevenCardsWithStraighSpecialCaseAce_returnsListWithStraightCards() {
		sevenCards.add(aceH);
		sevenCards.add(twoH);
		sevenCards.add(threeH);
		sevenCards.add(fiveH);
		sevenCards.add(fourH);

		sevenCards.add(sevenD);
		sevenCards.add(aceH);

		List<Card> straight = evaluationManager.isStraight(sevenCards);

		Assert.assertNotNull(straight);

		Assert.assertTrue(straight.contains(aceH));
		Assert.assertTrue(straight.contains(twoH));
		Assert.assertTrue(straight.contains(threeH));
		Assert.assertTrue(straight.contains(fiveH));
		Assert.assertTrue(straight.contains(fourH));
	}

	public void isStraight_inputSevenCardsWithNoStraight_returnsNull() {
		sevenCards.add(eightH);
		sevenCards.add(sevenD);
		sevenCards.add(sixH);
		sevenCards.add(fiveH);
		sevenCards.add(threeH);
		sevenCards.add(aceC);
		sevenCards.add(aceH);

		List<Card> straight = evaluationManager.isStraight(sevenCards);

		Assert.assertNull(straight);
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
	public void isOnePair_inputSevenCaradsWithTwoPair_returnsHashMapWithOnePair() {
		sevenCards.add(sevenD);
		sevenCards.add(aceD);
		sevenCards.add(sevenH);
		sevenCards.add(aceH);

		sevenCards.add(fourH);
		sevenCards.add(threeH);
		sevenCards.add(twoH);

		HashMap<Card, Card> pairs = evaluationManager.isOnePair(sevenCards);

		Assert.assertNotNull(pairs);

		Assert.assertTrue((pairs.containsKey(aceH) && pairs.containsValue(aceD))
				|| (pairs.containsKey(aceD) && pairs.containsValue(aceH)));
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
