package de.htwg.se.texasholdem.controller;

import java.util.HashMap;
import java.util.List;

import de.htwg.se.texasholdem.model.Card;

public interface EvaluationManager {

	HashMap<Card, Card> isOnePair(List<Card> sevenCards);

	HashMap<Card, Card> isTwoPair(List<Card> sevenCards);

	List<Card> isThreeOfAKind(List<Card> sevenCards);

	List<Card> isFourOfAKind(List<Card> sevenCards);

	Card getHighestCard(List<Card> sevenCards);

	List<Card> isStraight(List<Card> sevenCards);

	List<Card> isFlush(List<Card> sevenCards);

}
