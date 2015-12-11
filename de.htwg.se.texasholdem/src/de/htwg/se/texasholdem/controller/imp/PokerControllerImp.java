package de.htwg.se.texasholdem.controller.imp;

import de.htwg.se.texasholdem.controller.GameManager;
import de.htwg.se.texasholdem.controller.ModelManager;
import de.htwg.se.texasholdem.controller.PokerController;

public class PokerControllerImp implements PokerController {

	private ModelManager modelManager;
	private GameManager gameManager;

	public PokerControllerImp() {
		modelManager = new ModelManagerImp();
		gameManager = new GameManagerImp(modelManager);
	}

	public void initializeGame() {

	}

}
