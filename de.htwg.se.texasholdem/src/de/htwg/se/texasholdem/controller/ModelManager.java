package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;

public interface ModelManager {

	void addPlayer(Player player);

	int getBigBlind();

	List<Card> getHoleCards(Player player);

	List<Player> getPlayerList();

	int getSmallBlind();

	boolean hasMoney(Player player);

	void resetGame();

	void setHoleCards(Player player);

	void setPlayerMoney(Player player, int money);

	void setSmallBlind(int smallBlind);
}
