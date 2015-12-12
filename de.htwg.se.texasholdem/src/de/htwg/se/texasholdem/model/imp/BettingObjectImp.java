package de.htwg.se.texasholdem.model.imp;

import de.htwg.se.texasholdem.model.BettingObject;
import de.htwg.se.texasholdem.model.Player;

public class BettingObjectImp implements BettingObject {
	private BettingStatus bettingStatus;
	private Player player;
	private StakeType stakeType;
	private int stake;

	public BettingObjectImp(BettingStatus bettingStatus, Player player, StakeType stakeType, int stake) {
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
