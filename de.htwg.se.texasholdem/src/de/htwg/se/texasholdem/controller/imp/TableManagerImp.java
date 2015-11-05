package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;

import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.controller.TableManager;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Table;
import de.htwg.se.texasholdem.model.imp.TableImp;

public class TableManagerImp implements TableManager {

	private final Table table;

	private final PlayerManager playerManager;

	public TableManagerImp() {
		table = new TableImp();
		playerManager = new PlayerManagerImp(table.getPlayerList());
	}

	public void addPlayer(Player player) {
		playerManager.addPlayer(player);
	}

	public int getBigBlind() {
		return table.getBigBlind();
	}

	public LinkedList<Player> getPlayerList() {
		return playerManager.getPlayerList();
	}

	public int getSmallBlind() {
		return table.getSmallBlind();
	}

	public void setSmallBlind(int smallBlind) {
		table.setSmallBlind(smallBlind);

	}

}
