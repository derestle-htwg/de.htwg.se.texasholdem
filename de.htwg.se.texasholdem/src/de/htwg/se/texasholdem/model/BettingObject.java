package de.htwg.se.texasholdem.model;

import de.htwg.se.texasholdem.model.imp.BettingStatus;
import de.htwg.se.texasholdem.model.imp.StakeType;

public interface BettingObject {

	BettingStatus getBettingStatus();

	Player getPlayer();

	StakeType getStakeType();

	int getStake();

}