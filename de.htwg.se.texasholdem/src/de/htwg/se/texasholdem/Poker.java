package de.htwg.se.texasholdem;

import de.htwg.se.texasholdem.model.Player;
import de.htwg.se.texasholdem.model.Table;
import de.htwg.se.texasholdem.model.imp.CardImp;
import de.htwg.se.texasholdem.model.imp.PlayerImp;
import de.htwg.se.texasholdem.model.imp.Rank;
import de.htwg.se.texasholdem.model.imp.Suit;
import de.htwg.se.texasholdem.model.imp.TableImp;

public class Poker {

	public static void main(String[] args) {

		Table table = new TableImp();
		Player p1 = new PlayerImp("Dennis");
		Player p2 = new PlayerImp("Max");
		Player p3 = new PlayerImp("Daniel");
		Player p4 = new PlayerImp("Christian");
		Player p5 = new PlayerImp("Blacky");
		Player p6 = new PlayerImp("Ralf");

		table.addPlayer(p1);
		table.addPlayer(p2);
		table.addPlayer(p3);
		table.addPlayer(p4);
		table.addPlayer(p5);
		table.addPlayer(p6);

		p1.setPlayerMoney(1234567);

		p1.setHoleCard(new CardImp(Rank.ACE, Suit.CLUB));
		p1.setHoleCard(new CardImp(Rank.ACE, Suit.DIAMOND));

		String s = table.toString();

		System.out.println(s);
	}

	// PokerController erstellen
	// Erstelle TableManager
	// Erstelle andere Manager

	// Starte TUI / GUI

	// Wie viele Spieler sollen an den Tisch?
	// z.B. 4 Stück

	// Wie sollen die heißen?
	// z.B. "Hans"

	// TUI -> PokerController.addPlayer("Hans")
	// -> TableManager.addPlayer("Hans")
	// -> PlayerManager.addPlayer("Hans")
	// Hans hinzugefügt

	// "SPIELEN"-Button gedrückt

	// ...
}
