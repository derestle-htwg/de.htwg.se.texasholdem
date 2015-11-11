package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.model.Player;

public class GameManagerImp implements de.htwg.se.texasholdem.controller.GameManager {

	private Player startPlayer;

	private ModelManager modelManager;

	private List<Player> activePlayers;

	public GameManagerImp(ModelManager modelManager) {
		this.modelManager = modelManager;
		this.activePlayers = new LinkedList<Player>();
	}

	public void addPlayer(Player player) {
		modelManager.addPlayer(player);
	}

	public void clearActivePlayers() {
		while (!activePlayers.isEmpty()) {
			activePlayers.remove(0);
		}
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
