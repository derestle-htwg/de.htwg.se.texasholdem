package de.htwg.se.texasholdem.model;

import java.util.List;

public interface Table {

	void addCommunityCard(Card card);

	void addPlayer(Player player);

	void clearCommunityCards();

	int getBigBlind();

	List<Card> getCommunityCards();

	List<Player> getPlayerList();

	int getPot();

	int getSmallBlind();

	void setPot(int value);

	void setSmallBlind(int smallBlind);
}
