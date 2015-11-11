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
	private List<Card> holeCards;

	public TableImp() {
		players = new LinkedList<Player>();
		holeCards = new LinkedList<Card>();
	}

	public void addHoleCard(Card card) {
		holeCards.add(card);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public int getBigBlind() {
		return smallBlind * 2;
	}

	public List<Card> getHoleCards() {
		return holeCards;
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

}
