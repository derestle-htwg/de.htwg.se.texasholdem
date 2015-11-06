package de.htwg.se.texasholdem.model.imp;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.PlayerManager;
import de.htwg.se.texasholdem.controller.imp.PlayerManagerImp;
import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;

public class PlayerManagerImpTest {

	PlayerManager playerManager;

	@Before
	public void _setup() {
		LinkedList<Player> playerList = new LinkedList<Player>();
		playerManager = new PlayerManagerImp(playerList);
	}

	@Test
	public void getHoleCards_inputTwoCards_returnsTwoCards() {
		LinkedList<Card> holeCards = new LinkedList<Card>();
		holeCards.add(new CardImp(Rank.ACE, Suit.CLUB));
		holeCards.add(new CardImp(Rank.EIGHT, Suit.DIAMOND));

		Player player = new PlayerImp("Gustav");
		playerManager.addPlayer(player);

		playerManager.setHoleCards(player, holeCards);

		Assert.assertEquals(holeCards.get(0), playerManager.getHoleCards(player).get(0));
		Assert.assertEquals(holeCards.get(1), playerManager.getHoleCards(player).get(1));
	}

	@Test
	public void getPlayerList_inputTwoPlayers_returnsListWithTwoPlayers() {
		playerManager.addPlayer(new PlayerImp("Peter"));
		playerManager.addPlayer(new PlayerImp("Hans"));

		Assert.assertEquals(2, playerManager.getPlayerList().size());
	}
}
