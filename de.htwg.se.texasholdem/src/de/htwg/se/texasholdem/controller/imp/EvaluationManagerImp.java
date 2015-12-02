package de.htwg.se.texasholdem.controller.imp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.model.Card;

public class EvaluationManagerImp implements EvaluationManager {

	// Finds pairs in List 'sevenCards' and add them into a HashMap
	private HashMap<Card, Card> findPairs(List<Card> sevenCards) {
		HashMap<Card, Card> pairs = new HashMap<Card, Card>();

		// 2 For-loops to iterate over all Cards to check each card against each
		// other (to be sure to match every combination)
		for (Card cardOne : sevenCards) {
			for (Card cardTwo : sevenCards) {
				// cardOne needs to be different to cardTwo and must have same
				// Rank
				if (cardOne != cardTwo && cardOne.getRank() == cardTwo.getRank()) {
					// Adds the pair to the HashMap if cardOne nor cardTwo were
					// already added
					if (!(pairs.containsKey(cardOne) || pairs.containsKey(cardTwo))) {
						pairs.put(cardOne, cardTwo);
					}
				}
			}
		}
		// Size of HashMap equals number of pairs found in 'sevenCards'
		return pairs;
	}

	public HashMap<Card, Card> isOnePair(List<Card> sevenCards) {
		HashMap<Card, Card> pairs = findPairs(sevenCards);

		if (pairs.size() != 1) {
			return null;
		} else {
			return pairs;
		}
	}

	public HashMap<Card, Card> isTwoPair(List<Card> sevenCards) {
		HashMap<Card, Card> pairs = findPairs(sevenCards);

		if (pairs.size() != 2) {
			return null;
		} else {
			return pairs;
		}
	}

	// Finds sameOfAKind in List 'sevenCards' and adds them to another list
	private List<Card> findCardsofSameKind(List<Card> sevenCards) {
		List<Card> cardsOfSameKind = new LinkedList<Card>();

		// 2 For-loops to iterate over all Cards to check each card against each
		// other (to be sure to match every combination)
		for (Card cardOne : sevenCards) {
			// Clear list and add first card to the list
			cardsOfSameKind.clear();
			cardsOfSameKind.add(cardOne);

			for (Card cardTwo : sevenCards) {
				// cardOne needs to be different to cardTwo and must have same
				// Rank
				if (cardOne != cardTwo && cardOne.getRank() == cardTwo.getRank()) {
					// Add only cardTwo; cardOne was already added.
					cardsOfSameKind.add(cardTwo);
				}
			}

			// Check list size for ThreeOfAKind(size 3) or higher and return
			// list with cards
			if (cardsOfSameKind.size() >= 3) {
				return cardsOfSameKind;
			}
		}

		return null;
	}

	public List<Card> isThreeOfAKind(List<Card> sevenCards) {
		List<Card> cardsOfSameKind = findCardsofSameKind(sevenCards);

		if (cardsOfSameKind != null) {
			return cardsOfSameKind;
		} else {
			return null;
		}
	}

	public List<Card> isFourOfAKind(List<Card> sevenCards) {
		List<Card> cardsOfSameKind = findCardsofSameKind(sevenCards);

		if (cardsOfSameKind != null) {
			return cardsOfSameKind;
		} else {
			return null;
		}
	}

	public Card getHighestCard(List<Card> sevenCards) {
		Card highestCard = null;

		// Hint: ordinal() returns index of element in enum
		// if highestCard is null or the index in enum of card c is higher than
		// highestcard, then highestCard is set to c
		for (Card c : sevenCards) {
			if (highestCard == null || c.getRank().ordinal() > highestCard.getRank().ordinal()) {
				highestCard = c;
			}
		}

		return highestCard;
	}
}
