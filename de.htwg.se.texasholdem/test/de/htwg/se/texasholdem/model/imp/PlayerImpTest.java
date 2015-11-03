package de.htwg.se.texasholdem.model.imp;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.model.Card;

public class PlayerImpTest {
	
	private String playerNameOne;
	private String playerNameTwo;
	private String playerNameThree;
	
	
	private PlayerImp playerOne;
	private PlayerImp playerTwo;
	private PlayerImp playerThree;
	
	private CardImp firstCard;
	private CardImp secondCard;
	private LinkedList<Card> holecards;
	
	

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
		
		holecards = new LinkedList<Card>();
		holecards.add(firstCard);
		holecards.add(secondCard);
		
	}

	@Test
	public void getPlayerName_inputPlayerNameOne_returnPlayerNameTwo() {
		Assert.assertEquals(playerNameOne, playerOne.getPlayerName());
	}
	
	@Test
	public void getPlayerName_inputPlayerNameTwo_returnPlayerNameTwo() {
		Assert.assertEquals(playerNameTwo, playerTwo.getPlayerName());
	}
	
	@Test
	public void getPlayerName_inputPlayerNameThree_returnPlayerNameThree() {
		Assert.assertEquals(playerNameThree, playerThree.getPlayerName());
	}
	
	@Test
	public void getPlayerCash_inputPlayerOneCash_returnPlayerOneCash() {
		playerOne.setPlayerMoney(500);
		Assert.assertEquals(500, playerOne.getPlayerMoney());
	}
	
	@Test
	public void getHoleCards_inputHolecardslistToPlayerTwo_returnPlayerTwoHoleCards() {
		playerTwo.setHoleCards(holecards);
		Assert.assertEquals(holecards,playerTwo.getHoleCards());
	}

}
