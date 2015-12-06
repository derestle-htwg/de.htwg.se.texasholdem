package de.htwg.se.texasholdem.controller.imp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.CardRank;
import de.htwg.se.texasholdem.model.imp.EvaluationObject;

public class EvaluationManagerImp implements EvaluationManager {

	static final class CardListRankingPair {
		private List<Card> cards;
		private CardRank cardRank;

		private CardListRankingPair(List<Card> cards, CardRank cardRank) {
			this.cards = cards;
			this.cardRank = cardRank;
		}

		public List<Card> getCards() {
			return cards;
		}

		public CardRank getCardRank() {
			return cardRank;
		}
	}

	public List<EvaluationObject> evaluate(List<Player> players, List<Card> communityCards) {
		List<EvaluationObject> evalList = new LinkedList<EvaluationObject>();

		// First Iteration: Set Players and the "5" winning cards out of the
		// seven cards in sum
		for (Player player : players) {
			EvaluationObject evalObj = new EvaluationObject(player);
			CardListRankingPair clrp = (evaluateCards(player.getHoleCards(), communityCards));
			evalObj.setCards(clrp.getCards());
			evalObj.setRanking(clrp.getCardRank());
			evalList.add(evalObj);
		}

		// Sort the 'evalList' regarding to the winning position of the players
		Collections.sort(evalList);

		return evalList;
	}

	private CardListRankingPair evaluateCards(List<Card> playerCards, List<Card> communityCards) {
		List<Card> cards = new LinkedList<Card>();
		List<Card> winningCards = new LinkedList<Card>();
		CardRank cardRank = CardRank.ROYAL_FLUSH;

		// Add all cards to one list
		cards.addAll(playerCards);
		cards.addAll(communityCards);

		// Iterate over all evaluation methods of CardRank
		do {
			winningCards = cardRank.evaluate(cards);
			if (winningCards == null && cardRank.ordinal() > 0) {
				cardRank = CardRank.values()[cardRank.ordinal() - 1];
			}
		} while (winningCards == null && cardRank.ordinal() >= 0);

		return new CardListRankingPair(winningCards, cardRank);
	}

	// Set's position value and changes the order of the List with
	// EvaluationObjects
	private List<EvaluationObject> evaluateWinner(List<EvaluationObject> evalList) {

		return evalList;
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
