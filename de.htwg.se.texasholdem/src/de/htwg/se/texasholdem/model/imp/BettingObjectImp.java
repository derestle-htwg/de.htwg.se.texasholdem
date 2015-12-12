package de.htwg.se.texasholdem.model.imp;

import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.BettingStatus;

public class BettingObject implements BettingStatus {
	private BettingStatusImp bettingStatus;
	private Player player;
	private StakeType stakeType;
	private int stake;

	BettingObject(BettingStatusImp bettingStatus, Player player, StakeType stakeType, int stake) {
		this.bettingStatus = bettingStatus;
		this.player = player;
		this.stakeType = stakeType;
		this.stake = stake;
	}

	public BettingStatusImp getBettingStatus() {
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
