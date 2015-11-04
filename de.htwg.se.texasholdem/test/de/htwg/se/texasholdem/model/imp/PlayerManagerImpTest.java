package de.htwg.se.texasholdem.model.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.controller.imp.PlayerManagerImp;

public class PlayerManagerImpTest {

	PlayerManager playerManager;

	@Before
	public void _setup() {
		playerManager = new PlayerManagerImp();
	}

	@Test
	public void getPlayerList_inputTwoPlayers_returnsListWithTwoPlayers() {
		playerManager.addPlayer(new PlayerImp("Peter"));
		playerManager.addPlayer(new PlayerImp("Hans"));

		Assert.assertEquals(2, playerManager.getPlayerList().size());
	}
}
