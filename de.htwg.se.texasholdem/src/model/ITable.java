package model;

import java.util.HashMap;
import java.util.LinkedList;

import model.imp.Place;

public interface ITable {
	
	public HashMap<Integer,Place> getPlaceMap();

	public int getPot();

	public void setPot(int pot);
	
	public LinkedList<ICard> getMidleCardsList();

	public void setMidleCardsList(LinkedList<ICard> midleCardsList);

}
