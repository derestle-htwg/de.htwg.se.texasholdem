package de.htwg.se.texasholdem.model.imp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.texasholdem.model.Player;

public class TableImpTest {
	
	private TableImp table;

	private Player p1, p2, p3;

	@Before
	public void _setup() {
		table = new TableImp();

		p1 = new PlayerImp("Ralf");
		p2 = new PlayerImp("Hugo");
		p3 = new PlayerImp("Peter");

		table.addPlayer(p1);
		table.addPlayer(p2);
		table.addPlayer(p3);
	}

	@Test
	public void addPlayer_inputP1_returnsListWithP1() {
		Assert.assertEquals(p1, table.getPlayerList().get(table.getPlayerList().indexOf(p1)));
	}

	@Test
	public void getNextPlayer_inputPlayerP1_returnsPlayerP2() {
		Assert.assertEquals(p2, table.getNextPlayer(p1));
	}

	@Test
	public void getNextPlayer_inputPlayerP3_returnsPlayerP1() {
		Assert.assertEquals(p1, table.getNextPlayer(p3));
	}

	@Test
	public void getPlayerList_inputListWithThreePlayers_returnsListWithThreePlayers() {

		Assert.assertEquals(3, table.getPlayerList().size());
	}

	@Test
	public void getPotValue_inputPotWithOneThousand_returnsOneThousand() {
		table.setPotValue(1000);
		Assert.assertEquals(1000, table.getPotValue());
	}
	
	@Test
	public void getBigBlindValue_inputBigBlindValue_returnBigBlindValue() {
		table.setBigBlindValue(10);
		Assert.assertEquals(10,  table.getBigBlindValue());
	}
	
	@Test
	public void getSmallBlindValue_inputBigBlindValue_returnSmallBlindValue() {
		table.setBigBlindValue(10);
		table.setSmallBlindValue();
		Assert.assertEquals(5, table.getSmallBlindValue());
	}

}
