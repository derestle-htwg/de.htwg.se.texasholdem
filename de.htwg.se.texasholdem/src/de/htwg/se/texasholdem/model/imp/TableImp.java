package de.htwg.se.texasholdem.model.imp;

import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Table;

public class TableImp implements Table {

	private List<Player> players;
	private int potValue;
	private int smallBlind;
	private List<Card> communityCards;

	public TableImp() {
		players = new LinkedList<Player>();
		communityCards = new LinkedList<Card>();
	}

	public void addCommunityCard(Card card) {
		communityCards.add(card);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	/**
	 * returns a string of the form +---+ (i.e. in the case of blockSize = 1)
	 */
	String blockSeparator(int blockSize) {
		StringBuffer result = new StringBuffer("+");
		for (int i = 0; i < blockSize; i++) {
			for (int j = 0; j < 12; j++) {
				result.append("-");
			}
			result.append("+");
		}
		return result.toString();
	}

	public void clearCommunityCards() {
		communityCards.clear();
	}

	public int getBigBlind() {
		return smallBlind * 2;
	}

	public List<Card> getCommunityCards() {
		return communityCards;
	}

	public Player getNextPlayer(Player player) {
		int index = players.indexOf(player);
		return players.get((index + 1) % players.size());
	}

	public List<Player> getPlayerList() {
		return players;
	}

	public int getPot() {
		return potValue;
	}

	public int getSmallBlind() {
		return smallBlind;
	}

	public void setPot(int value) {
		potValue = value;
	}

	public void setSmallBlind(int smallBlind) {
		this.smallBlind = smallBlind;
	}

	/*
	 * @Override public String toString() { return toString(" "); }
	 */

	@Override
	public String toString() {
		String newLine = System.getProperty("line.separator");
		List<String> stringList;
		final int FOUR = 4, ZERO = 0;
		int btmRow = players.size() > FOUR ? players.size() % FOUR : ZERO;
		int topRow = players.size() - btmRow;

		// TOP ROW
		String result = blockSeparator(topRow) + newLine;
		for (int row = 0; row < 3; row++) {
			result = result + "|";
			for (int i = 0; i < topRow; i++) {
				stringList = players.get(i).getPlayerStats();
				result = result + " " + stringList.get(row) + " |";
			}
			result = result + newLine;
		}

		result = result + blockSeparator(topRow) + newLine + newLine;

		// COMMUNITY CARDS
		int communityCardSize = 23;
		int separatorSum = ((this.players.size() % 4) * 12 + ((this.players.size() % 4 + 1))) / 2;
		int separator = separatorSum / 2;

		if (communityCards.isEmpty()) {
			result = result + newLine;
		} else {
			if (separatorSum <= communityCardSize) {

			}
		}

		// POT

		// BOTTOM ROW
		if (btmRow != 0) {
			result = result + blockSeparator(btmRow) + newLine;
			for (int row = 0; row < 3; row++) {
				result = result + "|";
				for (int i = topRow; i < btmRow + topRow; i++) {
					stringList = players.get(i).getPlayerStats();
					result = result + " " + stringList.get(row) + " |";
				}
				result = result + newLine;
			}

			result = result + blockSeparator(btmRow) + newLine;
		}

		return result.toString();
	}
}
