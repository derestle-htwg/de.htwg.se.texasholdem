package de.htwg.se.texasholdem.model.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.model.Player;

public class PlayerImpTest {

	private String playerNameOne;
	private String playerNameTwo;
	private String playerNameThree;

	private Player playerOne;
	private Player playerTwo;
	private Player playerThree;

	private CardImp firstCard;
	private CardImp secondCard;

	@Before
	public void _setup() {

		playerNameOne = "Anna";
		playerNameTwo = "Gil";
		playerNameThree = "Cloe";

		playerOne = new PlayerImp(playerNameOne);
		playerTwo = new PlayerImp(playerNameTwo);
		playerThree = new PlayerImp(playerNameThree);

		firstCard = new CardImp(Rank.ACE, Suit.HEART);
		secondCard = new CardImp(Rank.ACE, Suit.CLUB);
	}

	@Test
	public void getHoleCards_inputHolecardslistToPlayerTwo_returnPlayerTwoHoleCards() {
		playerTwo.setHoleCard(firstCard);
		playerTwo.setHoleCard(secondCard);
		Assert.assertEquals(firstCard, playerTwo.getHoleCards().get(0));
		Assert.assertEquals(secondCard, playerTwo.getHoleCards().get(1));
	}

	@Test
	public void getPlayerCash_inputPlayerOneCash_returnPlayerOneCash() {
		playerOne.setPlayerMoney(500);
		Assert.assertEquals(500, playerOne.getPlayerMoney());
	}

	@Test
	public void getPlayerName_inputPlayerNameOne_returnPlayerNameTwo() {
		Assert.assertEquals(playerNameOne, playerOne.getPlayerName());
	}

	@Test
	public void getPlayerName_inputPlayerNameThree_returnPlayerNameThree() {
		Assert.assertEquals(playerNameThree, playerThree.getPlayerName());
	}

	@Test
	public void getPlayerName_inputPlayerNameTwo_returnPlayerNameTwo() {
		Assert.assertEquals(playerNameTwo, playerTwo.getPlayerName());
	}

}