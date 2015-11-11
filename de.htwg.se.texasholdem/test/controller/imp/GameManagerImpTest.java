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

	private Player p1, p2, p3;

	@Before
	public void _setup() {
		ModelManager modelManager = new ModelManagerImp();
		gameManager = new GameManagerImp(modelManager);

		p1 = new PlayerImp("Player One");
		p2 = new PlayerImp("Player Two");
		p3 = new PlayerImp("Player Three");

		gameManager.addPlayer(p1);
		gameManager.addPlayer(p2);
		gameManager.addPlayer(p3);

		gameManager.setPlayerActive(p1);
		gameManager.setPlayerActive(p2);
		gameManager.setPlayerActive(p3);
	}

	@Test
	public void clearActivePlayers_inputThreeActivePlayers_clearsActivePlayerList() {
		Assert.assertTrue(gameManager.getActivePlayers().size() != 0);
		gameManager.clearActivePlayers();
		Assert.assertEquals(0, gameManager.getActivePlayers().size());
	}

	@Test
	public void getActivePlayers_inputListWith3ActivePlayer_returnsThreeActivePlayer() {
		Assert.assertEquals(3, gameManager.getActivePlayers().size());
	}

	@Test
	public void getStartPlayer_inputNone_returnsStartPlayer() {
		gameManager.setStartPlayer();

		Assert.assertEquals(PlayerImp.class, gameManager.getStartPlayer().getClass());
		Assert.assertTrue(gameManager.getPlayerList().contains(gameManager.getStartPlayer()));
	}

	@Test
	public void setPlayerNotActive_input3ActivePlayersAndSetOneNotActive_returnsListWithTwoActivePlayers() {
		gameManager.setPlayerNotActive(p2);

		Assert.assertEquals(2, gameManager.getActivePlayers().size());
	}

}
