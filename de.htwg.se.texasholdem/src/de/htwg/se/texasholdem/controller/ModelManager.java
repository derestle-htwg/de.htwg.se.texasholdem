package de.htwg.se.texasholdem.controller;

import java.util.List;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Deck;
import de.htwg.se.texasholdem.model.Player;

public interface ModelManager {

	void addCommunityCard();

	void addPlayer(Player player);

	int getBigBlind();

	List<Card> getCommunityCards();

	Deck getDeck();

	List<Card> getHoleCards(Player player);

	List<Player> getPlayerList();

	int getPot();

	int getSmallBlind();

	String getTableString();

	boolean hasMoney(Player player);

	void resetGame();

	void setHoleCards(Player player);

	void setPlayerMoney(Player player, int money);

	void setPot(int potValue);

	void setSmallBlind(int smallBlind);

	void setDealer(Player player);

	Player getDealer();
}
