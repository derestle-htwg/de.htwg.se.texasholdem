package model.imp;

import model.IPlayer;


public class Player implements IPlayer {
	
	private String playerName;
	private int playerMoney;
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerMoney() {
		return playerMoney;
	}

	public void setPlayerMoney(int playerMoney) {
		this.playerMoney = playerMoney;
	}
	

}
