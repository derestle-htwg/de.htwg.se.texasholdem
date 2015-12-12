package de.htwg.se.texasholdem.model;

import de.htwg.se.texasholdem.model.imp.BettingStatusImp;
import de.htwg.se.texasholdem.model.imp.StakeType;

public interface BettingStatus {

	BettingStatusImp getBettingStatus();

	Player getPlayer();

	StakeType getStakeType();

	int getStake();

}