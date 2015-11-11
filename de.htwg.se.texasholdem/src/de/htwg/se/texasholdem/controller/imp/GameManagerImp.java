package de.htwg.se.texasholdem.controller.imp;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.model.Player;

public class GameManagerImp implements de.htwg.se.texasholdem.controller.GameManager {

	private Player startPlayer;

	private ModelManager modelManager;

	public GameManagerImp(ModelManager modelManager) {
		this.modelManager = modelManager;
	}

	public void addPlayer(Player player) {
		modelManager.addPlayer(player);

	}

	public List<Player> getPlayerList() {
		return modelManager.getPlayerList();
	}

	public Player getStartPlayer() {
		return startPlayer;
	}

	public void setStartPlayer() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, modelManager.getPlayerList().size());
		startPlayer = modelManager.getPlayerList().get(randomNumber);
	}
}
