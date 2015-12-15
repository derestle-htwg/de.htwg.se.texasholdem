package de.htwg.se.texasholdem.controller.imp;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.controller.imp.PlayerManagerImp;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Rank;
import de.htwg.se.texasholdem.model.Suit;

public class PlayerManagerImpTest {

	PlayerManager playerManager;

	@Before
	public void _setup() {
		LinkedList<Player> playerList = new LinkedList<Player>();
		playerManager = new PlayerManagerImp(playerList);
	}

	@Test
	public void getHoleCards_inputTwoCards_returnsTwoCards() {
		Player player = new Player("Gustav");
		playerManager.addPlayer(player);

		Card holeCard1 = new Card(Rank.ACE, Suit.CLUB);
		Card holeCard2 = new Card(Rank.EIGHT, Suit.DIAMOND);

		playerManager.setHoleCard(player, holeCard1);
		playerManager.setHoleCard(player, holeCard2);

		Assert.assertEquals(holeCard1, playerManager.getHoleCards(player).get(0));
		Assert.assertEquals(holeCard2, playerManager.getHoleCards(player).get(1));
	}

	@Test
	public void getPlayerList_inputTwoPlayers_returnsListWithTwoPlayers() {
		playerManager.addPlayer(new Player("Peter"));
		playerManager.addPlayer(new Player("Hans"));

		Assert.assertEquals(2, playerManager.getPlayerList().size());
	}

	@Test
	public void getPlayerMoney_input3000Cash_returns3000Cash() {
		Player player = new Player("Gustav");
		playerManager.addPlayer(player);
		playerManager.setPlayerMoney(player, 3000);
		Assert.assertEquals(3000, playerManager.getPlayerMoney(player));
	}
}
