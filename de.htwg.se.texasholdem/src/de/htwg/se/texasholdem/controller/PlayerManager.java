package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;

public interface PlayerManager {

	void addPlayer(Player player);

	List<Card> getHoleCards(Player player);

	List<Player> getPlayerList();

	int getPlayerMoney(Player player);

	void setHoleCard(Player player, Card holeCard);

	void setPlayerMoney(Player player, int money);

}
