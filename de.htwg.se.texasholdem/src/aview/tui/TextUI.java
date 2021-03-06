package aview.tui;

import java.awt.Event;
import java.util.Scanner;

import org.apache.log4j.Logger;

import de.htwg.se.texasholdem.controller.GameStatus;
import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.util.observer.IObserver;

public class TextUI implements IObserver {

	private static Scanner scanner;
	private PokerController controller;

	private Logger logger = Logger.getLogger("de.htwg.se.texasholdem.aview.tui");

	public TextUI(PokerController controller) {
		this.controller = controller;
		controller.addObserver(this);
		scanner = new Scanner(System.in);
	}

	public void printTUI() {
		if (!(controller.getStatus() == GameStatus.INITIALIZATION)) {
			logger.info("############################################################");
			logger.info("Last: " + controller.getLastEvent());
		}

		logger.info("############################################################");
		logger.info(controller.getGameData().getTableString());

		if (controller.getStatus() == GameStatus.INITIALIZATION) {
			logger.info(
					"Available commands: p - add new Player; b - set Small Blind;  c - set Start Credits; s - start Game");
		} else {
			logger.info("Current Phase: " + controller.getBettingStatus() + " Current Player: "
					+ controller.getCurrentPlayer().getPlayerName());
			logger.info("You have to call: " + controller.getCurrentCallValue());
			logger.info("Available commands: f - fold; c - call/check; r - raise");
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

		if (controller.getStatus() == GameStatus.INITIALIZATION) {
			// Add new Player
			if (line.equalsIgnoreCase("p")) {
				logger.info("Insert player name: ");
				String playerName = scanner.next();
				controller.addPlayer(playerName);
			}

			// Set Start Credits
			if (line.equalsIgnoreCase("c")) {
				logger.info("Insert credits: ");
				int credits = Integer.parseInt(scanner.next());
				controller.setStartCredits(credits);
			}

			// Set Blinds
			if (line.equalsIgnoreCase("b")) {
				logger.info("Small Blind: ");
				int smallBlind = Integer.parseInt(scanner.next());
				controller.setBlinds(smallBlind);
				;
			}

			// Start Game
			if (line.equalsIgnoreCase("s")) {
				controller.startGame();
			}
		} else {
			// Fold
			if (line.equalsIgnoreCase("f")) {
				controller.fold();
			}

			// Call
			if (line.equalsIgnoreCase("c")) {
				controller.call();
			}

			// Raise
			if (line.equalsIgnoreCase("r")) {
				logger.info("Raise value: ");
				int credits = Integer.parseInt(scanner.next());
				controller.raise(credits);
			}
		}
		return continu;
	}

}