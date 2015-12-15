package de.htwg.se.texasholdem.aview.tui;

import org.junit.Test;

import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Table;
import de.htwg.se.texasholdem.model.Table;

public class TextUITest {

	Table table;

	@Test
	public void _setup() {
		table = new Table();

		Player p1 = new Player("Dennis");
		Player p2 = new Player("Dennis");
		Player p3 = new Player("Dennis");

		table.addPlayer(p1);
		table.addPlayer(p2);
		table.addPlayer(p3);
	}

	@Test
	public void test() {

	}

}
