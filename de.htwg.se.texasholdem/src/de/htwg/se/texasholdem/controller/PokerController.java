package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.util.observer.IObservable;

public interface PokerController extends IObservable {

	String getTableString();

	void addPlayer(Player player);

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

	void setCreditsToplayer();

	void setBlinds(int i);

	int getSmallBlind();

	int getBigBlind();
}
