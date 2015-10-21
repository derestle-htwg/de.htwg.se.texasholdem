package model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

	Card c1;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void getRank_inputHeartThree_returnsThree(){
		c1 = new Card(Card.Rank.THREE, Card.Suit.H);
		Assert.assertEquals(Card.Rank.THREE, c1.getRank());
	}

}
