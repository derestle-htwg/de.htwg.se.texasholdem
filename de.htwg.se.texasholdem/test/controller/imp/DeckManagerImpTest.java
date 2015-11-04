package controller.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.controller.DeckManager;
import de.htwg.se.texasholdem.controller.imp.DeckManagerImp;

public class DeckManagerImpTest {

	DeckManager deckManager;

	@Before
	public void _setup() {
		deckManager = new DeckManagerImp();
	}

	@Test
	public void emptyDeck_inputShuffledDeck_emptyList() {
		deckManager.createShuffledDeck();
		deckManager.emptyDeck();

		Assert.assertTrue(deckManager.getDeck().getCards().isEmpty());
	}

	@Test
	public void getDeck_inputNothing_returnsDeckWith52Cards() {
		deckManager.createShuffledDeck();
		Assert.assertEquals(52, deckManager.getDeck().getCards().size());
	}
}
