package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;
import java.util.List;

import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.model.Player;

public class PlayerManagerImp implements PlayerManager {

	// Muss vielleicht großgeschrieben werden
	private final LinkedList<Player> playerList;

	public PlayerManagerImp(List<Player> list) {
		this.playerList = (LinkedList<Player>) list;
	}

	public void addPlayer(Player player) {
		playerList.add(player);
	}

	public LinkedList<Player> getPlayerList() {
		return playerList;
	}

}
