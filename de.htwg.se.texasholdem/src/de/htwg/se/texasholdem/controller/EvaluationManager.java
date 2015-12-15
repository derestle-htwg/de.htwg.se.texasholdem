package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.EvaluationObject;
import de.htwg.se.texasholdem.model.Player;

public interface EvaluationManager {

	List<Card> getHighestCard(List<Card> cards);

	List<Card> isOnePair(List<Card> cards);

	List<Card> isTwoPair(List<Card> cards);

	List<Card> isThreeOfAKind(List<Card> cards);

	List<Card> isFourOfAKind(List<Card> cards);

	List<Card> isStraight(List<Card> cards);

	List<Card> isFlush(List<Card> cards);

	List<Card> isFullHouse(List<Card> cards);

	List<Card> isStraightFlush(List<Card> cards);

	List<Card> isRoyalFlush(List<Card> cards);

	List<EvaluationObject> evaluate(List<Player> players, List<Card> communityCards);

	int getSumOfCards(List<Card> cards);
}
