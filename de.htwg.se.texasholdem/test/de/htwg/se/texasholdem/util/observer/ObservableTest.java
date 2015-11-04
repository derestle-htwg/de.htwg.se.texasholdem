package de.htwg.se.texasholdem.util.observer;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObservableTest {
	private boolean ping = false;
	private TestObserver testObserver;
	private IObservable testObservable;
	
	class TestObserver implements IObserver {
		public void update() {
			ping = true;
			
		}
	}
	
	@Before
	public void setUp() throws Exception {
		testObserver = new TestObserver();
		testObservable = new Observable();
		testObservable.addObserver(testObserver);
	}
	
	@Test
	public void notifyObserver_inputPing_returnTrueOrFalse() {
		Assert.assertFalse(ping);
		testObservable.notifyObservers();
		Assert.assertTrue(ping);
	}
	
	@Test
	public void removeObserver_inputPingAndtestObserver_returnTrue() {
		Assert.assertFalse(ping);
		testObservable.removeObserver(testObserver);
		testObservable.notifyObservers();
		Assert.assertFalse(ping);
	}
	
	@Test
	public void removeAllObservers_inputPing_returnTrue() {
		Assert.assertFalse(ping);
		testObservable.removeAllObservers();
		testObservable.notifyObservers();
		Assert.assertFalse(ping);
	}

}
