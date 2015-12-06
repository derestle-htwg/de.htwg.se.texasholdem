package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.CardRank;
import de.htwg.se.texasholdem.model.imp.EvaluationObject;

public class EvaluationManagerImp implements EvaluationManager {

	// <------------- HELPER METHODS -------------->

	public List<EvaluationObject> evaluate(List<Player> players, List<Card> communityCards) {
		List<EvaluationObject> evalList = new LinkedList<EvaluationObject>();

		// First Iteration: Set Players and the "5" winning cards out of the
		// seven cards in sum
		for (Player p : players) {
			evaluateCards(p.getHoleCards(), communityCards);
		}

		// Second Iteration: Sort the 'evalList' regarding to the winning
		// position of the players

		return evalList;
	}

	private void evaluateCards(List<Card> playerCards, List<Card> communityCards) {
		List<Card> cards = new LinkedList<Card>();
		List<Card> winningCards = new LinkedList<Card>();
		CardRank cardRank = CardRank.HIGHEST_CARD;

		cards.addAll(playerCards);
		cards.addAll(communityCards);

		while (winningCards.size() == 0 && cardRank.ordinal() < CardRank.values().length) {
			winningCards = cardRank.evaluate(cards);
		}
		String str = winningCards.toString();
		System.out.println(str);
	}

	// <------------- EVALUATION METHODS -------------->

	public List<Card> getHighestCard(List<Card> cards) {
		return CardRank.HIGHEST_CARD.evaluate(cards);
	}

	public List<Card> isOnePair(List<Card> cards) {
		return CardRank.ONE_PAIR.evaluate(cards);
	}

	public List<Card> isTwoPair(List<Card> cards) {
		return CardRank.TWO_PAIR.evaluate(cards);
	}

	public List<Card> isThreeOfAKind(List<Card> cards) {
		return CardRank.THREE_OF_A_KIND.evaluate(cards);
	}

	public List<Card> isStraight(List<Card> cards) {
		return CardRank.STRAIGHT.evaluate(cards);
	}

	public List<Card> isFlush(List<Card> cards) {
		return CardRank.FLUSH.evaluate(cards);
	}

	public List<Card> isFullHouse(List<Card> cards) {
		return CardRank.FULL_HOUSE.evaluate(cards);
	}

	public List<Card> isFourOfAKind(List<Card> cards) {
		return CardRank.FOUR_OF_A_KIND.evaluate(cards);
	}

	public List<Card> isStraightFlush(List<Card> cards) {
		return CardRank.STRAIGHT_FLUSH.evaluate(cards);
	}

	public List<Card> isRoyalFlush(List<Card> cards) {
		return CardRank.ROYAL_FLUSH.evaluate(cards);
	}
}
