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
	public void getDeck_inputNothing_returnsDeckWith52Cards() {
		Assert.assertEquals(52, deckManager.getShuffledDeck().getCards().size());
	}
}
