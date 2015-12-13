package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.util.observer.IObservable;

public interface PokerController extends IObservable {

	String getTableString();

	void addPlayer(String playerName);

	void clearActivePlayers();

	List<Player> getActivePlayers();

	List<Player> getPlayerList();

	Player getDealer();

	void setPlayerActive(Player player);

	void setPlayerNotActive(Player player);

	void setRandomDealer();

	void startGame();

	void setStartCredits(int credits);

	int getStartCredits();

	void setCreditsToPlayer();

	void setBlinds(int smallBlind);

	int getSmallBlind();

	int getBigBlind();

	void payBlinds();

	void setDealer(Player dealer);

	GameStatus getStatus();

	int getCurrentCallValue();

	Player getCurrentPlayer();

	void fold();

	void call();

	void raise(int credits);

	String getBettingStatus();

	String getLastEvent();

}
