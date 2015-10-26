package model.imp;

import java.util.LinkedList;

import model.ICard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TableTest {
	
	Deck deck = new Deck(52);
	LinkedList<ICard> cardList = new LinkedList<ICard>();
	

	@Before
	public void _setup() {
		// 1. SetUp
		//Create CardList with 5 Cards
		for (int i=0; i < 5; i++) {
			cardList.add(deck.getCard());
		}
		
		
	}

	@Test
	public void setMiddleCardList() {
		// 2. Exec
		Table table = new Table(cardList);
		table.getMidleCardsList();
		
		// 3. Verify
		Assert.assertNotNull(cardList);
		
	}

}
