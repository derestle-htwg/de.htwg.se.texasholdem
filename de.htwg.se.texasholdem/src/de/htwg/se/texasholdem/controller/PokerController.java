package de.htwg.se.texasholdem.controller;

import java.util.List;

import com.google.inject.ImplementedBy;

import de.htwg.se.texasholdem.controller.imp.PokerControllerImp;
import de.htwg.se.texasholdem.model.BettingStatus;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Table;
import de.htwg.se.texasholdem.util.observer.IObservable;

@ImplementedBy(PokerControllerImp.class)
public interface PokerController extends IObservable {

	ModelManager getGameData();

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

	BettingStatus getBettingStatus();

	String getLastEvent();
	
	Player getWinningPlayer();
	
	List<Card> getWinningCards();

}
