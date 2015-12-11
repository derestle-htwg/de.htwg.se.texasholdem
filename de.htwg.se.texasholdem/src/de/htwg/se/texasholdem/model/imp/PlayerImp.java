package de.htwg.se.texasholdem.model.imp;

import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;

public class PlayerImp implements Player {

	private String playerName;

	private int playerCash;
	private List<Card> holeCards;

	public PlayerImp(String name) {
		setPlayerName(name);
		holeCards = new LinkedList<Card>();
	}

	public void clearHoleCards() {
		while (!holeCards.isEmpty()) {
			holeCards.remove(0);
		}
	}

	public List<Card> getHoleCards() {
		return holeCards;
	}

	public int getPlayerMoney() {
		return playerCash;
	}

	public String getPlayerName() {
		return playerName;
	}

	public List<String> getPlayerStats() {
		List<String> stringList = new LinkedList<String>();

		// Player name
		int blankCharacters = 10 - this.playerName.length();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < blankCharacters; i++) {
			sb.append(" ");
		}
		sb.append(this.playerName);
		stringList.add(sb.toString());

		// Player credits
		blankCharacters = 7 - String.valueOf(this.playerCash).length();

		sb.delete(0, sb.length());

		for (int i = 0; i < blankCharacters; i++) {
			sb.append(" ");
		}
		sb.append(String.valueOf(this.playerCash));
		sb.append(" Cr");
		stringList.add(sb.toString());

		sb.delete(0, sb.length());

		if (this.getHoleCards().size() != 0) {
			for (int i = 0; i < this.getHoleCards().size(); i++) {
				sb.append(" ");
				sb.append(holeCards.get(i).toString());

				sb.append(" ");
			}
		} else {
			for (int i = 0; i < 10; i++) {
				sb.append(" ");
			}
		}

		stringList.add(sb.toString());

		return stringList;

	}

	public void setHoleCard(Card holeCard) {
		this.holeCards.add(holeCard);
	}

	public void setPlayerMoney(int playerMoney) {
		this.playerCash = playerMoney;
	}

	private void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
