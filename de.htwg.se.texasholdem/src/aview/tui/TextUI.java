package aview.tui;

import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.util.observer.IObserver;

public class TextUI implements IObserver {

	private PokerController controller;

	public TextUI(PokerController controller) {
		this.controller = controller;
		controller.addObserver(this);
	}

	private void printTUI() {
		controller.getTableString();
	}

	public void update() {
		printTUI();
	}

}