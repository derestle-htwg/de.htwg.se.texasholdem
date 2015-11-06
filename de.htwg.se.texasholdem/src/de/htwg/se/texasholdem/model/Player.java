package de.htwg.se.texasholdem.model;

import java.util.LinkedList;

public interface Player {

	public LinkedList<Card> getHoleCards();

	public int getPlayerMoney();

	public String getPlayerName();

	public void setHoleCard(Card holeCard);

	public void setPlayerMoney(int playerMoney);
}
