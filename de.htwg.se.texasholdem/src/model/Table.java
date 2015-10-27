package model;

import java.util.HashMap;
import java.util.LinkedList;

import model.imp.PlaceImp;

public interface Table {
	
	public HashMap<Integer,PlaceImp> getPlaceMap();

	public int getPot();

	public void setPot(int pot);
	
	public LinkedList<Card> getMidleCardsList();

	public void setMidleCardsList(LinkedList<Card> midleCardsList);

}
