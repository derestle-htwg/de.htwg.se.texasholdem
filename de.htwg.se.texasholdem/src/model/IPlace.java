package model;

import java.util.LinkedList;

import model.imp.Card;
import model.imp.Player;

public interface IPlace {
	
	public boolean isSmalBlind();
	
	public void setSmalBlind(boolean isSmalBlind);

	public boolean isBigBlind();

	public void setBigBlind(boolean isBigBlind);
	
	public LinkedList<Card> getHolecard();
	
	public void setHolecard(LinkedList<Card> holecard);
	
	public Player getPlayer();
	
	public void setPlayer(Player player);

}
