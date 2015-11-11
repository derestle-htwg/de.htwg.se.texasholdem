package de.htwg.se.texasholdem.controller;

import java.util.LinkedList;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;

public interface ModelManager {

	void addPlayer(Player player);

	int getBigBlind();

	LinkedList<Card> getHoleCards(Player player);

	LinkedList<Player> getPlayerList();

	int getSmallBlind();

	boolean hasMoney(Player player);

	void resetGame();

	void setHoleCards(Player player);

	void setPlayerMoney(Player player, int money);

	void setSmallBlind(int smallBlind);
}
