package de.htwg.se.texasholdem.util.observer;

public interface IObservable {
	
	public void addObserver(IObserver s);
	public void removeObserver(IObserver s);
	public void removeAllObservers();
	public void notifyObservers();
	
}
