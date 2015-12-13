package de.htwg.se.texasholdem.controller.imp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import de.htwg.se.texasholdem.controller.EvaluationManager;
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
	private EvaluationManager evaluationManager;
	private List<Player> activePlayers;
	private Player currentPlayer;
	private Player dealer;
	private BettingStatus bettingStatus;
	private GameStatus gameStatus;
	private List<BettingObject> bettingLog;
	private int startCredits;

	public PokerControllerImp() {

		modelManager = new ModelManagerImp();
		evaluationManager = new EvaluationManagerImp();
		this.activePlayers = new LinkedList<Player>();
		this.bettingLog = new LinkedList<BettingObject>();
		gameStatus = GameStatus.INITIALIZATION;

		startCredits = 5000;
		setBlinds(25);
	}

	public String getTableString() {
		return modelManager.getTableString();
	}

	public void startGame() {
		// TODO: Doesn't work because of active player list not set:
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
			// TODO: Player cannot pay smallblind
		} else {
			payMoney(smallBlind, getSmallBlind(), StakeType.SMALL_BLIND);
		}

		if (smallBlind.getPlayerMoney() < getBigBlind()) {
			// TODO: Player cannot pay bigblind
		} else {
			payMoney(bigBlind, getBigBlind(), StakeType.BIG_BLIND);
		}

		currentPlayer = modelManager.getNextPlayer(bigBlind);
	}

	public void setStartCredits(int credits) {
		this.startCredits = credits;
	}

	public int getStartCredits() {
		return this.startCredits;
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
			p.setPlayerMoney(startCredits);
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

	public int getCurrentCallValue() {
		int callValue = 0;
		Map<Player, Integer> playerBidList = new HashMap<Player, Integer>();

		// Build list of players and previously made bids
		for (BettingObject bo : bettingLog) {
			if (bo.getBettingStatus() == this.bettingStatus) {
				if (!playerBidList.containsKey(bo.getPlayer())) {
					playerBidList.put(bo.getPlayer(), 0);
				}

				playerBidList.replace(bo.getPlayer(), playerBidList.get(bo.getPlayer()) + bo.getStake());
			}
		}

		// Get current player and get currentCallValue from playerBidList

		return startCredits;
	}

	public void enterNextPhase() {
		BettingStatus currentPhase = this.bettingStatus;

		switch (currentPhase) {
		case PRE_FLOP:
			bettingStatus = BettingStatus.FLOP;
			for (int i = 0; i < 3; i++) {
				modelManager.addCommunityCard();
			}
			break;
		case FLOP:
			bettingStatus = BettingStatus.TURN;
			modelManager.addCommunityCard();
			break;
		case TURN:
			bettingStatus = BettingStatus.RIVER;
			modelManager.addCommunityCard();
			break;
		case RIVER:
			bettingStatus = BettingStatus.SHOWDOWN;
			break;
		case SHOWDOWN:
			bettingStatus = BettingStatus.PRE_FLOP;
			modelManager.resetGame();
			bettingLog.clear();
			break;
		default:
			break;
		}

		notifyObservers();
	}

	public void call(int credits) {
		payMoney(this.currentPlayer, credits, StakeType.CALL);

	}

	public void raise(int credits) {
		payMoney(this.currentPlayer, credits, StakeType.RAISE);

	}

	private void payMoney(Player player, int credits, StakeType stakeType) {
		player.payMoney(credits);
		this.modelManager.setPot(credits);

		this.bettingLog.add(new BettingObjectImp(this.bettingStatus, player, stakeType, credits));
	}
}
