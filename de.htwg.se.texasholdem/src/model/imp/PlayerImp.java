package model.imp;

import model.Player;

public class PlayerImp implements Player {

	private String playerName;
	private int playerMoney;

	public PlayerImp() {

	}

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
