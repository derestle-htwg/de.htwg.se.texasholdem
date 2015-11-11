package de.htwg.se.texasholdem.controller.imp;

import java.util.List;

import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;

public class PlayerManagerImp implements PlayerManager {

	// Muss vielleicht großgeschrieben werden
	private final List<Player> playerList;

	public PlayerManagerImp(List<Player> list) {
		this.playerList = list;
	}

	public void addPlayer(Player player) {
		playerList.add(player);
	}

	public List<Card> getHoleCards(Player player) {
		return player.getHoleCards();
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public int getPlayerMoney(Player player) {
		return player.getPlayerMoney();
	}

	public void setHoleCard(Player player, Card holeCard) {
		player.setHoleCard(holeCard);
	}

	public void setPlayerMoney(Player player, int money) {
		player.setPlayerMoney(money);
	}

}
