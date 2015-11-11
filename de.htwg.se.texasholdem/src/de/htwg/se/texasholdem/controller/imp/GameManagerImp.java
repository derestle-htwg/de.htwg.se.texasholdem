package de.htwg.se.texasholdem.controller.imp;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.model.Player;

public class GameManagerImp implements de.htwg.se.texasholdem.controller.GameManager {

	private Player startPlayer;

	private PlayerManager playerManager;
	private ModelManager modelManager;

	public GameManagerImp(ModelManager modelManager) {
		this.modelManager = modelManager;
		playerManager = new PlayerManagerImp(modelManager.getPlayerList());
	}

	public void addPlayer(Player player) {
		playerManager.addPlayer(player);

	}

	public List<Player> getPlayerList() {
		return playerManager.getPlayerList();
	}

	public Player getStartPlayer() {
		return startPlayer;
	}

	public void setStartPlayer() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, playerManager.getPlayerList().size());
		startPlayer = playerManager.getPlayerList().get(randomNumber);
	}
}
