package de.htwg.se.texasholdem.controller;

import java.util.LinkedList;

import de.htwg.se.texasholdem.model.Player;

public interface PlayerManager {

	void addPlayer(Player player);

	LinkedList<Player> getPlayerList();

}
