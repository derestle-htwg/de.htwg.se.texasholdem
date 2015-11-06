package de.htwg.se.texasholdem.controller;

import java.util.LinkedList;

import de.htwg.se.texasholdem.model.Card;
import de.htwg.se.texasholdem.model.Player;

public interface PlayerManager {

	void addPlayer(Player player);

	LinkedList<Card> getHoleCards(Player player);

	LinkedList<Player> getPlayerList();

	void setHoleCard(Player player, Card holeCard);

}
