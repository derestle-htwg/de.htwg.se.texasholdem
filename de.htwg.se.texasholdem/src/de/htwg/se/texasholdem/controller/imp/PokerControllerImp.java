package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.htwg.se.texasholdem.controller.GameStatus;
import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.model.BettingObject;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.BettingObjectImp;
import de.htwg.se.texasholdem.model.imp.BettingStatus;
import de.htwg.se.texasholdem.model.imp.PlayerImp;
import de.htwg.se.texasholdem.model.imp.StakeType;
import de.htwg.se.texasholdem.util.observer.Observable;

public class PokerControllerImp extends Observable implements PokerController {

	private ModelManager modelManager;
	private List<Player> activePlayers;
	private Player currentPlayer;
	private Player dealer;
	private int credits;
	private BettingStatus bettingStatus;
	private GameStatus gameStatus;
	private List<BettingObjectImp> bettingLog;

	public PokerControllerImp() {
		modelManager = new ModelManagerImp();
		this.activePlayers = new LinkedList<Player>();
		this.bettingLog = new LinkedList<BettingObjectImp>();
		gameStatus = GameStatus.INITIALIZATION;
	}

	public String getTableString() {
		return modelManager.getTableString();
	}

	public void startGame() {
		// setRandomDealer();
		modelManager.resetGame();
		bettingStatus = BettingStatus.values()[0];
		setCreditsToplayer();
		payBlinds();
		gameStatus = GameStatus.RUNNING;
		// TODO: Set Active Player list
		notifyObservers();
	}

	public void payBlinds() {
		Player smallBlind = modelManager.getNextPlayer(dealer);
		Player bigBlind = modelManager.getNextPlayer(smallBlind);

		if (smallBlind.getPlayerMoney() < getSmallBlind()) {
			// Player cannot pay smallblind
		} else {
			payMoney(smallBlind, getSmallBlind());
		}

		if (smallBlind.getPlayerMoney() < getBigBlind()) {
			// Player cannot pay bigblind
		} else {
			payMoney(bigBlind, getBigBlind());
		}

		currentPlayer = modelManager.getNextPlayer(bigBlind);
	}

	public void setStartCredits(int credits) {
		this.credits = credits;
	}

	public int getStartCredits() {
		return this.credits;
	}

	public void addPlayer(String playerName) {
		Player player = new PlayerImp(playerName);
		modelManager.addPlayer(player);
		notifyObservers();
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
		int randomNumber = ThreadLocalRandom.current().nextInt(0, activePlayers.size());
		dealer = activePlayers.get(randomNumber);
	}

	public void setDealer(Player dealer) {
		this.dealer = dealer;
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

	public GameStatus getStatus() {
		return gameStatus;
	}

	public void call(int credits) {
		BettingObject bo = new BettingObjectImp(this.bettingStatus, this.currentPlayer, StakeType.CALL, credits);
		payMoney(this.currentPlayer, credits);

	}

	private void payMoney(Player player, int credits) {
		player.payMoney(credits);
		this.modelManager.setPot(credits);
	}
}
