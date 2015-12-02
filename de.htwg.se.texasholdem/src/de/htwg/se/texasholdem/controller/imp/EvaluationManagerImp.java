package de.htwg.se.texasholdem.controller.imp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.imp.Rank;
import de.htwg.se.texasholdem.model.imp.Suit;

public class EvaluationManagerImp implements EvaluationManager {

	// <------------- HELPER METHODS -------------->

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

	private List<Card> getFiveHighestCards(List<Card> sevenCards) {
		List<Card> fiveCards = new LinkedList<Card>();
		Card card;

		for (int i = 0; i < 5; i++) {
			card = getHighestCard(sevenCards);
			fiveCards.add(card);
			sevenCards.remove(card);
		}

		return fiveCards;
	}

	// <------------- EVALUATION & HELPER METHODS -------------->

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

	// <------------- EVALUATION METHODS -------------->

	public HashMap<Card, Card> isOnePair(List<Card> sevenCards) {
		HashMap<Card, Card> pairs = findPairs(sevenCards);

		if (pairs.size() == 1) {
			return pairs;
		} else if (pairs.size() > 1) {
			List<Card> oneCardOfEachPair = new LinkedList<Card>();
			Card highestCard;

			oneCardOfEachPair.addAll(pairs.keySet());
			highestCard = getHighestCard(oneCardOfEachPair);

			for (Object card : pairs.keySet().toArray()) {
				if (card != highestCard) {
					pairs.remove(card);
				}
			}

			return pairs;
		} else {
			return null;
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
				return getFiveHighestCards(straight);
			}
		}
		return null;
	}

	public List<Card> isFlush(List<Card> sevenCards) {
		List<Card> flush = new LinkedList<Card>();

		for (Suit suit : Suit.values()) {
			flush.clear();

			for (Card card : sevenCards) {
				if (suit == card.getSuit()) {
					flush.add(card);
				}
			}

			if (flush.size() == 5) {
				return flush;
			} else if (flush.size() >= 5) {
				return getFiveHighestCards(flush);
			}
		}
		return null;
	}

	public List<Card> isFullHouse(List<Card> sevenCards) {

		List<Card> fullHouse = new LinkedList<Card>();
		fullHouse.addAll(isThreeOfAKind(sevenCards));

		if (fullHouse.size() == 0) {
			return null;
		} else {
			sevenCards.removeAll(fullHouse);
			HashMap<Card, Card> onePair = isOnePair(sevenCards);
			if (onePair == null || onePair.size() == 0) {
				return null;
			} else {
				for (HashMap.Entry<Card, Card> entry : onePair.entrySet()) {
					fullHouse.add(entry.getKey());
					fullHouse.add(entry.getValue());
				}

				return fullHouse;
			}
		}
	}

	public List<Card> isStraightFlush(List<Card> sevenCards) {
		List<Card> straightFlush = new LinkedList<Card>();

		for (Suit suit : Suit.values()) {
			straightFlush.clear();

			for (Card card : sevenCards) {
				if (suit == card.getSuit()) {
					straightFlush.add(card);
				}
			}

			if (straightFlush.size() >= 5) {
				straightFlush = isStraight(straightFlush);
				if (straightFlush.size() > 5) {
					return getFiveHighestCards(straightFlush);
				}
				return straightFlush;
			}
		}
		return null;
	}
}
