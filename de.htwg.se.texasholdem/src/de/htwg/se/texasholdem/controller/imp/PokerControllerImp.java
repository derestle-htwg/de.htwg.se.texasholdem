package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.BettingStatus;
import de.htwg.se.texasholdem.util.observer.Observable;

public class PokerControllerImp extends Observable implements PokerController {

	private ModelManager modelManager;
	private List<Player> activePlayers;
	private Player currentPlayer;
	private Player dealer;
	private int credits;
	BettingStatus bettingStatus;

	public PokerControllerImp() {
		modelManager = new ModelManagerImp();
		this.activePlayers = new LinkedList<Player>();
	}

	public String getTableString() {
		return modelManager.getTableString();
	}

	public void startGame() {
		setRandomDealer();
		currentPlayer = dealer;

		// Player smallBlind = modelManager.get

		bettingStatus = BettingStatus.values()[0];
	}

	public void setStartCredits(int credits) {
		this.credits = credits;
	}

	public int getStartCredits() {
		return this.credits;
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

	public Player getDealer() {
		return dealer;
	}

	public void setPlayerActive(Player player) {
		activePlayers.add(player);
	}

	public void setPlayerNotActive(Player player) {
		activePlayers.remove(player);
	}

	public void setRandomDealer() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, modelManager.getPlayerList().size());
		dealer = modelManager.getPlayerList().get(randomNumber);
	}

	public void setCreditsToplayer() {
		for (Player p : this.getPlayerList()) {
			p.setPlayerMoney(credits);
		}
	}

	public void setBlinds(int blindValue) {
		modelManager.setSmallBlind(blindValue);
	}

	public int getSmallBlind() {
		return modelManager.getSmallBlind();
	}

	public int getBigBlind() {
		return modelManager.getBigBlind();
	}
}
