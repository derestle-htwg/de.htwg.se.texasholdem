package de.htwg.se.texasholdem.model;

import java.util.List;

public class EvaluationObject implements Comparable<EvaluationObject> {

	private boolean split;
	private Player player;
	private List<Card> cards;
	private CardRank ranking;

	public EvaluationObject(Player player) {
		this.player = player;
		this.split = false;
	}

	public Player getPlayer() {
		return this.player;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public CardRank getRanking() {
		return this.ranking;
	}

	public void setRanking(CardRank ranking) {
		this.ranking = ranking;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public boolean equals(Object o){
		return compareTo((EvaluationObject) o) == 0;
	}
	
	@Override
	public int hashCode(){
		return super.hashCode();
	}

	public int compareTo(EvaluationObject e){
		if (this.getRanking().ordinal() < e.getRanking().ordinal()) {
			return 1;
		} else if (this.getRanking().ordinal() == e.getRanking().ordinal()) {
			return 0;
		} else {
			return -1;
		}
	}
	
	
	public boolean isSplit() {
		return this.split;
	}

	public void setPosition(boolean split) {
		this.split = split;
	}

}
