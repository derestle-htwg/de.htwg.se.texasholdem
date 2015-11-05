package controller.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.TableManager;
import de.htwg.se.texasholdem.controller.imp.TableManagerImp;
import de.htwg.se.texasholdem.model.imp.PlayerImp;

public class TableManagerImpTest {

	TableManager tableManager;

	@Before
	public void _setup() {
		tableManager = new TableManagerImp();
	}

	@Test
	public void getPlayerList_addTwoPlayers_returnsListWithTwoPlayers() {
		tableManager.addPlayer(new PlayerImp("Hans"));
		tableManager.addPlayer(new PlayerImp("Peter"));

		Assert.assertEquals(2, tableManager.getPlayerList().size());
	}
}