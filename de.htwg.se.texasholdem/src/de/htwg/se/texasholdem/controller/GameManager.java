package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Player;

public interface GameManager {

	void addPlayer(Player player);

	void clearActivePlayers();

	List<Player> getActivePlayers();

	List<Player> getPlayerList();

	Player getStartPlayer();

	void setPlayerActive(Player player);

	void setPlayerNotActive(Player player);

	void setStartPlayer();
}
