package model.imp;

import model.Player;

public class PlayerImp implements Player {

	private String playerName;
	private int playerMoney;

	public PlayerImp(String name) {
		setPlayerName(name);
	}

	public int getPlayerMoney() {
		return playerMoney;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerMoney(int playerMoney) {
		this.playerMoney = playerMoney;
	}

	private void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
