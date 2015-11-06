package controller.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.TableManager;
import de.htwg.se.texasholdem.controller.imp.TableManagerImp;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.CardImp;
import de.htwg.se.texasholdem.model.imp.PlayerImp;

public class TableManagerImpTest {

	TableManager tableManager;

	@Before
	public void _setup() {
		tableManager = new TableManagerImp();
		tableManager.resetGame();
	}

	@Test
	public void getBigBlind_inputSmallBlindThreeThousand_returnsBigBlindSixThousand() {
		tableManager.setSmallBlind(3000);
		Assert.assertEquals(6000, tableManager.getBigBlind());
	}

	@Test
	public void getHoleCards_inputTwoCardsForPlayer_returnsTwoCards() {
		Player player = new PlayerImp("Ralf");

		tableManager.addPlayer(player);
		tableManager.setHoleCards(player);

		Assert.assertEquals(CardImp.class, tableManager.getHoleCards(player).get(0).getClass());
		Assert.assertEquals(CardImp.class, tableManager.getHoleCards(player).get(1).getClass());
		Assert.assertEquals(2, tableManager.getHoleCards(player).size());
	}

	@Test
	public void getPlayerList_addTwoPlayers_returnsListWithTwoPlayers() {
		tableManager.addPlayer(new PlayerImp("Hans"));
		tableManager.addPlayer(new PlayerImp("Peter"));

		Assert.assertEquals(2, tableManager.getPlayerList().size());
	}

	@Test
	public void getSmallBlind_inputSmallBlindTwoThousand_returnSmallBlindTwoThousand() {
		tableManager.setSmallBlind(2000);
		Assert.assertEquals(2000, tableManager.getSmallBlind());
	}
}
