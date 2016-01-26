package de.htwg.se.texasholdem.controller.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.model.Player;

public class PokerControllerImpTest {

	private PokerController pokerController;

	private Player p1, p2, p3;

	@Before
	public void _setup() {
		pokerController = new PokerControllerImp(null);

		p1 = new Player("Player One");
		p2 = new Player("Player Two");
		p3 = new Player("Player Three");

		pokerController.addPlayer("Player One");
		pokerController.addPlayer("Player Two");
		pokerController.addPlayer("Player Three");

		pokerController.setPlayerActive(p1);
		pokerController.setPlayerActive(p2);
		pokerController.setPlayerActive(p3);
		pokerController.startGame();
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
	public void getDealer_inputNone_returnsDealer() {
		pokerController.setRandomDealer();

		Assert.assertEquals(Player.class, pokerController.getDealer().getClass());
		// TODO: FIX
		// Assert.assertTrue(pokerController.getPlayerList().contains(pokerController.getDealer()));
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
		pokerController.setCreditsToPlayer();

		Assert.assertEquals(threeThousand, pokerController.getPlayerList().get(0).getPlayerMoney());
	}

	@Test
	public void setBlinds_inputBlindValue_setsSmallBlindAndBigBlind() {
		int smallBlind = 30;

		pokerController.setBlinds(30);

		Assert.assertEquals(smallBlind, pokerController.getSmallBlind());
		Assert.assertEquals(smallBlind * 2, pokerController.getBigBlind());
	}

	@Test
	public void payBlinds_inputTwoPlayersWithCredits_returnsPaysCreditsFromPlayers() {
		int smallBlind = 30;
		int credits = 100;

		pokerController.setDealer(pokerController.getPlayerList().get(0));
		pokerController.setStartCredits(credits);
		pokerController.setCreditsToPlayer();
		pokerController.setBlinds(smallBlind);
		pokerController.payBlinds();

		Assert.assertEquals(credits - smallBlind, pokerController.getPlayerList().get(1).getPlayerMoney());
		Assert.assertEquals(credits - smallBlind * 2, pokerController.getPlayerList().get(2).getPlayerMoney());
	}

	@Test
	public void getCurrentCallValue_input_returns() {
		int smallBlind = 30;
		int credits = 100;

		pokerController.setDealer(pokerController.getPlayerList().get(0));
		pokerController.setStartCredits(credits);
		pokerController.setBlinds(smallBlind);
		pokerController.startGame();

		Assert.assertEquals(pokerController.getPlayerList().get(0), pokerController.getCurrentPlayer());

		int callValue = pokerController.getCurrentCallValue();

		Assert.assertEquals(smallBlind * 2, callValue);
	}

}