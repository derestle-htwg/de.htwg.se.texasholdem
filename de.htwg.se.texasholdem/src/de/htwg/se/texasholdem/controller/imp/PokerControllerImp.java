package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.util.observer.Observable;

public class PokerControllerImp extends Observable implements PokerController {

	private Player startPlayer;
	private ModelManager modelManager;
	private List<Player> activePlayers;
	private Player currentPlayer;

	public PokerControllerImp() {
		modelManager = new ModelManagerImp();
		this.activePlayers = new LinkedList<Player>();
	}

	public String getTableString() {
		return modelManager.getTableString();
	}

	public void initializeGame() {

	}

	public void addPlayer(Player player) {
		modelManager.addPlayer(player);
	}

	public void clearActivePlayers() {
		activePlayers.clear();
	}

	public List<Player> getActivePlayers() {
		return activePlayers;
	}

	public List<Player> getPlayerList() {
		return modelManager.getPlayerList();
	}

	public Player getStartPlayer() {
		return startPlayer;
	}

	public void setPlayerActive(Player player) {
		activePlayers.add(player);
	}

	public void setPlayerNotActive(Player player) {
		activePlayers.remove(player);
	}

	public void setStartPlayer() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, modelManager.getPlayerList().size());
		startPlayer = modelManager.getPlayerList().get(randomNumber);
	}
}
