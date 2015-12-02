package de.htwg.se.texasholdem.controller.imp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.imp.Rank;

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

	private List<Card> sortToLowestCard(List<Card> straight) {
		List<Card> sortedStraight = new LinkedList<Card>();

		// for (int i = Rank.values().length; i >= 0; i--) {
		for (int i = 0; i <= Rank.values().length; i++) {
			for (Card c : straight) {
				if (c.getRank().ordinal() == i) {
					sortedStraight.add(c);
				}
			}
		}

		assert (straight.size() == sortedStraight.size());

		return sortedStraight;
	}

	public List<Card> isStraight(List<Card> sevenCards) {

		List<Card> straight = new LinkedList<Card>();

		sevenCards = sortToLowestCard(sevenCards);

		// 2 For-loops to iterate over all Cards to check each card against each
		// other (to be sure to match every combination)
		for (Card cardOne : sevenCards) {
			// Clear list and add first card to the list
			straight.clear();
			straight.add(cardOne);

			for (Card cardTwo : sevenCards) {
				if (cardOne.getRank() == Rank.ACE) {
					if (cardTwo.getRank().ordinal() == (cardOne.getRank().ordinal() - (Rank.values().length - 1)
							+ straight.size() - 1)) {
						straight.add(cardTwo);
					} else {
						continue;
					}
				} else if (cardTwo.getRank().ordinal() == (cardOne.getRank().ordinal() + straight.size())) {
					straight.add(cardTwo);
				} else {
					continue;
				}
			}

			if (straight.size() == 5) {
				return straight;
			} else if (straight.size() >= 5) {
				List<Card> tmpList = new LinkedList<Card>();
				Card tmpCard;

				for (int i = 0; i < 5; i++) {
					tmpCard = getHighestCard(sevenCards);
					tmpList.add(tmpCard);
					sevenCards.remove(tmpCard);
				}

				return tmpList;
			}

		}
		return null;
	}
}
