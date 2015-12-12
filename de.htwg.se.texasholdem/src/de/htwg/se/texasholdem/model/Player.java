package de.htwg.se.texasholdem.model;

import java.util.List;

public interface Player {

	public void clearHoleCards();

	public List<Card> getHoleCards();

	public int getPlayerMoney();

	public String getPlayerName();

	public List<String> getPlayerStats();

	public void setHoleCard(Card holeCard);

	public void setPlayerMoney(int playerMoney);

	public void payMoney(int payment);
}
