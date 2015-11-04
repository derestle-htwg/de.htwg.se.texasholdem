package de.htwg.se.texasholdem.controller;

import java.util.LinkedList;

import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.PlayerImp;

public interface PlayerManager {

	void addPlayer(PlayerImp player);

	LinkedList<Player> getPlayerList();

}
