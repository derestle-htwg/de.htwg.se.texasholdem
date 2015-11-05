package de.htwg.se.texasholdem.controller;

import java.util.LinkedList;

import de.htwg.se.texasholdem.model.Player;

public interface TableManager {

	void addPlayer(Player player);

	int getBigBlind();

	LinkedList<Player> getPlayerList();

	int getSmallBlind();

	void setSmallBlind(int smallBlind);
}
