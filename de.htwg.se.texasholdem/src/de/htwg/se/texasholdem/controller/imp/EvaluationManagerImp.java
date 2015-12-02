package de.htwg.se.texasholdem.controller.imp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.model.Card;

public class EvaluationManagerImp implements EvaluationManager {

	// Finds pairs in List 'sevenCards' and add them into a HashMap
	private int findPairs(List<Card> sevenCards) {
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
		return pairs.size();
	}

	public boolean isOnePair(List<Card> sevenCards) {
		int ret = findPairs(sevenCards);
		if (ret == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTwoPair(List<Card> sevenCards) {
		int ret = findPairs(sevenCards);
		if (ret == 2) {
			return true;
		} else {
			return false;
		}
	}

	// Finds sameOfAKind in List 'sevenCards' and adds them to another list
	private int findCardsofSameKind(List<Card> sevenCards) {
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

			// Check list size for ThreeOfAKind(size 3) or FourOfAKind(size 4)
			if (cardsOfSameKind.size() == 3) {
				return 3;
			} else if (cardsOfSameKind.size() == 4) {
				return 4;
			}
		}

		return 0;
	}

	public boolean isThreeOfAKind(List<Card> sevenCards) {
		int ret = findCardsofSameKind(sevenCards);

		if (ret == 3) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFourOfAKind(List<Card> sevenCards) {
		int ret = findCardsofSameKind(sevenCards);

		if (ret == 4) {
			return true;
		} else {
			return false;
		}
	}
}
