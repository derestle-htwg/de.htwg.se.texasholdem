package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Card;

public interface EvaluationManager {

	boolean isOnePair(List<Card> sevenCards);

	boolean isTwoPair(List<Card> sevenCards);

	boolean isThreeOfAKind(List<Card> sevenCards);

	boolean isFourOfAKind(List<Card> sevenCards);

}
