package model.imp;

import java.util.LinkedList;

import model.Place;

public class PlaceImp implements Place {
	
	private boolean isSmalBlind;
	private boolean isBigBlind;
	private PlayerImp player;
	private LinkedList<CardImp> holecard;
	
	
	public PlaceImp() {
		holecard = new LinkedList<CardImp>();
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
	
	public LinkedList<CardImp> getHolecard() {
		return holecard;
	}
	
	public void setHolecard(LinkedList<CardImp> holecard) {
		this.holecard = holecard;
	}
	
	public PlayerImp getPlayer() {
		return player;
	}
	
	public void setPlayer(PlayerImp player) {
		this.player = player;
	}
	
}
