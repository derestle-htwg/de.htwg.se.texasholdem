package model.imp;

import java.util.HashMap;
import java.util.LinkedList;

import model.Card;
import model.Table;

public class TableImp implements Table {
	
	private HashMap<Integer,PlaceImp> placeMap;
	LinkedList<Card> midleCardsList;
	private int Pot;
	
	public TableImp(LinkedList<Card> cardList) {
		
		this.placeMap = new HashMap<Integer, PlaceImp>();
		
		this.midleCardsList = new LinkedList<Card>();
		this.midleCardsList = cardList;
		
	}

	public HashMap<Integer,PlaceImp> getPlaceMap() {
		return placeMap;
	}

	public int getPot() {
		return Pot;
	}

	public void setPot(int pot) {
		Pot = pot;
	}

	public LinkedList<Card> getMidleCardsList() {
		return midleCardsList;
	}

	public void setMidleCardsList(LinkedList<Card> midleCardsList) {
		this.midleCardsList = midleCardsList;
	}


}
