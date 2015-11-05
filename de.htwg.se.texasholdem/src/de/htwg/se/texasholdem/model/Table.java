package de.htwg.se.texasholdem.model;

import java.util.List;

public interface Table {

	public void addPlayer(Player player);

	public int getBigBlind();

	public List<Player> getPlayerList();

	public int getPot();

	public int getSmallBlind();

	public void setPot(int value);

	public void setSmallBlind(int smallBlind);
}
