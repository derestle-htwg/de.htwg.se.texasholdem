package de.htwg.se.texasholdem.model;

public class BettingObject {
	private BettingStatus bettingStatus;
	private Player player;
	private StakeType stakeType;
	private int stake;

	public BettingObject(BettingStatus bettingStatus, Player player, StakeType stakeType, int stake) {
		this.bettingStatus = bettingStatus;
		this.player = player;
		this.stakeType = stakeType;
		this.stake = stake;
	}

	public BettingStatus getBettingStatus() {
		return bettingStatus;
	}

	public Player getPlayer() {
		return player;
	}

	public StakeType getStakeType() {
		return stakeType;
	}

	public int getStake() {
		return stake;
	}

}
