package de.htwg.se.texasholdem.controller.imp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import de.htwg.se.texasholdem.controller.EvaluationManager;
import de.htwg.se.texasholdem.controller.GameStatus;
import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.model.BettingObject;
import de.htwg.se.texasholdem.model.BettingStatus;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.CardRank;
import de.htwg.se.texasholdem.model.EvaluationObject;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.StakeType;
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
	private Player lastPlayerOfThisRound;
	private int startCredits;
	private boolean endRound;
	private List<String> loggerText;
	private Player smallBlind = null;
	private Player bigBlind = null;

	private Logger logger = Logger.getLogger("de.htwg.se.texasholdem.aview.tui");
	private List<Card> LastWinningCards;
	private Player LastWinningPlayer;
	private boolean gameOver = false;
	private boolean roundFinished = false;
	private ReentrantLock lock;

	public boolean getGameOver() {
		return gameOver;
	}

	public PokerControllerImp(ReentrantLock lock) {

		modelManager = new ModelManagerImp();
		evaluationManager = new EvaluationManagerImp();
		this.activePlayers = new LinkedList<Player>();
		this.bettingLog = new LinkedList<BettingObject>();
		this.loggerText = new LinkedList<String>();
		gameStatus = GameStatus.INITIALIZATION;
		endRound = false;
		this.lock = lock;

		startCredits = 5000;
		setBlinds(25);
	}

	public String getTableString() {
		return modelManager.getTableString();
	}

	public void startGame() {
		// TODO: Doesn't work because of active player list not set:
		// setRandomDealer();
		bettingStatus = BettingStatus.values()[0];
		setCreditsToPlayer();
		fillActivePlayerList();
		setRandomDealer();
		currentPlayer = getDealer();
		resetGame();
		gameStatus = GameStatus.RUNNING;
		notifyObservers();
	}

	private void fillActivePlayerList() {
		activePlayers.clear();
		for (Player p : modelManager.getPlayerList()) {
			if (p.getPlayerMoney() > 0) {
				activePlayers.add(p);
			}
		}
	}

	private void resetGame() {
		int playersWithMoney = 0;
		roundFinished = false;

		for (Player p : modelManager.getPlayerList()) {
			if (p.getPlayerMoney() > 0) {
				playersWithMoney++;
			}
		}

		if (playersWithMoney <= 1) {
			endGame();
		} else {
			modelManager.resetGame();
			bettingLog.clear();
			fillActivePlayerList();
			payBlinds();
			setHoleCardsToAllPlayer();
		}
	}

	private void endGame() {
		Player winner = getChipLeader();
		// Player winner = null;
		// for (Player p : modelManager.getPlayerList()) {
		// if (winner == null || p.getPlayerMoney() > winner.getPlayerMoney()) {
		// winner = p;
		// }
		// }
		logger.info("GAME ENDED - WINNER IS: " + winner.getPlayerName());
		gameOver = true;
		gameStatus = GameStatus.ENDED;
	}

	public void removePlayer(String playerName) {
		for (Player p : modelManager.getPlayerList()) {
			if (p.getPlayerName().equals(playerName)) {
				if (currentPlayer == p || modelManager.getPlayerList().size() <= 2) {
					modelManager.getPlayerList().remove(p);
					nextPlayer();
				} else {
					modelManager.getPlayerList().remove(p);
				}
				notifyObservers();
			}
		}
	}

	public void payBlinds() {
		smallBlind = getNextPlayer(activePlayers, dealer);
		bigBlind = getNextPlayer(activePlayers, smallBlind);

		lastPlayerOfThisRound = bigBlind;

		if (smallBlind.getPlayerMoney() < getSmallBlind()) {
			// TODO: Player cannot pay smallblind
			smallBlind = getNextPlayer(activePlayers, smallBlind);
			bigBlind = getNextPlayer(activePlayers, bigBlind);
			activePlayers.remove(getPreviousPlayer(activePlayers, smallBlind));
		}

		if (activePlayers.size() <= 1) {
			showDown();
		}

		payMoney(smallBlind, getSmallBlind(), StakeType.SMALL_BLIND);

		if (bigBlind.getPlayerMoney() < getBigBlind()) {
			// TODO: Player cannot pay bigblind
			bigBlind = getNextPlayer(activePlayers, bigBlind);
			activePlayers.remove(getPreviousPlayer(activePlayers, bigBlind));
		}
		payMoney(bigBlind, getBigBlind(), StakeType.BIG_BLIND);

		if (activePlayers.size() <= 1) {
			showDown();
		}

		currentPlayer = getNextPlayer(activePlayers, bigBlind);
		notifyObservers();
	}

	public void setStartCredits(int credits) {
		this.startCredits = credits;
	}

	public int getStartCredits() {
		return this.startCredits;
	}

	public void addPlayer(String playerName) {
		Player player = new Player(playerName);
		modelManager.addPlayer(player);
		notifyObservers();
	}

	public Player getNextPlayer(List<Player> playerList, Player player) {
		int index = playerList.indexOf(player);
		return playerList.get((index + 1) % playerList.size());
	}

	public Player getPreviousPlayer(List<Player> playerList, Player player) {
		int index = playerList.indexOf(player);
		return playerList.get((index + playerList.size() - 1) % playerList.size());
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
		setDealer(activePlayers.get(randomNumber));
	}

	public void setDealer(Player dealer) {
		this.dealer = dealer;
	}

	public void setCreditsToPlayer() {
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

	public List<Card> getWinningCards() {
		return LastWinningCards;
	}

	public Player getWinningPlayer() {
		return LastWinningPlayer;
	}

	public int getCurrentCallValue() {
		int highestValue = 0;
		int currentPlayerValue = 0;
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
		for (Map.Entry<Player, Integer> entry : playerBidList.entrySet()) {
			if (entry.getValue().intValue() > highestValue) {
				highestValue = entry.getValue().intValue();
			}
			if (entry.getKey() == currentPlayer) {
				currentPlayerValue = entry.getValue().intValue();
			}
		}

		return highestValue - currentPlayerValue;
	}

	public void enterNextPhase() {
		BettingStatus currentPhase = this.bettingStatus;

		switch (currentPhase) {
		case PRE_FLOP:
			bettingStatus = BettingStatus.FLOP;
			for (int i = 0; i < 3; i++) {
				modelManager.addCommunityCard();
			}
			currentPlayer = getNextPlayer(activePlayers, getDealer());
			lastPlayerOfThisRound = currentPlayer;
			break;
		case FLOP:
			bettingStatus = BettingStatus.TURN;
			modelManager.addCommunityCard();
			currentPlayer = getNextPlayer(activePlayers, getDealer());
			lastPlayerOfThisRound = currentPlayer;
			break;
		case TURN:
			bettingStatus = BettingStatus.RIVER;
			modelManager.addCommunityCard();
			currentPlayer = getNextPlayer(activePlayers, getDealer());
			lastPlayerOfThisRound = currentPlayer;
			break;
		case RIVER:
			bettingStatus = BettingStatus.SHOWDOWN;
			// currentPlayer = getNextPlayer(activePlayers, getDealer());
			// lastPlayerOfThisRound = currentPlayer;
			enterNextPhase();
			break;
		case SHOWDOWN:
			showDown();
			bettingStatus = BettingStatus.PRE_FLOP;
			roundFinished = true;
			notifyObservers();
			if (lock != null)
				lock.unlock();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			if (lock != null)
				lock.lock();

			resetGame();
			setDealer(getNextPlayer(activePlayers, getDealer()));
			// enterNextPhase();

			break;
		default:
			break;
		}

		endRound = false;
		notifyObservers();
	}

	private void showDown() {
		List<EvaluationObject> evalList = evaluationManager.evaluate(activePlayers, modelManager.getCommunityCards());
		Map<Player, BettingStatus> allinList = new HashMap<Player, BettingStatus>();
		Map<Player, BettingStatus> winnerAllinList = new HashMap<Player, BettingStatus>();
		CardRank highestRank = evalList.get(0).getRanking();
		boolean split = evalList.get(0).isSplit();

		// Check if a player is All-In and add them into a list
		for (BettingObject bo : bettingLog) {
			if (bo.getStakeType() == StakeType.ALL_IN) {
				allinList.put(bo.getPlayer(), bo.getBettingStatus());
			}
		}

		// Has only one person won?
		if (split == true) {
			// Several persons won

			// Is winner All-In?
			for (EvaluationObject eo : evalList) {
				if (eo.isSplit() && allinList.containsKey(eo.getPlayer())) {
					winnerAllinList.put(eo.getPlayer(), allinList.get(eo.getPlayer()));
				}
			}
			if (!winnerAllinList.isEmpty()) {

				if (winnerAllinList.size() == 1) {

					// Calculated Pot for Winner and Split Pot for other Players
					int winnerPot = 0;
					boolean allinFound = false;
					Player firstPlayerInBettingRound = null;
					Map<Player, BettingStatus> map = new HashMap<Player, BettingStatus>();
					Map.Entry<Player, BettingStatus> entry = map.entrySet().iterator().next();
					Player winner = entry.getKey();

					// First: Add stake of all previous BettingStatus to
					// winnerPot
					// Second: If bo.bettingStatus is BettingStatus in which
					// Player went ALl-In, save first player that started the
					// betting round
					// Third: If bo.getPlayer() is winner, and winner went
					// All-In, set 'allinFound = true' and continue adding the
					// stakes (only the amount of winner-all-in-value * players)
					// to the winnerPot. If winner was found the second time, do
					// not add the stake to the pot and break for-loop
					for (BettingObject bo : bettingLog) {
						if (winnerAllinList.get(0).ordinal() > bo.getBettingStatus().ordinal()) {
							winnerPot += bo.getStake();
						} else if (winnerAllinList.get(0) == bo.getBettingStatus()) {
							if (firstPlayerInBettingRound == null) {
								firstPlayerInBettingRound = bo.getPlayer();
							}
							if (allinFound == true && bo.getPlayer() == winner) {
								break;
							}

							if (bo.getPlayer() == winner && bo.getStakeType() == StakeType.ALL_IN) {
								allinFound = true;
							}

							winnerPot += bo.getStake();
						}
					}
					winner.addPlayerMoney(winnerPot);
				}

			}
			// Mehrere Gewinner, Pot gerecht aufteilen

			int splitCounter = 0;
			for (EvaluationObject eo : evalList) {
				if (eo.getRanking() == highestRank && eo.isSplit() == true) {
					splitCounter++;
				}
			}

			for (EvaluationObject eo : evalList) {
				if (eo.getRanking() == highestRank && eo.isSplit() == true) {
					eo.getPlayer().addPlayerMoney(modelManager.getPot() / splitCounter);
				}
			}
		} else {
			// Only one Person won
			String event = "[" + bettingStatus.toString() + "][" + evalList.get(0).getPlayer().getPlayerName()
					+ "] WON " + modelManager.getPot() + " Cr with cards: ";
			if (!evalList.get(0).getCards().isEmpty()) {
				for (Card c : evalList.get(0).getCards()) {
					event = event + c.toString() + "  ";
				}
			}
			event = event + " [" + highestRank.toString() + "]";
			loggerText.add(event);
			evalList.get(0).getPlayer().addPlayerMoney(modelManager.getPot());
		}

		LastWinningCards = evalList.get(0).getCards();
		LastWinningPlayer = evalList.get(0).getPlayer();
	}

	/*
	 * Sets next Player
	 *
	 * 1) Checks if there are more than one player => if there is only one
	 * player, this player has won 2) Checks if to enter next phase
	 */
	private void nextPlayer() {
		if (activePlayers.size() == 1) {
			this.bettingStatus = BettingStatus.SHOWDOWN;
			enterNextPhase();
		} else if (getPlayerList().size() <= 1) {
			endGame();
		} else {
			// Check if someone is all-in
			// Check if there are any other player which are not all-in
			List<Player> allInList = new LinkedList<Player>();
			for (Player player : activePlayers) {
				if (player.isAllIn()) {
					allInList.add(player);
				}
			}

			if (this.bettingStatus == BettingStatus.PRE_FLOP) {
				if (endRound == true) {
					enterNextPhase();
				} else {
					currentPlayer = getNextPlayer(activePlayers, currentPlayer);

					if (lastPlayerOfThisRound == currentPlayer) {
						endRound = true;
					}
				}
			} else {
				currentPlayer = getNextPlayer(activePlayers, currentPlayer);
				if (lastPlayerOfThisRound == currentPlayer) {
					enterNextPhase();
				}
				if ((currentPlayer.isAllIn() && !(activePlayers.size() - allInList.size() >= 2))
						|| (!currentPlayer.isAllIn() && !(activePlayers.size() - allInList.size() >= 2)
								&& (currentPlayer != lastPlayerOfThisRound))) {
					while (this.bettingStatus != BettingStatus.RIVER) {
						enterNextPhase();
					}
					enterNextPhase();
				}
			}
		}
	}

	public void check() {
		nextPlayer();
		notifyObservers();
	}

	public void call() {
		if (getCurrentCallValue() >= this.currentPlayer.getPlayerMoney()) {
			this.currentPlayer.setAllIn(true);
			recordEvent(this.currentPlayer, StakeType.ALL_IN, this.currentPlayer.getPlayerMoney());
			payMoney(this.currentPlayer, this.currentPlayer.getPlayerMoney(), StakeType.ALL_IN);
		} else {
			recordEvent(this.currentPlayer, StakeType.CALL, getCurrentCallValue());
			payMoney(this.currentPlayer, getCurrentCallValue(), StakeType.CALL);
		}
		nextPlayer();
		notifyObservers();
	}

	public String getLastEvent() {
		if (loggerText.isEmpty()) {
			return "";
		} else {
			return loggerText.get(loggerText.size() - 1);
		}
	}

	private void recordEvent(Player player, StakeType stakeType, int credits) {
		String newLine = System.getProperty("line.separator");
		String event = "[" + bettingStatus.toString() + "][" + player.getPlayerName() + "] ";

		switch (stakeType) {
		case CALL:
			if (credits > 0) {
				event = event + "Call " + credits + " Cr";
			} else {
				event = event + "Check";
			}
			break;
		case RAISE:
			event = event + "Raise " + credits + " Cr";
			break;
		case ALL_IN:
			event = event + "ALL-IN " + credits + " Cr";
			break;
		case BIG_BLIND:
			event = event + "Big Blind " + credits + " Cr";
			break;
		case SMALL_BLIND:
			event = event + "Small Blind " + credits + " Cr";
			break;
		default:
			break;
		}
		event = event + newLine;
		loggerText.add(event);
	}

	public void raise(int credits) {
		credits = credits + getCurrentCallValue();
		if (credits >= this.currentPlayer.getPlayerMoney()) {
			credits = this.currentPlayer.getPlayerMoney();
			this.currentPlayer.setAllIn(true);
			recordEvent(this.currentPlayer, StakeType.ALL_IN, credits);
			payMoney(this.currentPlayer, credits, StakeType.ALL_IN);
		} else {
			recordEvent(this.currentPlayer, StakeType.RAISE, credits);
			payMoney(this.currentPlayer, credits, StakeType.RAISE);
		}
		lastPlayerOfThisRound = currentPlayer;
		endRound = false;
		nextPlayer();
		notifyObservers();
	}

	public void fold() {
		loggerText.add("[" + bettingStatus.toString() + "][" + currentPlayer.getPlayerName() + "] FOLD");
		Player tempNextPlayer = getPreviousPlayer(activePlayers, currentPlayer);
		activePlayers.remove(currentPlayer);
		currentPlayer.clearHoleCards();
		currentPlayer = tempNextPlayer;
		nextPlayer();
		notifyObservers();
	}

	private void payMoney(Player player, int credits, StakeType stakeType) {
		player.payMoney(credits);
		this.modelManager.setPot(credits);

		this.bettingLog.add(new BettingObject(this.bettingStatus, player, stakeType, credits));
	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	private void setHoleCardsToAllPlayer() {
		for (Player p : activePlayers) {
			modelManager.setHoleCards(p);
		}
	}

	public BettingStatus getBettingStatus() {
		return this.bettingStatus;
	}

	public ModelManager getGameData() {
		return this.modelManager;
	}

	public boolean getRoundFinished() {
		return this.roundFinished;
	}

	public Player getSmallBlindPlayer() {
		return this.smallBlind;
	}

	public Player getBigBlindPlayer() {
		return this.bigBlind;
	}

	public Player getChipLeader() {
		Player chipLeader = null;
		for (Player p : this.getPlayerList()) {
			if (chipLeader == null || p.getPlayerMoney() > chipLeader.getPlayerMoney()) {
				chipLeader = p;
			}
		}
		return chipLeader;
	}

	public boolean roundFinished() {
		return this.roundFinished;
	}
}
