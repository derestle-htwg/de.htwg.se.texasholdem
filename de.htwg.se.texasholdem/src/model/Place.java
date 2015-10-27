package model;

import java.util.LinkedList;

import model.imp.CardImp;
import model.imp.PlayerImp;

public interface Place {
	
	public boolean isSmalBlind();
	
	public void setSmalBlind(boolean isSmalBlind);

	public boolean isBigBlind();

	public void setBigBlind(boolean isBigBlind);
	
	public LinkedList<CardImp> getHolecard();
	
	public void setHolecard(LinkedList<CardImp> holecard);
	
	public PlayerImp getPlayer();
	
	public void setPlayer(PlayerImp player);

}
