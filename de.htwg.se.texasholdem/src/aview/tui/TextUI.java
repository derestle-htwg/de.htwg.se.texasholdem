package aview.tui;

import java.awt.Event;
import java.util.Scanner;

import de.htwg.se.texasholdem.controller.GameStatus;
import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.util.observer.IObserver;

public class TextUI implements IObserver {

	private static Scanner scanner;
	private PokerController controller;

	public TextUI(PokerController controller) {
		this.controller = controller;
		controller.addObserver(this);
		scanner = new Scanner(System.in);
	}

	public void printTUI() {
		System.out.println("############################################################");
		System.out.println(controller.getTableString());

		if (controller.getStatus() == GameStatus.INITIALIZATION) {
			System.out.println(
					"Available commands: p - add new Player; b - set Small Blind;  c - set Start Credits; s - start Game");
		} else {
			System.out.println("Available commands: f - fold; c - call; r - raise");
		}

	}

	public void update() {
		printTUI();
	}

	// @Override
	public void update(Event e) {
		printTUI();
	}

	public boolean processInputLine(String line) {
		boolean continu = true;
		if (line.equalsIgnoreCase("p")) {
			System.out.println("Insert player name: ");
			String playerName = scanner.next();
			controller.addPlayer(playerName);
		}

		if (line.equalsIgnoreCase("c")) {
			System.out.println("Insert credits: ");
			int credits = Integer.parseInt(scanner.next());
			controller.setStartCredits(credits);
		}

		if (line.equalsIgnoreCase("b")) {
			System.out.println("Small Blind: ");
			int smallBlind = Integer.parseInt(scanner.next());
			controller.setBlinds(smallBlind);
			;
		}
		if (line.equalsIgnoreCase("s")) {
			controller.startGame();
		}
		return continu;
	}

}