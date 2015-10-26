package model.imp;

import java.util.HashMap;
import java.util.LinkedList;

import model.ICard;
import model.ITable;

public class Table implements ITable {
	
	private HashMap<Integer,Place> placeMap;
	LinkedList<ICard> midleCardsList;
	private int Pot;
	
	public Table(LinkedList<ICard> cardList) {
		
		this.placeMap = new HashMap<Integer, Place>();
		
		this.midleCardsList = new LinkedList<ICard>();
		this.midleCardsList = cardList;
		
	}

	public HashMap<Integer,Place> getPlaceMap() {
		return placeMap;
	}

	public int getPot() {
		return Pot;
	}

	public void setPot(int pot) {
		Pot = pot;
	}

	public LinkedList<ICard> getMidleCardsList() {
		return midleCardsList;
	}

	public void setMidleCardsList(LinkedList<ICard> midleCardsList) {
		this.midleCardsList = midleCardsList;
	}


}
