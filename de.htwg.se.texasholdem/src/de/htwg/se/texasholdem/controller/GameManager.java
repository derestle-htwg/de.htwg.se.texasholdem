package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Player;

public interface GameManager {

	void addPlayer(Player player);

	List<Player> getPlayerList();

	Player getStartPlayer();

	void setStartPlayer();
}
