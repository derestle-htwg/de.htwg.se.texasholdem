package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;

import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.model.Player;

public class PlayerManagerImp implements PlayerManager {

	private LinkedList<Player> playerList;

	public PlayerManagerImp() {
		playerList = new LinkedList<Player>();
	}

	public void addPlayer(Player player) {
		playerList.add(player);
	}

	public LinkedList<Player> getPlayerList() {
		return playerList;
	}

}
