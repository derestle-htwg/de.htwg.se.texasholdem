package de.htwg.se.texasholdem;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import aview.tui.TextUI;
import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.controller.imp.PokerControllerImp;;

public class Poker {

	private static Scanner scanner;

	public static void main(String[] args) {
		// Set up logging through log4j
		PropertyConfigurator.configure("log4j.properties");

		PokerController controller = new PokerControllerImp();
		TextUI tui = new TextUI(controller);

		tui.printTUI();

		// continue to read user input on the tui until the user decides to quit
		boolean continu = true;
		scanner = new Scanner(System.in);
		while (continu) {
			continu = tui.processInputLine(scanner.next());
		}
	}
}
