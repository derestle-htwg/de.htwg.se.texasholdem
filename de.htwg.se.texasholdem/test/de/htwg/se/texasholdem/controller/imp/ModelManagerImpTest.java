package de.htwg.se.texasholdem.controller.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.imp.CardImp;
import de.htwg.se.texasholdem.model.imp.PlayerImp;

public class ModelManagerImpTest {

	ModelManager modelManager;
	Player p1, p2, p3;

	@Before
	public void _setup() {
		modelManager = new ModelManagerImp();
		modelManager.resetGame();

		p1 = new PlayerImp("Spieler 1");
		p2 = new PlayerImp("Spieler 2");
		p3 = new PlayerImp("Spieler 3");

		modelManager.addPlayer(p1);
		modelManager.addPlayer(p2);
		modelManager.addPlayer(p3);

		modelManager.setHoleCards(p1);

		for (int i = 0; i < 3; i++) {
			modelManager.addCommunityCard();
		}
	}

	@Test
	public void getBigBlind_inputSmallBlindThreeThousand_returnsBigBlindSixThousand() {
		modelManager.setSmallBlind(3000);
		Assert.assertEquals(6000, modelManager.getBigBlind());
	}

	@Test
	public void getCards_inputTwoCardsForPlayer_returnsTwoCards() {
		Assert.assertEquals(CardImp.class, modelManager.getHoleCards(p1).get(0).getClass());
		Assert.assertEquals(CardImp.class, modelManager.getHoleCards(p1).get(1).getClass());
		Assert.assertEquals(2, modelManager.getHoleCards(p1).size());
	}

	@Test
	public void getCommunityCards_inputThreeCommunityCards_returnsListWithThreeCommunityCards() {

		Assert.assertEquals(3, modelManager.getCommunityCards().size());
	}

	@Test
	public void getPlayerList_addTwoPlayers_returnsListWithTwoPlayers() {
		Assert.assertEquals(3, modelManager.getPlayerList().size());
	}

	@Test
	public void getSmallBlind_inputSmallBlindTwoThousand_returnSmallBlindTwoThousand() {
		modelManager.setSmallBlind(2000);
		Assert.assertEquals(2000, modelManager.getSmallBlind());
	}

	@Test
	public void hasMoney_inputPlayerWithMoney_returnsTrue() {
		modelManager.addPlayer(p1);
		modelManager.setPlayerMoney(p1, 3000);

		Assert.assertTrue(modelManager.hasMoney(p1));
	}

	@Test
	public void hasMoney_inputPlayerWithoutMoney_returnsFalse() {
		modelManager.addPlayer(p1);
		modelManager.setPlayerMoney(p1, 0);

		Assert.assertFalse(modelManager.hasMoney(p1));
	}

	@Test
	public void resetGame_inputPotAndHoleCardsAndShuffledDeckAndCommunityCards_clearsAllListsAndPot() {
		modelManager.setPot(3000);

		Assert.assertFalse(modelManager.getPot() == 0);
		Assert.assertFalse(modelManager.getHoleCards(p1).isEmpty());
		Assert.assertFalse(modelManager.getDeck().getCards().size() == 52);
		Assert.assertFalse(modelManager.getCommunityCards().isEmpty());

		modelManager.resetGame();

		Assert.assertTrue(modelManager.getPot() == 0);
		Assert.assertTrue(modelManager.getHoleCards(p1).isEmpty());
		Assert.assertTrue(modelManager.getDeck().getCards().size() == 52);
		Assert.assertTrue(modelManager.getCommunityCards().isEmpty());
	}

	@Test
	public void getDealer_setDealer_returnsDealerPlayer() {
		modelManager.setDealer(p1);

		Assert.assertEquals(p1, modelManager.getDealer());
	}
}
