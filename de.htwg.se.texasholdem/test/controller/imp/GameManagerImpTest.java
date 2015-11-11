package controller.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.GameManager;
import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.controller.imp.GameManagerImp;
import de.htwg.se.texasholdem.controller.imp.ModelManagerImp;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.PlayerImp;

public class GameManagerImpTest {

	private GameManager gameManager;

	@Before
	public void _setup() {
		ModelManager modelManager = new ModelManagerImp();
		gameManager = new GameManagerImp(modelManager);

		Player p1 = new PlayerImp("Player One");
		Player p2 = new PlayerImp("Player Two");
		Player p3 = new PlayerImp("Player Three");

		gameManager.addPlayer(p1);
		gameManager.addPlayer(p2);
		gameManager.addPlayer(p3);
	}

	@Test
	public void getStartPlayer_inputNone_returnsStartPlayer() {
		gameManager.setStartPlayer();

		Assert.assertEquals(PlayerImp.class, gameManager.getStartPlayer().getClass());
		Assert.assertTrue(gameManager.getPlayerList().contains(gameManager.getStartPlayer()));
	}

}
