package de.htwg.se.texasholdem.model;

import java.util.List;

public interface Table {

	public void addPlayer(Player player);

	public List<Player> getPlayerList();

	public int getPotValue();

	public void setPotValue(int value);
}
