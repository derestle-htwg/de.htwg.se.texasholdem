package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.controller.imp.EvaluationManagerImp;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.CardImp;
import de.htwg.se.texasholdem.model.imp.EvaluationObject;
import de.htwg.se.texasholdem.model.imp.PlayerImp;
import de.htwg.se.texasholdem.model.imp.Rank;
import de.htwg.se.texasholdem.model.imp.Suit;

public class EvaluationManagerImpTest {

	private EvaluationManager evaluationManager;
	private List<Card> sevenCards;
	private List<Player> players;

	private Card aceH, aceD, aceC, aceS;
	private Card eightH, eightD;
	private Card sevenH, sevenD;
	private Card twoH, threeH, fourH, fiveH, sixH, nineH, tenH, jackH, queenH, kingH;

	private Player p1, p2, p3;

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

		players = new LinkedList<Player>();
		p1 = new PlayerImp("p1");
		p2 = new PlayerImp("p2");
		p3 = new PlayerImp("p3");
	}

	@Test
	public void getSumOfCards_inputFiveCards_returnsSumOfThisCards() {
		sevenCards.add(aceC);
		sevenCards.add(fourH);

		sevenCards.add(kingH);
		sevenCards.add(queenH);
		sevenCards.add(threeH);

		int actualSumOfCards = evaluationManager.getSumOfCards(sevenCards);
		int expectedSumOfCards = aceC.getRank().numVal() + fourH.getRank().numVal() + kingH.getRank().numVal()
				+ queenH.getRank().numVal() + threeH.getRank().numVal();

		Assert.assertEquals(expectedSumOfCards, actualSumOfCards);
	}

	@Test
	public void evaluate_inputThreePlayersWithStraight_returnsSortedWinnerListWithThreePlayers() {
		List<EvaluationObject> evalList;
		EvaluationObject evalObj;

		players.add(p1);
		players.add(p2);
		players.add(p3);

		sevenCards.add(tenH);
		sevenCards.add(eightD);
		sevenCards.add(sevenH);
		sevenCards.add(sixH);
		sevenCards.add(fiveH);

		p1.setHoleCard(new CardImp(Rank.THREE, Suit.CLUB));
		p1.setHoleCard(new CardImp(Rank.FIVE, Suit.DIAMOND));

		p2.setHoleCard(new CardImp(Rank.NINE, Suit.DIAMOND));
		p2.setHoleCard(new CardImp(Rank.JACK, Suit.DIAMOND));

		p3.setHoleCard(new CardImp(Rank.NINE, Suit.DIAMOND));
		p3.setHoleCard(new CardImp(Rank.TWO, Suit.DIAMOND));

		evalList = evaluationManager.evaluate(players, sevenCards);

		Assert.assertNotNull(evalList);
		Assert.assertTrue(evalList.size() == players.size());

		evalObj = evalList.get(0);

		Assert.assertEquals(p2, evalObj.getPlayer());
	}

	@Test
	public void evaluate_inputThreePlayers_returnsSortedWinnerListWithThreePlayers() {
		List<EvaluationObject> evalList;
		EvaluationObject evalObj;

		players.add(p1);
		players.add(p2);
		players.add(p3);

		sevenCards.add(aceC);
		sevenCards.add(fourH);

		sevenCards.add(kingH);
		sevenCards.add(queenH);
		sevenCards.add(threeH);

		p1.setHoleCard(new CardImp(Rank.TWO, Suit.CLUB));
		p1.setHoleCard(new CardImp(Rank.JACK, Suit.DIAMOND));

		p3.setHoleCard(new CardImp(Rank.KING, Suit.DIAMOND));
		p3.setHoleCard(new CardImp(Rank.TWO, Suit.DIAMOND));

		p2.setHoleCard(new CardImp(Rank.JACK, Suit.DIAMOND));
		p2.setHoleCard(new CardImp(Rank.TEN, Suit.DIAMOND));

		evalList = evaluationManager.evaluate(players, sevenCards);

		Assert.assertNotNull(evalList);
		Assert.assertTrue(evalList.size() == players.size());

		evalObj = evalList.get(0);

		Assert.assertEquals(p2, evalObj.getPlayer());
	}

	@Test
	public void evaluate_inputTwoPlayersWithOnePair_returnsSortedWinnerListWithTwoPlayers() {
		List<EvaluationObject> evalList;
		EvaluationObject evalObj1, evalObj2;

		players.add(p1);
		players.add(p2);

		sevenCards.add(kingH);
		sevenCards.add(queenH);
		sevenCards.add(eightD);

		sevenCards.add(fourH);
		sevenCards.add(threeH);

		p1.setHoleCard(new CardImp(Rank.THREE, Suit.CLUB));
		p1.setHoleCard(new CardImp(Rank.TWO, Suit.DIAMOND));

		p2.setHoleCard(new CardImp(Rank.THREE, Suit.DIAMOND));
		p2.setHoleCard(new CardImp(Rank.FIVE, Suit.DIAMOND));

		evalList = evaluationManager.evaluate(players, sevenCards);

		Assert.assertNotNull(evalList);
		Assert.assertTrue(evalList.size() == players.size());

		evalObj1 = evalList.get(0);
		evalObj2 = evalList.get(1);

		Assert.assertTrue(evalObj1.isSplit() == evalObj2.isSplit());
		Assert.assertTrue(evalObj1.getRanking().ordinal() == evalObj2.getRanking().ordinal());
	}

	@Test
	public void evaluate_inputTwoPlayersWithHighestCard_returnsSortedWinnerListWithTwoPlayers() {
		List<EvaluationObject> evalList;
		EvaluationObject evalObj1, evalObj2;

		players.add(p1);
		players.add(p2);

		sevenCards.add(aceH);
		sevenCards.add(queenH);
		sevenCards.add(tenH);

		sevenCards.add(eightD);
		sevenCards.add(threeH);

		p1.setHoleCard(new CardImp(Rank.ACE, Suit.DIAMOND));
		p1.setHoleCard(new CardImp(Rank.FIVE, Suit.CLUB));

		p2.setHoleCard(new CardImp(Rank.ACE, Suit.SPACE));
		p2.setHoleCard(new CardImp(Rank.TWO, Suit.SPACE));

		evalList = evaluationManager.evaluate(players, sevenCards);

		Assert.assertNotNull(evalList);
		Assert.assertTrue(evalList.size() == players.size());

		evalObj1 = evalList.get(0);
		evalObj2 = evalList.get(1);

		Assert.assertTrue(evalObj1.isSplit() == evalObj2.isSplit());
		Assert.assertTrue(evalObj1.getRanking().ordinal() == evalObj2.getRanking().ordinal());
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
	public void isThreeOfAKind_inputSevenCardsWithThreeOfAKind_returnsNull() {
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

		List<Card> pairs = evaluationManager.isTwoPair(sevenCards);

		Assert.assertNotNull(pairs);
		Assert.assertTrue(pairs.contains(aceH));
		Assert.assertTrue(pairs.contains(aceD));
		Assert.assertTrue(pairs.contains(sevenD));
		Assert.assertTrue(pairs.contains(sevenH));
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

		List<Card> pairs = evaluationManager.isTwoPair(sevenCards);

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

		List<Card> pairs = evaluationManager.isOnePair(sevenCards);

		Assert.assertNotNull(pairs);
		Assert.assertTrue(pairs.contains(aceH));
		Assert.assertTrue(pairs.contains(aceD));
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

		List<Card> pairs = evaluationManager.isOnePair(sevenCards);

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

		List<Card> pairs = evaluationManager.isOnePair(sevenCards);

		Assert.assertNotNull(pairs);

		Assert.assertTrue(pairs.contains(aceH));
		Assert.assertTrue(pairs.contains(aceD));
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

		Card highestCard = evaluationManager.getHighestCard(sevenCards).get(0);

		Assert.assertEquals(aceH, highestCard);
	}
}
