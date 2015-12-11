package de.htwg.se.texasholdem.aview.tui;

import org.junit.Test;

import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Table;
import de.htwg.se.texasholdem.model.imp.PlayerImp;
import de.htwg.se.texasholdem.model.imp.TableImp;

public class TextUITest {

	Table table;

	@Test
	public void _setup() {
		table = new TableImp();

		Player p1 = new PlayerImp("Dennis");
		Player p2 = new PlayerImp("Dennis");
		Player p3 = new PlayerImp("Dennis");

		table.addPlayer(p1);
		table.addPlayer(p2);
		table.addPlayer(p3);
	}

	@Test
	public void test() {

	}

}
