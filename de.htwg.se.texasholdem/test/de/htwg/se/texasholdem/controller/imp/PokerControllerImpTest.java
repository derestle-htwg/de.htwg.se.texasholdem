package de.htwg.se.texasholdem.controller.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.PlayerImp;

public class PokerControllerImpTest {

	private PokerController pokerController;

	private Player p1, p2, p3;

	@Before
	public void _setup() {
		pokerController = new PokerControllerImp();

		p1 = new PlayerImp("Player One");
		p2 = new PlayerImp("Player Two");
		p3 = new PlayerImp("Player Three");

		pokerController.addPlayer(p1);
		pokerController.addPlayer(p2);
		pokerController.addPlayer(p3);

		pokerController.setPlayerActive(p1);
		pokerController.setPlayerActive(p2);
		pokerController.setPlayerActive(p3);
	}

	@Test
	public void clearActivePlayers_inputThreeActivePlayers_clearsActivePlayerList() {
		Assert.assertTrue(pokerController.getActivePlayers().size() != 0);
		pokerController.clearActivePlayers();
		Assert.assertEquals(0, pokerController.getActivePlayers().size());
	}

	@Test
	public void getActivePlayers_inputListWith3ActivePlayer_returnsThreeActivePlayer() {
		Assert.assertEquals(3, pokerController.getActivePlayers().size());
	}

	@Test
	public void getStartPlayer_inputNone_returnsStartPlayer() {
		pokerController.setRandomDealer();

		Assert.assertEquals(PlayerImp.class, pokerController.getDealer().getClass());
		Assert.assertTrue(pokerController.getPlayerList().contains(pokerController.getDealer()));
	}

	@Test
	public void setPlayerNotActive_input3ActivePlayersAndSetOneNotActive_returnsListWithTwoActivePlayers() {
		pokerController.setPlayerNotActive(p2);

		Assert.assertEquals(2, pokerController.getActivePlayers().size());
	}

	@Test
	public void getStartCredits_insertThreeThousandCredits_returnsThreeThousandCredits() {
		int threeThousand = 3000;

		pokerController.setStartCredits(threeThousand);

		Assert.assertEquals(threeThousand, pokerController.getStartCredits());
	}

	@Test
	public void setCreditsToPlayers_inputPlayersAndCreditValue_setsPlayerWithCreditValue() {
		int threeThousand = 3000;

		pokerController.setStartCredits(threeThousand);
		pokerController.setCreditsToplayer();

		Assert.assertEquals(threeThousand, pokerController.getPlayerList().get(0).getPlayerMoney());
	}

	@Test
	public void setBlinds_inputBlindValue_setsSmallBlindAndBigBlind() {
		int smallBlind = 30;

		pokerController.setBlinds(30);

		Assert.assertEquals(smallBlind, pokerController.getSmallBlind());
		Assert.assertEquals(smallBlind * 2, pokerController.getBigBlind());
	}
}