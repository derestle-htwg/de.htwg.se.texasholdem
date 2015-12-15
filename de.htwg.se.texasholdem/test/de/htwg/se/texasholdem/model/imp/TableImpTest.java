package de.htwg.se.texasholdem.model.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.DeckManager;
import de.htwg.se.texasholdem.controller.imp.DeckManagerImp;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Table;

public class TableImpTest {

	private Table table;

	private Player p1, p2, p3;

	@Before
	public void _setup() {
		table = new Table();

		p1 = new Player("Ralf");
		p2 = new Player("Hugo");
		p3 = new Player("Peter");

		table.addPlayer(p1);
		table.addPlayer(p2);
		table.addPlayer(p3);

		DeckManager deckManager = new DeckManagerImp();
		deckManager.createShuffledDeck();

		for (int i = 0; i < 3; i++) {
			table.addCommunityCard(deckManager.getDeck().getCard());
		}
	}

	@Test
	public void addPlayer_inputP1_returnsListWithP1() {
		Assert.assertEquals(p1, table.getPlayerList().get(table.getPlayerList().indexOf(p1)));
	}

	@Test
	public void clearCommunityCards_inputThreeCommunityCards_getCommunityCardsIsEmpty() {
		Assert.assertFalse(table.getCommunityCards().isEmpty());

		table.clearCommunityCards();

		Assert.assertTrue(table.getCommunityCards().isEmpty());
	}

	@Test
	public void getBigBlind_inputSmallBlind_returnBigBlind() {
		table.setSmallBlind(10);
		Assert.assertEquals(20, table.getBigBlind());
	}

	@Test
	public void getCommunityCards_inputThreeCommunityCards_returnsListWithThreeCommunityCards() {
		Assert.assertEquals(3, table.getCommunityCards().size());
	}

	@Test
	public void getPlayerList_inputListWithThreePlayers_returnsListWithThreePlayers() {

		Assert.assertEquals(3, table.getPlayerList().size());
	}

	@Test
	public void getPot_inputPotWithOneThousand_returnsOneThousand() {
		table.setPot(1000);
		Assert.assertEquals(1000, table.getPot());
	}

	@Test
	public void getSmallBlind_inputBigBlind_returnSmallBlind() {
		table.setSmallBlind(10);
		Assert.assertEquals(10, table.getSmallBlind());
	}

	@Test
	public void getDealer_setPlayerAsDealer_returnsPlayer() {
		table.setDealer(p1);

		Assert.assertEquals(p1, table.getDealer());
	}

}
