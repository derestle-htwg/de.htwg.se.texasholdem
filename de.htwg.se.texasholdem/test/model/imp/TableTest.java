package model.imp;

import java.util.LinkedList;

import model.Card;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TableTest {
	
	DeckImp deck = new DeckImp();
	
	LinkedList<Card> cardList = new LinkedList<Card>();

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
		TableImp table = new TableImp(cardList);
		table.getMidleCardsList();
		
		// 3. Verify
		Assert.assertNotNull(cardList);
		
	}

}
