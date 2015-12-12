package aview.tui;

import java.awt.Event;
import java.util.Scanner;

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
		System.out.println("Available commands: n - add new Player; s - start Game");

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
		return continu;
	}

}