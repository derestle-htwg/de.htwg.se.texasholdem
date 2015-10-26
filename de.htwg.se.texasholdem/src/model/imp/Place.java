package model.imp;

import java.util.LinkedList;

import model.IPlace;

public class Place implements IPlace {
	
	private boolean isSmalBlind;
	private boolean isBigBlind;
	private Player player;
	private LinkedList<Card> holecard;
	
	
	public Place() {
		
		setPlayer(new Player());
		holecard = new LinkedList<Card>();
	}
	
	public boolean isSmalBlind() {
		return isSmalBlind;
	}
	
	public void setSmalBlind(boolean isSmalBlind) {
		this.isSmalBlind = isSmalBlind;
	}

	public boolean isBigBlind() {
		return isBigBlind;
	}

	public void setBigBlind(boolean isBigBlind) {
		this.isBigBlind = isBigBlind;
	}
	
	public LinkedList<Card> getHolecard() {
		return holecard;
	}
	
	public void setHolecard(LinkedList<Card> holecard) {
		this.holecard = holecard;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
