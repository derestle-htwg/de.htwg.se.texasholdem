package de.htwg.se.texasholdem.model.imp;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.controller.imp.PlayerManagerImp;
import de.htwg.se.texasholdem.model.Player;

public class PlayerManagerImpTest {

	PlayerManager playerManager;

	@Before
	public void _setup() {
		LinkedList<Player> playerList = new LinkedList<Player>();
		playerManager = new PlayerManagerImp(playerList);
	}

	@Test
	public void getPlayerList_inputTwoPlayers_returnsListWithTwoPlayers() {
		playerManager.addPlayer(new PlayerImp("Peter"));
		playerManager.addPlayer(new PlayerImp("Hans"));

		Assert.assertEquals(2, playerManager.getPlayerList().size());
	}
}
