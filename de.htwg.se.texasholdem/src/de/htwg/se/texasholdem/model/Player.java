package de.htwg.se.texasholdem.model;

import java.util.List;

public interface Player {

	public List<Card> getHoleCards();

	public int getPlayerMoney();

	public String getPlayerName();

	public void setHoleCard(Card holeCard);

	public void setPlayerMoney(int playerMoney);
}
