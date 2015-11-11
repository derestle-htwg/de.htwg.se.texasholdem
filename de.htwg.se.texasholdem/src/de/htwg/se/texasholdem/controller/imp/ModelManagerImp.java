package de.htwg.se.texasholdem.controller.imp;

import java.util.List;

import de.htwg.se.texasholdem.controller.DeckManager;
import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Table;
import de.htwg.se.texasholdem.model.imp.TableImp;

public class ModelManagerImp implements ModelManager {

	private final Table table;

	private final PlayerManager playerManager;

	private final DeckManager deckManager;

	public ModelManagerImp() {
		table = new TableImp();
		deckManager = new DeckManagerImp();
		playerManager = new PlayerManagerImp(table.getPlayerList());
	}

	public void addPlayer(Player player) {
		playerManager.addPlayer(player);
	}

	public int getBigBlind() {
		return table.getBigBlind();
	}

	public List<Card> getHoleCards(Player player) {
		return playerManager.getHoleCards(player);
	}

	public List<Player> getPlayerList() {
		return playerManager.getPlayerList();
	}

	public int getSmallBlind() {
		return table.getSmallBlind();
	}

	public boolean hasMoney(Player player) {
		return playerManager.getPlayerMoney(player) > 0;
	}

	public void resetGame() {
		deckManager.createShuffledDeck();
	}

	public void setHoleCards(Player player) {
		for (int i = 0; i < 2; i++) {
			playerManager.setHoleCard(player, deckManager.getDeck().getCard());
		}
	}

	public void setPlayerMoney(Player player, int money) {
		playerManager.setPlayerMoney(player, money);
	}

	public void setSmallBlind(int smallBlind) {
		table.setSmallBlind(smallBlind);
	}

}
